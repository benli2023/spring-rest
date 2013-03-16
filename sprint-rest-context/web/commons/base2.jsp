<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="/commons/meta2.jsp" %>
	<base href="<%=basePath%>">
	<rapid:block name="head"/>
</head>
<body class="loggedin">
    <%@ include file="/starlight/commons/top_header.jsp" %>
	
	  <!-- START OF MAIN CONTENT -->
    <div class="mainwrapper">
     	<div class="mainwrapperinner">
			<%@ include file="/starlight/commons/main_left.jsp" %>
			<div class="maincontent noright">
				<div class="maincontentinner">
					<rapid:block name="tabmenu"/>
					<rapid:block name="content"/>
				</div><!--maincontentinner-->
			</div><!--maincontent-->
			
			
		</div><!--mainwrapperinner-->
	</div><!--mainwrapper-->
     
	<%@ include file="/commons/messages.jsp" %>

	
	
</body>
</html>	