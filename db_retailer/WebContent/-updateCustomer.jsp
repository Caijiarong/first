<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改会员信息</title>
<script type="text/javascript">
	function _change(){
		var ele = document.getElementById("vCode");
		ele.src="<c:url value='/VerifyCodeServlet'/>?r=" + new Date().getTime();
	}
	
	window.onload=radio_checked;
	function radio_checked(){
		var checked=document.getElementById("customer_gender").value;

		if(checked == "true"){
			alert(checked);
			var radio1=document.getElementById("radio1");
			radio1.checked="true";
		}
		if(checked == "false"){
			alert(checked);
			var radio1=document.getElementById("radio2");
			radio1.checked="true";
		}
	}

</script>
</head>
<body>

	<h1>更改会员信息</h1>
	<a href="<c:url value='/mem_manager.jsp'/>" >返回主页</a>
	<form action="<c:url value='/CustomerServlet?method=findCustomer'/>" method="post">
		<center>
			<input type="text" name="search"/>
			<input type="submit" value="搜索"/><br/>
		</center>
	</form>
	<p>${msg }</p>
	<form action="<c:url value='/CustomerServlet?method=updateCustomer'/>" method="post">
		<c:if test="${customer != null }">
		身份证<input type="text" name="c_ID" value="${customer.c_ID}" readonly/>
		姓	名<input type="text" name="name" value="${customer.name}"/>
		性	别<input type="radio" id="radio1" name="gender" value="1"/>男
		      <input type="radio" id="radio2" name="gender" value="0"/>女
		住	址<input type="text" name="address" value="${customer.address}">
		电	话<input type="text" name="phone" value="${customer.phone}">
		<input name="choice" type="submit" value="提交"/>
		<input name="choice" type="submit" value="删除"/><br/>
		</c:if>
		<input type="text" value="${customer.gender}" id="customer_gender"style="display:none; " />
	</form>
</body>
</html>