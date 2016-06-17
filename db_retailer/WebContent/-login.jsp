<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
<script type="text/javascript">
	function _change(){
		var ele = document.getElementById("vCode");
		ele.src="<c:url value='/VerifyCodeServlet'/>?r=" + new Date().getTime();
	}
</script>
</head>
<body>
	<h1>登陆</h1>
	<a href="<c:url value='/index.jsp'/>">返回主页</a><br/>
	<p>${msg }</p>
	<form action="<c:url value='/ManagerServlet?method=login'/>" method="post">
		账号：<input name="user_ID" type="text" value="${manager.user_ID }"/><br/>
		密码：<input name ="passwd" type="password" /><a href="#">忘记密码？</a>
		<br/>
		验证码<input type="text" name="verifyCode" value="" size=3/>
		<img id="vCode" src="<c:url value='/VerifyCodeServlet'/>"/>
		<a href="javascript:_change()">换一张</a>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>