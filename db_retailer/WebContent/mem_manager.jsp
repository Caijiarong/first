<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/daohang.css">
<title>你好， 会员管理员</title>
</head>
<body>
	<c:if test="${session_user != null }">
		<ul id="nav">
			<li><a href="<c:url value='addCustomer.jsp'/>">添加会员</a></li>	
			<li><a href="<c:url value='updateCustomer.jsp'/>"	>更改会员信息</a></li>
			<li><a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出系统</a></li>		
		</ul>
	</c:if>
</body>
</html>