package com.github.springrest.base;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

public class ColModel {

	private final String header;
	private final String name;
	private final String width;
	private final String align;
	private ColEditor editor;
	@ObjectCreate(pattern = "column-models/profile/column-model")
	public ColModel(
			@CallParam(pattern = "column-models/profile/column-model/header") String header,
			@CallParam(pattern = "column-models/profile/column-model/name") String name,
			@CallParam(pattern = "column-models/profile/column-model/width") String width,
			@CallParam(pattern = "column-models/profile/column-model/align") String align) {
		super();
		this.header = header;
		this.name = name;
		this.width = width;
		this.align = align;
	}

	public String getHeader() {
		return header;
	}

	public String getName() {
		return name;
	}

	public String getWidth() {
		return width;
	}

	public String getAlign() {
		return align;
	}

	public ColEditor getEditor() {
		return editor;
	}
	@SetNext()
	public void setEditor(ColEditor editor) {
		this.editor = editor;
	}
	

}
