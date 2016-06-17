<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/home.css">
<title>你好， 会员管理员</title>
</head>
<body>
	<div class="header">
	<div class="top-line">
	</div>
	<c:if test="${session_user != null }">
	<div class="tittle">超市管理系统</div>
	<div class="daohang">
		<ul>
			<li><a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a></li>		
			<li><a href="<c:url value='addCustomer.jsp'/>">添加会员</a></li>	
			<li><a href="<c:url value='updateCustomer.jsp'/>"	>更改会员信息</a></li>
		</ul>
	</div> 
	</c:if>
	</div>
</body>
</html>