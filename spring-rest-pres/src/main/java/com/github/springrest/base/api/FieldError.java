package com.github.springrest.base.api;

public class FieldError {

	private String fieldName;

	private String[] errorCodes;

	private String errorMessages;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String[] getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(String[] errorCodes) {
		this.errorCodes = errorCodes;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}


}
