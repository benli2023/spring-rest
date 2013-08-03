<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>

<c:if test="${not empty sessionScope.SESSION_USER}">
  user:<c:out value="${sessionScope.SESSION_USER.loginName}" />  | last logon time:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${sessionScope.SESSION_USER.lastLoginTime}"/> |  [<a href="${ctx}/core/logout" >logout</a>]
</c:if>