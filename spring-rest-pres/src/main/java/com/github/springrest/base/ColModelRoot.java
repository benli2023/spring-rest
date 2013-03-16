package com.github.springrest.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester3.annotations.rules.CallParam;
import org.apache.commons.digester3.annotations.rules.ObjectCreate;
import org.apache.commons.digester3.annotations.rules.SetNext;

public class ColModelRoot {

	private final String id;

	private final Map<String, ColModelProfile> map;

	private ColModelProfile defaulColModelProfile = null;

	@ObjectCreate(pattern = "column-models")
	public ColModelRoot(
			@CallParam(pattern = "column-models", attributeName = "id") String id) {
		super();
		this.id = id;
		map = new HashMap<String, ColModelProfile>(3);
	}

	@SetNext()
	public void addColModelProfile(ColModelProfile colModelProfile) {
		map.put(colModelProfile.getProfileId(), colModelProfile);
		if (colModelProfile.isDefault())
			defaulColModelProfile = colModelProfile;
	}

	public String getId() {
		return id;
	}

	public ColModelProfile getProfile(String profileId) {
		if (profileId == null || profileId.trim().length() == 0) {
			return defaulColModelProfile;
		}
		return map.get(profileId);
	}

}
