package com.github.springrest.base.api;

public class GlobalError {

	private String objectName;

	private String errorMessage;

	private String[] errorCode;


	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String[] getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String[] errorCode) {
		this.errorCode = errorCode;
	}


}
