package com.github.springrest.base.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.github.springrest.base.Converter;
import com.github.springrest.constants.ControllerConstants;

public class BindingResultResponseConverter implements Converter<BindingResult, Response> {

	private MessageSource messageSource;

	public Response convert(BindingResult errors, HttpServletRequest request, HttpServletResponse servletresponse) {
		Response response = new Response();
		if (errors.hasErrors()) {
			response.setStatusCode(ControllerConstants.AJAX_WARNING_CODE);
			ValidationError validationError = new ValidationError();
			// global error
			ObjectError objectError = errors.getGlobalError();
			if (objectError != null) {
				GlobalError globalError = new GlobalError();
				validationError.setGlobalError(globalError);
				LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
				if (localeResolver == null) {
					throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
				}
				String globalMessage = messageSource.getMessage(objectError, localeResolver.resolveLocale(request));
				globalError.setErrorMessage(globalMessage);
				globalError.setObjectName(objectError.getObjectName());
			}

			// field errors
			List<org.springframework.validation.FieldError> fieldErrors = errors.getFieldErrors();
			if (fieldErrors != null && fieldErrors.size() > 0) {
				List<FieldError> validationFieldErrors = new ArrayList<FieldError>(fieldErrors.size());
				for (org.springframework.validation.FieldError fe : fieldErrors) {
					FieldError fieldError = new FieldError();
					fieldError.setFieldName(fe.getField());
					LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
					if (localeResolver == null) {
						throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
					}
					String fieldMessage = messageSource.getMessage(fe, localeResolver.resolveLocale(request));
					fieldError.setErrorMessages(fieldMessage);
					validationFieldErrors.add(fieldError);
				}
				validationError.setFieldErrors(validationFieldErrors);
			}
			response.setValidationError(validationError);

		} else {
			response.setStatusCode(ControllerConstants.AJAX_SUCCESS_CODE);
		}
		return response;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
