<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

	<head>

		<%@ include file="/commons/pertho_meta.jsp"%>
		<base href="<%=basePath%>">

<style>
* {
	font-size: 12px;
}
</style>
		<rapid:block name="head" />
	</head>

	<body class="ptrn_a grdnt_a mhover_a">
		
		<%@ include file="/commons/pertho_top_menu.jsp" %>
		<div class="container">
			<rapid:block name="content" />
		</div>
		
		
		<footer class="container" id="footer">
        <div class="row">
           <div class="twelve columns">
                Copyright &copy; 2012 tzd-themes.com
           </div>
        </div>
		</footer>
		
	</body>
</html>
