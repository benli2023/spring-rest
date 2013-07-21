package com.github.springrest.base.api;

public class Response {

	private String statusCode;

	private ValidationError validationError;

	private String genericError;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public ValidationError getValidationError() {
		return validationError;
	}

	public void setValidationError(ValidationError validationError) {
		this.validationError = validationError;
	}

	public String getGenericError() {
		return genericError;
	}

	public void setGenericError(String genericError) {
		this.genericError = genericError;
	}


}
