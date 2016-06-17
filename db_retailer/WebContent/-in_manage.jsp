<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货管理员管理页面</title>

</head>
<body>
<c:if test="${c=='type' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		类别管理
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a><br/>
		
		<form action="<c:url value='/InManagerServlet?method=searchType'/>" method="post">
			<center>
				<input type="text" name="search"/>
				<input type="submit" value="搜索"/><br/>
			</center>
		</form>
		<form action="<c:url value='/InManagerServlet?method=updateType'/>" method="post">
			<c:if test="${type != null }">
				序	号<input type="text" name="t_ID" value="${type.t_ID}" readonly/>
				类别名称<input type="text" name="name" value="${type.name}"/>
				型号大小<input type="text" name="size" value="${type.size}">
				<input name="choice" type="submit" value="提交"/>
				<input name="choice" type="submit" value="删除"/><br/>
			</c:if>
		</form>
</c:if>
<c:if test="${c=='addtype' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		添加类别
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a><br/>
		
		<form action="<c:url value='/InManagerServlet?method=addType'/>" method="post">
			类别名称<input type="text" name="name" value="${customer.name}"/><br/>
			型号大小<input type="text" name="size" value="${customer.name}"/><br/>	
			<input type="submit" value="注册"/><br/>
		</form>	
</c:if>
<c:if test="${c =='brand' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		品牌管理
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>
		
		<form action="<c:url value='/InManagerServlet?method=searchBrand'/>" method="post">
			<center>
				<input type="text" name="search"/>
				<input type="submit" value="搜索"/><br/>
			</center>
		</form>
		<form action="<c:url value='/InManagerServlet?method=updateBrand'/>" method="post">
			<c:if test="${brand != null }">
				序	号<input type="text" name="brand_ID" value="${brand.brand_ID}" readonly/>
				品牌名称<input type="text" name="name" value="${brand.name}"/>
				<input name="choice" type="submit" value="提交"/>
				<input name="choice" type="submit" value="删除"/><br/>
			</c:if>
		</form>		
</c:if>
<c:if test="${c =='addbrand' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		添加品牌
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>	
		
		<form action="<c:url value='/InManagerServlet?method=addBrand'/>" method="post">
			品牌名称<input type="text" name="name" value="${brand.name}"/><br/>
			<input type="submit" value="注册"/><br/>
		</form>		
</c:if>
<c:if test="${c =='product' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		商品管理
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vender'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvender'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>
		
		<form action="<c:url value='/InManagerServlet?method=searchProduct'/>" method="post">
			<center>
				<input type="text" name="search"/>
				<input type="submit" value="搜索"/><br/>
			</center>
		</form>
		<form action="<c:url value='/InManagerServlet?method=updateProduct'/>" method="post">
			<c:if test="${product != null }">
				序	号<input type="text" name="p_ID" value="${product.p_ID}" readonly/>
				商品名称<input type="text" name="name" value="${product.name}"/>
				品牌代号<input type="text" name="brand_ID" value="${product.brand_ID}"/>
				类别代号<input type="text" name="t_ID" value="${product.t_ID}"/>
				单位<input type="text" name="unit" value="${product.unit}"/>
				制造商<input type="text" name="manufacturer" value="${product.manufacturer}"/>
				产	地<input type="text" name="made_in" value="${product.made_in}"/>
				<input name="choice" type="submit" value="提交"/>
				<input name="choice" type="submit" value="删除"/><br/>
			</c:if>
		</form>			
</c:if>
<c:if test="${c =='addproduct' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		添加商品
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>
		
		<form action="<c:url value='/InManagerServlet?method=addProduct'/>" method="post">
			商品名称<input type="text" name="name" value="${product.name}"/>
			品牌代号<input type="text" name="brand_ID" value="${product.brand_ID}"/>
			类别代号<input type="text" name="t_ID" value="${product.t_ID}"/>
			单	位<input type="text" name="unit" value="${product.unit}"/>
			制造商<input type="text" name="manufacturer" value="${product.manufacturer}"/>
			产	地<input type="text" name="made_in" value="${product.made_in}"/>
			<input type="submit" value="注册"/><br/>
		</form>		
			
</c:if>
<c:if test="${c =='vendor' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		供货商管理
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>	
		
		<form action="<c:url value='/InManagerServlet?method=searchVendor'/>" method="post">
			<center>
				<input type="text" name="search"/>
				<input type="submit" value="搜索"/><br/>
			</center>
		</form>
		<form action="<c:url value='/InManagerServlet?method=updateVendor'/>" method="post">
			<c:if test="${vendor != null }">
				供货商代号<input type="text" name="v_ID" value="${vendor.v_ID}" readonly/>
				供货商名称<input type="text" name="name" value="${vendor.name}"/>
				供货商地址<input type="text" name="address" value="${vendor.address}"/>
				<input name="choice" type="submit" value="提交"/>
				<input name="choice" type="submit" value="删除"/><br/>	
			</c:if>
		</form>	
		
		<form action="<c:url value='/InManagerServlet?method=addVen_brand'/>" method="post">
			<c:if test="${vendor != null }">
				供货商代号<input type="text" name="v_ID" value="${vendor.v_ID}"/>
				代理品牌<input type="text" name="brand_ID" value="${ven_brand.brand_ID}"/>
				<input name="choice" type="submit" value="提交"/>
			</c:if>	
		</form>		
		
</c:if>
<c:if test="${c =='addvendor' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		添加供货商
		<a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>" >商品入库</a>	
		
		<form action="<c:url value='/InManagerServlet?method=addVendor'/>" method="post">
				供货商名称<input type="text" name="name" value="${vendor.name}"/>
				供货商地址<input type="text" name="address" value="${vendor.address}"/>
				<input name="choice" type="submit" value="提交"/>
		</form>	
		

</c:if>
<c:if test="${c =='pro_sto' }">
		<a href="<c:url value='/ManagerServlet?method=logOut'/>" >退出</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=type'/>" >类别管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>" >添加类别</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>" >品牌管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>" >添加品牌</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=product'/>" >商品管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>" >添加商品</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>" >供货商管理</a>
		<a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>" >添加供货商</a>
		商品入库
		<form action="<c:url value='/InManagerServlet?method=addPro_sto'/>" method="post">
			存储序号<input type="text" name="ps_ID" value="${pro_sto.ps_ID}"/>
			商店代号<input type="text" name="store_ID" value="${pro_sto.store_ID}"/>
			货物代号<input type="text" name="p_ID" value="${pro_sto.p_ID}"/>
			供货商代号<input type="text" name="v_ID" value="${pro_sto.v_ID}"/>
			价格<input type="text" name="price" value="${pro_sto.price}"/>
			数量<input type="text" name="amount" value="${pro_sto.amount}"/>
			upc-code<input type="text" name="upc_code" value="${pro_sto.upc_code}"/>
			产品生产日期<input type="text" name="product_date" value="${pro_sto.product_date}"/>
		</form>
		<form action="<c:url value='/InManagerServlet?method=uploadFile'/>" method="post" enctype="multipart/form-data">
    		<input type="file" name="file">
   			<input type="submit" name="upload"value="上传">
		</form>	
</c:if>
</body>
</html>