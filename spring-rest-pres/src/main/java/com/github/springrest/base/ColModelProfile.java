package com.github.springrest.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

public class ColModelProfile implements Serializable, Cloneable {

	private static final long serialVersionUID = -857303626203853929L;

	private final String profileId;
	
	private final boolean _default;

	private final List<ColModel> colModels = new ArrayList<ColModel>(5);

	@ObjectCreate(pattern = "column-models/profile")
	public ColModelProfile(
			@CallParam(pattern = "column-models/profile", attributeName = "id") String profileId,@CallParam(pattern = "column-models/profile", attributeName = "default")boolean _default) {
		super();
		this.profileId = profileId;
		this._default=_default;
	}
	
	public String getProfileId() {
		return profileId;
	}

	public List<ColModel> getColModels() {
		return colModels;
	}

	@SetNext()
	public void addModel(ColModel colModel) {
		colModels.add(colModel);
	}

	public boolean isDefault() {
		return _default;
	}

	

}
