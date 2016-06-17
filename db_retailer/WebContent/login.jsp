<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css/login.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Oxygen:400,300,700|Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<script type="text/javascript">
	function _change(){
		var ele = document.getElementById("vCode");
		ele.src="<c:url value='/VerifyCodeServlet'/>?r=" + new Date().getTime();
	}
</script>
</head>
 
<body>
	<div class="main">
		<div class="user">
			<img src="images/user.png" alt="">
		</div>
		<div class="login">
			<div class="inset">
				<!-----start-main---->
				<form action="<c:url value='/ManagerServlet?method=login'/>" method="post">
					<span><label>${msg }</label></span>
			         <div>
						<span><label>Username</label></span>
						<span><input name="user_ID" type="text" value="${manager.user_ID }"/></span>
					 </div>
					 <div>
						<span><label>Password</label></span>
					    <span><input name ="passwd" type="password" /></span>
					 </div>
					 <div>
						<span><label>Verify</label></span>
					    <span><input type="text" name="verifyCode" value="" size="3"/>
					    <img id="vCode" src="<c:url value='/VerifyCodeServlet'/>"/>
					    <span class="forget-pass">
							<a href="javascript:_change()">换一张</a>
						</span>
					    </span>
					 </div>
					<div class="sign">
						<div class="submit">
						  <input type="submit" value="Login">
						</div>
						<span class="forget-pass">
						<a href="<c:url value='/index.jsp'/>">返回主页</a>
						</span>
						<span class="forget-pass">
							<a href="#">忘记密码？</a>
						</span>
						&nbsp;
							<div class="clear"> </div>
					</div>
					</form>
				</div>
			</div>
		<!-----//end-main---->
		</div>

	 
</body>
</html>