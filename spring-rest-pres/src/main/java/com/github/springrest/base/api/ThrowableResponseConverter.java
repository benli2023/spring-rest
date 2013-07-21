package com.github.springrest.base.api;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

import com.github.springrest.constants.ControllerConstants;

public class ThrowableResponseConverter implements Converter<Throwable, Response> {

	private final Log ERRORLOG = LogFactory.getLog(ThrowableResponseConverter.class);

	public Response convert(Throwable source) {
		Throwable t = source;
		if (source instanceof InvocationTargetException) {
			InvocationTargetException invoke = (InvocationTargetException) source;
			t = invoke.getCause();
		}
		ERRORLOG.error(t.getMessage(), t);
		Response response = new Response();
		response.setStatusCode(ControllerConstants.AJAX_GENERIC_ERROR);
		response.setGenericError(t.getMessage());
		return response;
	}

}
