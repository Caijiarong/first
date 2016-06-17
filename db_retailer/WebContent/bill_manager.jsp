<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单</title>
<script src="ajax/jquery-1.9.1.min.js"></script>
<script src="ajax/jquery_send.js"></script>
<script type="text/javascript">
	function addbilllist(){
		var id = document.getElementById("search").value;
		var data;
		var i = 1;
		if(id != ''){
			data = $.send("Bill_listManager", "getMessage", {"param1" : id});
		}
		
	}
</script>
</head>
<body>
	<div style="width:60%; border-style:solid;margin-left:20%;margin-top:10%">
		<div style="margin:5px 0px 5px 30%; height:50px">
			<input id="search" type="text" placeholder="请输入商品码" style="font-size:24px; border-radius:3px; margin-top:7px" />
			<input type="button" value="确定" style="width:80px;height:30px" onClick="addbilllist()"/>
		</div>
	</div>
	<div style="width:60%; border-style:solid;margin-left:20%;margin-top:10px">
		<table border="1" border-color="black" cellpadding="10%" cellspacing="0" width="95%" style="margin:5px 0px 5px 2%">
			<tr>
				<th>列表ID</th>
				<th>商品名称</th>
				<th>品牌名称</th>
				<th>制造商</th>
				<th>出产地</th>
				<th>生产日期</th>
				<th>数量</th>
				<th>折扣</th>
				<th>原价</th>
				<th>实价</th>
			</tr>
			<tr class="hiden" style="display"none""></tr>
		</table>
	</div>
	<div style="width:60%; border-style:solid;margin-left:20%;height:100px;margin-top:10px">
		<div style="margin-left:60%">
			<span><input type="button" value="结算" style="width:100px;height:50px;margin-top:10px" /></span>
			<span><input type="button" value="取消" style="width:100px;height:50px;margin-top:10px;margin-left:40px" /></span>
		</div>
	</div>
</body>
</html>