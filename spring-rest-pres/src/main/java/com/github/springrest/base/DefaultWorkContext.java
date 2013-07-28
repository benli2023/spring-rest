package com.github.springrest.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultWorkContext implements Context {

	private HttpServletRequest servletRequest;

	private HttpServletResponse servletResponse;

	public DefaultWorkContext(HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		super();
		this.servletRequest = servletRequest;
		this.servletResponse = servletResponse;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public HttpServletResponse getServletResponse() {
		return servletResponse;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}



}
