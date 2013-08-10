package com.github.springrest.interceptor;

import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.github.springrest.base.SessionHelper;

public class UserSessionInterceptor extends HandlerInterceptorAdapter implements InitializingBean {

	private List<String> ignoreUrls = null;

	private String logonUri = null;

	private String urlEncoding = null;

	public static final String REQUES_URI_PARAM = "redirectURL";

	public static final String REQUEST_METHOD = "_reqMethod";

	public static final String QUESTION = "?";

	public static final String EQUAL = "=";

	public static final String AND = "&";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		if (ignoreUrls.contains(requestUri)) {
			return true;
		}
		boolean isLogon = SessionHelper.isLogon(request);
		if (!isLogon) {
			StringBuilder requestURLBuilder = new StringBuilder(256);
			requestURLBuilder.append(requestUri);
			Enumeration<?> paramEnum = request.getParameterNames();
			String method = request.getMethod();
			boolean first = true;
			while (paramEnum.hasMoreElements()) {
				String paramKey = (String) paramEnum.nextElement();
				String[] values = request.getParameterValues(paramKey);
				if (values != null && values.length > 0) {
					for (String value : values) {
						if (StringUtils.hasLength(value)) {
							if (first) {
								requestURLBuilder.append(QUESTION);
							} else {
								requestURLBuilder.append(AND);
							}
							requestURLBuilder.append(paramKey);
							requestURLBuilder.append(EQUAL);
							requestURLBuilder.append(value);
							first = false;
						}
					}
				}
			}
			if (first) {
				requestURLBuilder.append(QUESTION);
			} else {
				requestURLBuilder.append(AND);
			}
			requestURLBuilder.append(REQUEST_METHOD);
			requestURLBuilder.append(EQUAL);
			requestURLBuilder.append(method);

			String encodedUrl = URLEncoder.encode(requestURLBuilder.toString(), urlEncoding);
			StringBuilder builder = new StringBuilder(256);
			builder.append(logonUri);
			builder.append(QUESTION);
			builder.append(REQUES_URI_PARAM);
			builder.append(EQUAL);
			builder.append(encodedUrl);
			response.sendRedirect(builder.toString());
		}
		return isLogon;

	}

	public List<String> getIgnoreUrls() {
		return ignoreUrls;
	}

	public String getLogonUri() {
		return logonUri;
	}

	public void setLogonUri(String logonUri) {
		this.logonUri = logonUri;
	}

	public void setIgnoreUrls(List<String> ignoreUrls) {
		this.ignoreUrls = ignoreUrls;
	}

	public void setUrlEncoding(String urlEncoding) {
		this.urlEncoding = urlEncoding;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.state(ignoreUrls != null, "ignoreUrls cannot be null.");
		Assert.state(StringUtils.hasLength(logonUri), "logonUri cannot be empty.");
		Assert.state(StringUtils.hasLength(urlEncoding), "urlEncoding cannot be empty.");

	}

}
