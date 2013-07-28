package com.github.springrest.util;

import org.springframework.validation.BindingResult;

import com.github.springrest.base.BaseEntity;
import com.github.springrest.base.BaseManager;
import com.github.springrest.base.Context;
import com.github.springrest.base.api.BindingResultResponseConverter;
import com.github.springrest.base.api.Response;
import com.github.springrest.base.api.ThrowableResponseConverter;
import com.github.springrest.constants.ControllerConstants;

public class AjaxHelper {

	private BindingResultResponseConverter bindingResultResponseConverter;

	private ThrowableResponseConverter throwableResponseConverter;


	public <E extends BaseEntity, M extends BaseManager<E, Long>> Response save(M baseManager, E entity, BindingResult errors, Context context) {
		if (errors.hasErrors()) {
			return bindingResultResponseConverter.convert(errors, context.getServletRequest(), context.getServletResponse());
		}
		try {
			baseManager.save(context, entity);
		} catch (Throwable t) {
			return throwableResponseConverter.convert(t);
		}
		Response ajaxresponse = new Response();
		ajaxresponse.setStatusCode(ControllerConstants.AJAX_SUCCESS_CODE);
		return ajaxresponse;
	}

	public <E extends BaseEntity, M extends BaseManager<E, Long>> Response update(M baseManager, E entity, BindingResult errors, Context context) {
		if (errors.hasErrors()) {
			return bindingResultResponseConverter.convert(errors, context.getServletRequest(), context.getServletResponse());
		}
		try {
			baseManager.update(context, entity);
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
