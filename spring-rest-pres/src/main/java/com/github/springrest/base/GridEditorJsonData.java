package com.github.springrest.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridEditorJsonData <T> implements Serializable{
	private static final long serialVersionUID = 2296698691380239106L;
	private List<T> update;
	private List<T> insert;
	private List<T> delete;
	
	public GridEditorJsonData() {
		super();
		update=new ArrayList<T>();
		insert=new ArrayList<T>();
		delete=new ArrayList<T>();
	}
	
	public List<T> getUpdate() {
		return update;
	}
	public void setUpdate(List<T> update) {
		this.update = update;
	}
	public List<T> getInsert() {
		return insert;
	}
	public void setInsert(List<T> insert) {
		this.insert = insert;
	}
	public List<T> getDelete() {
		return delete;
	}
	public void setDelete(List<T> delete) {
		this.delete = delete;
	}

	
	

}
