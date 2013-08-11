package com.github.springrest.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.springrest.auth.AuthenticationService;
import com.github.springrest.base.SessionHelper;
import com.github.springrest.interceptor.UserSessionInterceptor;
import com.github.springrest.logging.LogHelper;
import com.github.springrest.model.Authentication;

@Controller
@RequestMapping("/core")
public class CoreController implements InitializingBean {

	@Autowired(required = true)
	@Qualifier("applicationIndexUri")
	private String applicationIndexUri;

	private AuthenticationService authenticationService;

	private static final String LOGON_PAGE = "/core/logon";

	@Autowired(required = true)
	@Qualifier("autoLogonAuth")
	private Authentication autoLogonAuth;

	@Value("${core.autologon.enable}")
	private boolean autoLogon = false;

	private static final String REDIRECT = "redirect:";

	private String getIndexURL() {
		StringBuilder builder = new StringBuilder(REDIRECT.length() + applicationIndexUri.length());
		builder.append(REDIRECT);
		builder.append(applicationIndexUri);
		return builder.toString();
	}

	/** 进入登录 */
	@RequestMapping(value = "/logon", method = RequestMethod.GET)
	public String _logon(ModelMap model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (this.autoLogon) {
			model.addAttribute("authentication", autoLogonAuth);
		} else {
			model.addAttribute("authentication", authentication);
		}
		model.addAttribute("autoLogon", autoLogon);
		return LOGON_PAGE;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request, Authentication authentication, HttpServletResponse response) {
		model.addAttribute("authentication", authentication);
		SessionHelper.logout(request);
		StringBuilder builder = new StringBuilder(REDIRECT.length() + LOGON_PAGE.length());
		builder.append(REDIRECT);
		builder.append(LOGON_PAGE);
		return builder.toString();
	}

	/** 登录 */
	@RequestMapping(value = "/logon", method = RequestMethod.POST)
	public String logon(ModelMap model, @Valid Authentication authentication, BindingResult errors, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (this.autoLogon) {
			authentication.setCredential(this.autoLogonAuth.getCredential());
			authentication.setPrincipal(this.autoLogonAuth.getPrincipal());
		}
		if (!autoLogon && errors.hasErrors()) {
			model.addAttribute("authentication", authentication);
			return LOGON_PAGE;
		}
		boolean success = authenticationService.authenticate(authentication);
		if (!success) {
			errors.reject("userNotFound", "the user can not be found or the password is wrong .");
			return LOGON_PAGE;
		} else {
			SessionHelper.login(authentication.getSubjectId(), authentication.getPrincipal(), request);
		}
		String urltoGo = request.getParameter(UserSessionInterceptor.REQUES_URI_PARAM);
		if (StringUtils.hasLength(urltoGo)) {
			int qIndex = urltoGo.indexOf(UserSessionInterceptor.QUESTION);
			if (qIndex > 0) {
				ParsedReuslt parsedResult = parseURL(urltoGo.substring(qIndex + 1));
				String method = parsedResult.getMethod();
				if (!method.equalsIgnoreCase("GET")) {
					// other method,"PUT" "POST"
					String actionURL = urltoGo.substring(0, qIndex);
					StringBuilder buildForm = new StringBuilder(512);
					buildForm.append("<html>");
					buildForm.append("<body onload='document.forms[\"form\"].submit()'>");
					buildForm.append(String.format("<form name='form' action='%s' method='%s'>", actionURL, method));
					for (KeyValue kv : parsedResult.getKeyvals()) {
						buildForm.append(String.format("<input type='hidden' name='%s' value='%s' />", kv.getKey(), kv.getValue()));
					}
					buildForm.append("</form>");
					buildForm.append("</body>");
					buildForm.append("</html>");

					if (LogHelper.isDebugEnable(CoreController.class)) {
						LogHelper.debug(CoreController.class, "logon", "redirect form:" + buildForm.toString());
					}

					PrintWriter writer = response.getWriter();
					writer.print(buildForm.toString());
					return null;

				} else {
					StringBuilder builder = new StringBuilder(REDIRECT.length() + urltoGo.length());
					builder.append(REDIRECT);
					int methodIndex = urltoGo.lastIndexOf(UserSessionInterceptor.REQUEST_METHOD);
					if (methodIndex > 0) {
						int andIndex = urltoGo.indexOf(UserSessionInterceptor.AND, methodIndex + 1);
						if (andIndex > 0) {
							builder.append(urltoGo.substring(0, methodIndex));
							builder.append(urltoGo.substring(andIndex + 1));
						} else {
							builder.append(urltoGo.substring(0, methodIndex - 1));
						}
					} else {
						builder.append(urltoGo);
					}
					return builder.toString();
				}

			} else {
				StringBuilder builder = new StringBuilder(128);
				builder.append(REDIRECT);
				builder.append(urltoGo);
				return builder.toString();
			}

		} else {
			return this.getIndexURL();
		}
	}

	public ParsedReuslt parseURL(String queryStr) {
		ParsedReuslt parsedResult = new ParsedReuslt();
		List<KeyValue> list = new ArrayList<KeyValue>(3);
		String[] keyvals = queryStr.split(UserSessionInterceptor.AND);
		for (String keyval : keyvals) {
			int eqaulIndex = keyval.indexOf(UserSessionInterceptor.EQUAL);
			String key = keyval.substring(0, eqaulIndex);
			String val = null;
			if (keyval.length() > eqaulIndex + 1) {
				val = keyval.substring(eqaulIndex + 1);
			}
			if (StringUtils.hasLength(val)) {
				if (key.equals(UserSessionInterceptor.REQUEST_METHOD)) {
					parsedResult.setMethod(val);
				} else {
					KeyValue keyValObj = new KeyValue();
					keyValObj.setKey(key);
					keyValObj.setValue(val);
					list.add(keyValObj);
				}
			}
		}
		parsedResult.setKeyvals(list);
		return parsedResult;
	}

	public void setApplicationIndexUri(String applicationIndexUri) {
		this.applicationIndexUri = applicationIndexUri;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void setAutoLogon(boolean autoLogon) {
		this.autoLogon = autoLogon;
	}

	public void setAutoLogonAuth(Authentication autoLogonAuth) {
		this.autoLogonAuth = autoLogonAuth;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.state(StringUtils.hasLength(applicationIndexUri), "applicationIndexUri can not be empty.");
		Assert.state(authenticationService != null, "authenticationService can not be null.");
	}

	class ParsedReuslt {

		private String method;

		private List<KeyValue> keyvals;

		public String getMethod() {
			return method;
		}

		public void setMethod(String method) {
			this.method = method;
		}

		public List<KeyValue> getKeyvals() {
			return keyvals;
		}

		public void setKeyvals(List<KeyValue> keyvals) {
			this.keyvals = keyvals;
		}

	}

	class KeyValue {

		private String key;

		private String value;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "KeyValue [key=" + key + ", value=" + value + "]";
		}

	}

}
