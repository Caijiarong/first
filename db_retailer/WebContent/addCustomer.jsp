<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加会员</title>
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
<link title="style1" rel="stylesheet" href="css/addCustomer.css" type="text/css" />
</head>
<body>

	<div class="form_content">
	<p>${msg }</p>
    <form action="<c:url value='/CustomerServlet?method=addCustomer'/>" method="post">
    <fieldset>
        <legend>会员注册</legend>
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
        <div class="form-row">
            <div class="field-label"><label for="field5">验证码</label>:</div>
            <div class="field-widget"><input name="verifyCode" class="required" value=""/></div>
        </div>
        <div class="form-row">
        	<div class="field-label">
        		<img id="vCode" src="<c:url value='/VerifyCodeServlet'/>"/>
			</div>
			<a class="all" href="javascript:_change()">换一张</a>
        </div>

        
        
    </fieldset>
    <input type="submit" class="submit" value="注册" /> 
    <a class="all" type="button" href="<c:url value='/mem_manager.jsp'/>">返回主页</a>
    <input type="text" value="${customer.gender}" id="customer_gender"style="display:none; " />
    </form>
    </div>

</body>
</html>