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
<link rel="stylesheet" href="css/addCustomer.css" type="text/css" />
</head>
<body>

	<a class="all" href="<c:url value='/mem_manager.jsp'/>" >返回主页</a>
	<form action="<c:url value='/CustomerServlet?method=findCustomer'/>" method="post">
		<center>
			<input type="text" name="search"/>
			<input type="submit" class="submit" value="搜索" />
		</center>
	</form>
	<div class="form_content">
	<form action="<c:url value='/CustomerServlet?method=updateCustomer'/>" method="post">
		<c:if test="${customer != null }">
		<center>
		<fieldset>
        <legend>会员注册</legend>
        <p>${msg }</p>
        <div class="form-row">
            <div class="field-label"><label for="field1">身份证</label>:</div>
            <div class="field-widget"><input name="c_ID" class="required" value="${customer.c_ID}"/></div>
        </div>
        
        <div class="form-row">
            <div class="field-label"><label for="field2">姓名</label>:</div>
            <div class="field-widget"><input name="name" class="required" value="${customer.name}"/></div>
        </div>
        <div class="form-row-select">

            <fieldset>
                <legend>性别</legend>
                <label class="left">
                <input type="radio" id="radio1" class="radio_input" name="gender" value="1" />男 <br />               
                </label>
                <label class="left">
                 <input type="radio" id="radio2" class="radio_input" name="gender" value="0"/>女<br />
                </label>                
            </fieldset> 
         
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field3">住址</label>:</div>
            <div class="field-widget"><input name="address" class="required" value="${customer.address}"/></div>
        </div>
        <div class="form-row">
            <div class="field-label"><label for="field4">电话</label>:</div>
            <div class="field-widget"><input name="phone" class="required" value="${customer.phone}"/></div>
        </div>   
    </fieldset>
    <input name="choice" type="submit" class="submit" value="提交" />
    <input name="choice" type="submit" class="submit" value="删除" />
    </center>
		</c:if>
		<input type="text" value="${customer.gender}" id="customer_gender"style="display:none; " />
	</form>
	</div>
</body>
</html>