<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好， 出货管理员</title>
</head>
<body>
	<c:if test="${session_user != null }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
	</c:if>
</body>
</html>