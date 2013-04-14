package com.github.springrest.base;

import java.util.List;

public class PopupTableParam {
	private String fieldId;
	private String width;
	private String height;
	private String profileId;
	private String limit;
	private String dataSource;
	private String title;
	
	private List<ColModel> colModelList;
	

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ColModel> getColModelList() {
		return colModelList;
	}

	public void setColModelList(List<ColModel> colModelList) {
		this.colModelList = colModelList;
	}
	
}
