package com.github.springrest.util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
import org.apache.taglibs.standard.tag.el.core.ExpressionUtil;

public class ButtonEditTag extends TagSupport {
	
	private static final long serialVersionUID = -8292416425470133838L;

	
	private String id;
	
	private String name;
	
	private String hiddenName;
	
	private String width="130";
	
	private String _txtVal;
	
	private String txtVal="";
	
	
	private String _hiddenVal;
	
	private String hiddenVal="";
	
	private String profileId;
	
	
	
	
	@Override
	public int doStartTag() throws JspException {
		evaluateExpressions();
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {

		StringBuilder builder=new StringBuilder();
		builder.append("<span class=\"mini-buttonedit\" style=\"border-width: 0px; width: "+width+"px;\" >");
		builder.append("<span class=\"mini-buttonedit-border\" style=\"width: "+width+"px;\">");
		builder.append("<input type=\"input\" class=\"mini-buttonedit-input\" autocomplete=\"off\" placeholder=\"\" name=\""+name+"\" style=\"width: 103px;\" id=\""+id+"\" value=\""+txtVal+"\" />");
		builder.append("<input type=\"hidden\" name=\""+hiddenName+"\" value=\""+hiddenVal+"\"  class=\"popup_hidden_Id\" />");
		builder.append("<span class=\"mini-buttonedit-button\" onmouseover=\"PopupSelection.addClass(this,'mini-buttonedit-button-hover');\" onmouseout=\"PopupSelection.removeClass(this,'mini-buttonedit-button-hover');\" onclick=\"PopupSelection.openSelection('"+id+"','"+profileId+"')\" >");
		builder.append("<span class=\"mini-buttonedit-icon\"></span></span>");
		builder.append("<span class=\"mini-buttonedit-close\" style=\"display:none\" onclick=\"PopupSelection.clearSelection(this,'"+id+"')\"></span>");
		builder.append("</span></span>");
		JspWriter w = pageContext.getOut();
		try {
			w.write(builder.toString());
		} catch (IOException ex) {
			throw new JspException(ex.toString(), ex);
		}
		return super.doEndTag();
	}
	
	
	public void setWidth(String width) {
		this.width = width;
	}
	
	public void setTxtVal(String _txtVal) {
		this._txtVal = _txtVal;
	}
	
	public void setHiddenVal(String _hiddenVal) {
		this._hiddenVal = _hiddenVal;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}
	
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public void setId(String id) {
		this.id = id;
	}

	/* Evaluates expressions as necessary */
    private void evaluateExpressions() throws JspException {
			try {
				txtVal = (String)ExpressionUtil.evalNotNull(
			        "button-edit", "txtVal", _txtVal, String.class, this, pageContext);
			} catch (NullAttributeException ex) {
			    // explicitly allow 'null' for value
				txtVal = null;
			}
    	
			try { 
				hiddenVal = (String) ExpressionUtil.evalNotNull(
			        "button-edit", "hiddenVal", _hiddenVal, String.class, this, pageContext);
			} catch (NullAttributeException ex) {
			    // explicitly allow 'null' for def
				hiddenVal = null;
			}

    }
	

}
