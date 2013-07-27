package com.github.springrest.base.api;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ValidationError {

	private GlobalError globalError;

	private List<FieldError> fieldErrors;

	public GlobalError getGlobalError() {
		return globalError;
	}

	public void setGlobalError(GlobalError globalError) {
		this.globalError = globalError;
	}

	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}


}
