package com.github.springrest.base;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class SessionHelper {
	public static final String SESSION_USER = "SESSION_USER";

	public static UserContext getLoginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserContext userContext = (UserContext) session.getAttribute(SESSION_USER);
		if (userContext == null) {
			throw new IllegalStateException("no session user exists.");
		}
		return userContext;
	}

	public static boolean isLogon(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserContext userContext = (UserContext) session.getAttribute(SESSION_USER);
		return userContext != null;
	}

	public static long retrieveCurrentUserId(HttpServletRequest request) {
		UserContext context = getLoginUser(request);
		return context.getLoginId();
	}

	public static void login(long loginId, String loginName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(SESSION_USER);
		UserContext userContext = new UserContext();
		userContext.setLastLoginTime(new Date());
		userContext.setLoginId(loginId);
		userContext.setLoginName(loginName);
		session.setAttribute(SESSION_USER, userContext);
	}

	public static void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(SESSION_USER);

	}

}