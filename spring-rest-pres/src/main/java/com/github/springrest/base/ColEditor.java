package com.github.springrest.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

public class ColEditor {
	private final  List<EditorRule> rules=new ArrayList<EditorRule>(3);
	private final String type;
	private final boolean editable;
	private final String name;
	
	@ObjectCreate(pattern = "column-models/profile/column-model/editor")
	public ColEditor(
			@CallParam(pattern = "column-models/profile/column-model/editor/type") String type, 
			@CallParam(pattern = "column-models/profile/column-model/editor/editable")boolean editable, 
			@CallParam(pattern = "column-models/profile/column-model/editor/name")String name) {
		super();
		this.type = type;
		this.editable = editable;
		this.name = name;
	}
	
	@SetNext()
	public void addRule(EditorRule rule) {
		rules.add(rule);
	}
	
	public List<EditorRule> getRules() {
		return rules;
	}
	public String getType() {
		return type;
	}
	public boolean isEditable() {
		return editable;
	}
	public String getName() {
		return name;
	}
	
	

}
