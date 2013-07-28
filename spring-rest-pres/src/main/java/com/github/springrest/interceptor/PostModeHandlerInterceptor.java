package com.github.springrest.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.github.springrest.constants.ControllerConstants;

public class PostModeHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			String postMode = request.getParameter(ControllerConstants.POST_MODE);
			Map<String, Object> modelMap = modelAndView.getModel();
			if (StringUtils.hasLength(postMode)) {
				modelMap.put(ControllerConstants.POST_MODE, postMode);
			} else if (StringUtils.hasLength((String) request.getAttribute(ControllerConstants.POST_MODE))) {

			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String postMode = request.getParameter(ControllerConstants.POST_MODE);
		if (StringUtils.hasLength(postMode)) {
			request.setAttribute(ControllerConstants.POST_MODE, postMode);
		} else if (StringUtils.hasLength((String) request.getAttribute(ControllerConstants.POST_MODE))) {

		}
		return super.preHandle(request, response, handler);
	}


}
