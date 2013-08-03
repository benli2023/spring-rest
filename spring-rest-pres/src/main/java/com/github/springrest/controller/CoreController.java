package com.github.springrest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.github.springrest.model.Authentication;

@Controller
@RequestMapping("/core")
public class CoreController implements InitializingBean {

	@Autowired(required = true)
	@Qualifier("applicationIndexUri")
	private String applicationIndexUri;

	private AuthenticationService authenticationService;

	private static final String LOGON_PAGE = "/core/logon";

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
		model.addAttribute("authentication", authentication);
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
		if (errors.hasErrors()) {
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
			StringBuilder builder = new StringBuilder(128);
			builder.append(REDIRECT);
			builder.append(urltoGo);
			return builder.toString();
		} else {
			return this.getIndexURL();
		}
	}

	public void setApplicationIndexUri(String applicationIndexUri) {
		this.applicationIndexUri = applicationIndexUri;
	}

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.state(StringUtils.hasLength(applicationIndexUri), "applicationIndexUri can not be empty.");
		Assert.state(authenticationService != null, "authenticationService can not be null.");

	}

}
