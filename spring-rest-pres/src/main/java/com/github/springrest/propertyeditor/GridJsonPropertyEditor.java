package com.github.springrest.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.github.springrest.base.GridEditorJsonData;

public class GridJsonPropertyEditor<T> extends PropertyEditorSupport {

	private ObjectMapper objectMapper = null;

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsText() {
		GridEditorJsonData<T> data = (GridEditorJsonData<T>) this.getValue();
		String result = null;
		try {
			result = objectMapper.writeValueAsString(data);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public void setAsText(String jsonContent) throws IllegalArgumentException {
		GridEditorJsonData<T> data = null;
		try {
			data = objectMapper.readValue(jsonContent, new TypeReference<GridEditorJsonData<T>>() {
			});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setValue(data);
	}

}
