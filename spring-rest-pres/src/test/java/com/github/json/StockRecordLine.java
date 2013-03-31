/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */

package com.github.json;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.github.springrest.base.JsonDateSerializer;

import java.util.*;

import com.github.springrest.base.*;
import com.github.springrest.util.*;
import org.codehaus.jackson.annotate.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;


/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


public class StockRecordLine extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "StockRecordLine";
	public static final String ALIAS_STOCK_OPER_DETAIL_ID = "业务单明细";
	public static final String ALIAS_STOCK_OPERATION_ID = "业务单ID";
	public static final String ALIAS_PRODUCT_ID = "产品";
	public static final String ALIAS_PRICE = "价格";
	public static final String ALIAS_QUANTITY = "出库数量";
	public static final String ALIAS_HAVE_INVOICE = "是否有发票";
	public static final String ALIAS_INVOICE_NUMBER = "发票号码";
	
	//date formats
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
    /**
     * 业务单明细       db_column: stock_oper_detail_id 
     */ 	
	
	
	
	private java.lang.Long stockOperDetailId;
	
	
	private java.lang.Long stockOperationId;
	private String stockOperationIdTxt;
	
	
	private java.lang.Long productId;
	private String productIdTxt;
	
	
    /**
     * 价格       db_column: price 
     */ 	
	
	
	
	private java.math.BigDecimal price;
	
	
    /**
     * 出库数量       db_column: quantity 
     */ 	
	
	
	
	private java.lang.Integer quantity;
	
	
    /**
     * 是否有发票       db_column: have_invoice 
     */ 	
	
	
	
	private java.lang.Integer haveInvoice;
	
	
    /**
     * 发票号码       db_column: invoice_number 
     */ 	
	@Length(max=32)
	
	
	private java.lang.String invoiceNumber;
	
	//columns END

	public StockRecordLine(){
	}

	public StockRecordLine(
		java.lang.Long stockOperDetailId
	){
		this.stockOperDetailId = stockOperDetailId;
	}

	public void setStockOperDetailId(java.lang.Long value) {
		this.stockOperDetailId = value;
	}
	
	public java.lang.Long getStockOperDetailId() {
		return this.stockOperDetailId;
	}
	public void setStockOperationId(java.lang.Long value) {
		this.stockOperationId = value;
	}
	
	public java.lang.Long getStockOperationId() {
		return this.stockOperationId;
	}
	public String getStockOperationIdTxt() {
		return this.stockOperationIdTxt;
	}
	
	public void setStockOperationIdTxt(String value) {
		this.stockOperationIdTxt = value;
	}
	public void setProductId(java.lang.Long value) {
		this.productId = value;
	}
	
	public java.lang.Long getProductId() {
		return this.productId;
	}
	public String getProductIdTxt() {
		return this.productIdTxt;
	}
	
	public void setProductIdTxt(String value) {
		this.productIdTxt = value;
	}
	public void setPrice(java.math.BigDecimal value) {
		this.price = value;
	}
	
	public java.math.BigDecimal getPrice() {
		return this.price;
	}
	public void setQuantity(java.lang.Integer value) {
		this.quantity = value;
	}
	
	public java.lang.Integer getQuantity() {
		return this.quantity;
	}
	public void setHaveInvoice(java.lang.Integer value) {
		this.haveInvoice = value;
	}
	
	public java.lang.Integer getHaveInvoice() {
		return this.haveInvoice;
	}
	public void setInvoiceNumber(java.lang.String value) {
		this.invoiceNumber = value;
	}
	
	public java.lang.String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StockOperDetailId",getStockOperDetailId())
			.append("StockOperationId",getStockOperationId())
			.append("ProductId",getProductId())
			.append("Price",getPrice())
			.append("Quantity",getQuantity())
			.append("HaveInvoice",getHaveInvoice())
			.append("InvoiceNumber",getInvoiceNumber())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getStockOperDetailId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StockRecordLine == false) return false;
		if(this == obj) return true;
		StockRecordLine other = (StockRecordLine)obj;
		return new EqualsBuilder()
			.append(getStockOperDetailId(),other.getStockOperDetailId())
			.isEquals();
	}
}

