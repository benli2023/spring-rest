package com.github.springrest.base;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;

public class EditorRule {
	private final String method;
	private final String value;
	private final String message;
	private final String customValidator;
	
	@ObjectCreate(pattern = "column-models/profile/column-model/editor/rules/rule")
	public EditorRule(
			@CallParam(pattern = "column-models/profile/column-model/editor/rules/rule/method")String method, 
			@CallParam(pattern = "column-models/profile/column-model/editor/rules/rule/value")String value, 
			@CallParam(pattern = "column-models/profile/column-model/editor/rules/rule/message")String message,
			@CallParam(pattern = "column-models/profile/column-model/editor/rules/rule/customValidator")String customValidator) {
		super();
		this.method = method;
		this.value = value;
		this.message = message;
		this.customValidator=customValidator;
	}
	public String getMethod() {
		return method;
	}
	public String getValue() {
		return value;
	}
	public String getMessage() {
		return message;
	}
	public String getCustomValidator() {
		return customValidator;
	}
	
}
