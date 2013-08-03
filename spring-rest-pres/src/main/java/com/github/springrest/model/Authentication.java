package com.github.springrest.model;

import org.hibernate.validator.constraints.NotBlank;

public class Authentication {

	private long subjectId;

	@NotBlank
	private String principal;

	@NotBlank
	private String credential;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

}
