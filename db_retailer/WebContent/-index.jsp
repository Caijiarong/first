<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
<body>
		
	<c:if test="${session_user == null }">
		<a href="<c:url value='/login.jsp'/>" >登陆</a>
	</c:if>

	<c:if test="${session_user != null }">
		<c:if test="${session_user.grade == 0 }">
			<a href="<c:url value='/super_manager.jsp'/>" >功能主页</a>
		</c:if>
		
		<c:if test="${session_user.grade == 1 }">
			<a href="<c:url value='/in_manager.jsp'/>" >功能主页</a>
		</c:if>
		
		<c:if test="${session_user.grade == 2 }">
			<a href="<c:url value='/out_manager.jsp'/>" >功能主页</a>
		</c:if>
		
		<c:if test="${session_user.grade == 3 }">
			<a href="<c:url value='/mem_manager.jsp'/>" >功能主页</a>
		</c:if>	
	</c:if>
	
	<c:if test="${session_user != null }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
	</c:if>
	
	<form action="<c:url value=''/>" method="post">
		<center>
			<input type="text" name="search"/>
			<input type="submit" value="搜索"/><br/>
		</center>
	</form>
	
</body>
</html>