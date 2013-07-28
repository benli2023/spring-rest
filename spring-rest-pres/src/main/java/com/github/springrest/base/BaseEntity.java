package com.github.springrest.base;

import org.codehaus.jackson.map.annotate.JsonSerialize;


/**
 * @author badqiu
 */
public class BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7200095849148417467L;

	protected static final String DATE_FORMAT = "yyyy-MM-dd";
	
	protected static final String TIME_FORMAT = "HH:mm:ss";
	
	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	/**
	 * 更新时间 db_column: updateDate
	 */

	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date updateDate;

	/**
	 * 创建时间 db_column: createdDate
	 */

	@JsonSerialize(using = JsonDateSerializer.class)
	private java.util.Date createdDate;

	private java.lang.Long updateId;
	private String updateIdTxt;

	private java.lang.Long createId;
	private String createIdTxt;

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public java.util.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}

	public java.lang.Long getUpdateId() {
		return updateId;
	}

	public void setUpdateId(java.lang.Long updateId) {
		this.updateId = updateId;
	}

	public String getUpdateIdTxt() {
		return updateIdTxt;
	}

	public void setUpdateIdTxt(String updateIdTxt) {
		this.updateIdTxt = updateIdTxt;
	}

	public java.lang.Long getCreateId() {
		return createId;
	}

	public void setCreateId(java.lang.Long createId) {
		this.createId = createId;
	}

	public String getCreateIdTxt() {
		return createIdTxt;
	}

	public void setCreateIdTxt(String createIdTxt) {
		this.createIdTxt = createIdTxt;
	}
	
}
