<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好， 进货管理员</title>
</head>
<body>
	<c:if test="${session_user != null }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>								
	</c:if>
</body>
</html>