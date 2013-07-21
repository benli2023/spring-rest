package com.github.springrest.util;

import org.springframework.validation.BindingResult;

import com.github.springrest.base.BaseManager;
import com.github.springrest.base.api.BindingResultResponseConverter;
import com.github.springrest.base.api.Response;
import com.github.springrest.base.api.ThrowableResponseConverter;
import com.github.springrest.constants.ControllerConstants;

public class AjaxHelper {

	private BindingResultResponseConverter bindingResultResponseConverter;

	private ThrowableResponseConverter throwableResponseConverter;

	public <E, M extends BaseManager<E, Long>> Response save(M baseManager, E entity, BindingResult errors) {
		if (errors.hasErrors()) {
			return bindingResultResponseConverter.convert(errors);
		}
		try {
			baseManager.save(entity);
		} catch (Throwable t) {
			return throwableResponseConverter.convert(t);
		}
		Response ajaxresponse = new Response();
		ajaxresponse.setStatusCode(ControllerConstants.AJAX_SUCCESS_CODE);
		return ajaxresponse;
	}

	public void setBindingResultResponseConverter(BindingResultResponseConverter bindingResultResponseConverter) {
		this.bindingResultResponseConverter = bindingResultResponseConverter;
	}

	public void setThrowableResponseConverter(ThrowableResponseConverter throwableResponseConverter) {
		this.throwableResponseConverter = throwableResponseConverter;
	}

}
