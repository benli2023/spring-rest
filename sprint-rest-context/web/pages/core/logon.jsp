<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@page import="com.github.springrest.interceptor.UserSessionInterceptor"%>
<rapid:override name="head">
	<title>用户登录</title>
</rapid:override>
<rapid:override name="content">
	<form:form method="post" action="${ctx}/core/logon" modelAttribute="authentication">
		<input type="hidden" name="<%=UserSessionInterceptor.REQUES_URI_PARAM%>" value="<%=request.getParameter(UserSessionInterceptor.REQUES_URI_PARAM)%>" />
		<p>
			<font color='red'> <form:errors /> </font>
		</p>
		<tr>
			<td class="tdLabel">UserName:</td>
			<td><form:input path="principal" id="principal" cssClass="" maxlength="64" /> <font color='red'><form:errors path="principal" /> </font></td>
		</tr>
		<tr>
			<td class="tdLabel">Password:</td>
			<td><form:input path="credential" id="credential" cssClass="" maxlength="128" /> <font color='red'><form:errors path="credential" /> </font>
			</td>
		</tr>
		<input id="submitButton" name="submitButton" type="submit" value="登录" />
	</form:form>
</rapid:override>
<%@ include file="base.jsp"%>