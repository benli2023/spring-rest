package com.github.springrest.base.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.github.springrest.constants.ControllerConstants;

public class BindingResultResponseConverter implements Converter<BindingResult, Response> {

	private MessageSource messageSource;

	public Response convert(BindingResult errors) {
		Response response = new Response();
		if (errors.hasErrors()) {
			response.setStatusCode(ControllerConstants.AJAX_WARNING_CODE);
			ValidationError validationError = new ValidationError();
			// global error
			ObjectError objectError = errors.getGlobalError();
			if (objectError != null) {
				GlobalError globalError = new GlobalError();
				validationError.setGlobalError(globalError);
				String globalMessage = messageSource.getMessage(objectError, Locale.CHINESE);
				globalError.setErrorCode(objectError.getCodes());
				globalError.setErrorMessage(globalMessage);
				globalError.setObjectName(objectError.getObjectName());
			}

			// field errors
			List<org.springframework.validation.FieldError> fieldErrors = errors.getFieldErrors();
			if (fieldErrors != null && fieldErrors.size() > 0) {
				List<FieldError> validationFieldErrors = new ArrayList<FieldError>(fieldErrors.size());
				for (org.springframework.validation.FieldError fe : fieldErrors) {
					FieldError fieldError = new FieldError();
					fieldError.setErrorCodes(fe.getCodes());
					fieldError.setFieldName(fe.getField());
					String fieldMessage = messageSource.getMessage(fe, Locale.CHINESE);
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
