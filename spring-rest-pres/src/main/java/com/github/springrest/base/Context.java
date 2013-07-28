package com.github.springrest.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Context {

	HttpServletRequest getServletRequest();

	HttpServletResponse getServletResponse();


}
