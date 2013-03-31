package com.github.springrest.util;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.github.springrest.base.GridEditorJsonData;
import com.github.springrest.propertyeditor.GridJsonPropertyEditor;

public class GridJsonWebBindingInitializer implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		binder.registerCustomEditor(GridEditorJsonData.class, new GridJsonPropertyEditor());

	}

}
