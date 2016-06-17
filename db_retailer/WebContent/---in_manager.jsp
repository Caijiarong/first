<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/daohang.css">
<link rel="stylesheet" href="css/addCustomer.css" type="text/css" />
<title>进货管理员管理页面</title>
</head>
<body>
		<c:if test="${session_user != null }">
				<ul id="nav">
					<li class="header">会员管理中心</li>
				</ul>
				<ul id="nav">
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=type'/>">类别管理</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=brand'/>">品牌管理</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=product'/>">商品管理</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=vendor'/>">供商管理</a></li>
					<li><a href="<c:url value='/ManagerServlet?method=logOut'/>">退出系统</a></li>
				</ul>
				<ul id="nav">
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=addtype'/>">添加类别</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=addbrand'/>">添加品牌</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=addproduct'/>">添加商品</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=addvendor'/>">添加供商</a></li>
					<li><a href="<c:url value='/InManagerServlet?method=choice&c=pro_sto'/>">商品入库</a></li>
				</ul>

		</c:if>
	<br>
	<br>
	<c:if test="${c=='type' }">
		<form action="<c:url value='/InManagerServlet?method=searchType'/>"
			method="post">
			<center>
				<input type="text" name="search" /> <input type="submit"
					class="submit" value="搜索" /><br />
			</center>
		</form>
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=updateType'/>"
					method="post">
					<c:if test="${type != null }">
						<fieldset>
							<legend>类别管理</legend>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">序 号</label>:
								</div>
								<div class="field-widget">
									<input name="t_ID" class="required" value="${type.t_ID}" readonly/>
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field2">类别名称</label>:
								</div>
								<div class="field-widget">
									<input name="name" class="required" value="${type.name}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">型号大小</label>:
								</div>
								<div class="field-widget">
									<input name="size" class="required" value="${type.size}" />
								</div>
							</div>
						</fieldset>
						<input name="choice" type="submit" class="submit" value="提交" />
						<input name="choice" type="submit" class="submit" value="删除" />
						<br />
					</c:if>
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c=='addtype' }">
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=addType'/>"
					method="post">
					<fieldset>
						<legend>添加类别</legend>
						<div class="form-row">
							<div class="field-label">
								<label for="field1">类别名称</label>:
							</div>
							<div class="field-widget">
								<input name="name" class="required" value="${customer.name}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field2">型号大小</label>:
							</div>
							<div class="field-widget">
								<input name="size" class="required" value="${customer.size}" />
							</div>
						</div>
					</fieldset>
					<input type="submit" class="submit" value="注册" /><br />
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c =='brand' }">
		<center>
			<form action="<c:url value='/InManagerServlet?method=searchBrand'/>"
				method="post">
				<center>
					<input type="text" name="search" /> <input type="submit"
						class="submit" value="搜索" /><br />
				</center>
			</form>
		</center>
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=updateBrand'/>"
					method="post">
					<c:if test="${brand != null }">
						<fieldset>
							<legend>品牌管理</legend>
							<p>${msg }</p>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">序 号</label>:
								</div>
								<div class="field-widget">
									<input name="brand_ID" class="required"
										value="${brand.brand_ID}" readonly/>
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field2">类别名称</label>:
								</div>
								<div class="field-widget">
									<input name="name" class="required" value="${brand.name}" />
								</div>
							</div>
						</fieldset>
						<input name="choice" type="submit" class="submit" value="提交" />
						<input name="choice" type="submit" class="submit" value="删除" />
						<br />
					</c:if>
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c =='addbrand' }">
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=addBrand'/>"
					method="post">
					<fieldset>
						<legend>添加品牌</legend>
						<div class="form-row">
							<div class="field-label">
								<label for="field1">品牌名称</label>:
							</div>
							<div class="field-widget">
								<input name="name" class="required" value="${brand.name}" />
							</div>
						</div>
					</fieldset>
					<input type="submit" class="submit" value="注册" /><br />
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c =='product' }">
		<form action="<c:url value='/InManagerServlet?method=searchProduct'/>"
			method="post">
			<center>
				<input type="text" name="search" /> <input type="submit"
					class="submit" value="搜索" /><br />
			</center>
		</form>
		<center>
			<div class="form_content">

				<form
					action="<c:url value='/InManagerServlet?method=updateProduct'/>"
					method="post">
					<c:if test="${product != null }">
						<fieldset>
							<legend>商品管理</legend>
							<p>${msg }</p>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">序 号</label>:
								</div>
								<div class="field-widget">
									<input name="p_ID" class="required" value="${product.p_ID}" readonly/>
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field2">商品名称</label>:
								</div>
								<div class="field-widget">
									<input name="name" class="required" value="${product.name}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field3">品牌代号</label>:
								</div>
								<div class="field-widget">
									<input name="brand_ID" class="required"
										value="${product.brand_ID}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field4">类别代号</label>:
								</div>
								<div class="field-widget">
									<input name="t_ID" class="required" value="${product.t_ID}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field5">单位</label>:
								</div>
								<div class="field-widget">
									<input name="unit" class="required" value="${product.unit}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field6">制造商</label>:
								</div>
								<div class="field-widget">
									<input name="manufacturer" class="required"
										value="${product.manufacturer}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field7">产地</label>:
								</div>
								<div class="field-widget">
									<input name="made_in" class="required"
										value="${product.made_in}" />
								</div>
							</div>
						</fieldset>
						<input name="choice" type="submit" class="submit" value="提交" />
						<input name="choice" type="submit" class="submit" value="删除" />
						<br />
					</c:if>
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c =='addproduct' }">
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=addProduct'/>"
					method="post">
					<fieldset>
						<legend>添加商品</legend>
						<p>${msg }</p>
						<div class="form-row">
							<div class="field-label">
								<label for="field1">商品名称</label>:
							</div>
							<div class="field-widget">
								<input name="name" class="required" value="${product.name}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field2">品牌代号</label>:
							</div>
							<div class="field-widget">
								<input name="brand_ID" class="required"
									value="${product.brand_ID}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field3">类别代号</label>:
							</div>
							<div class="field-widget">
								<input name="t_ID" class="required" value="${product.t_ID}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field4">单位</label>:
							</div>
							<div class="field-widget">
								<input name="unit" class="required" value="${product.unit}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field5">制造商</label>:
							</div>
							<div class="field-widget">
								<input name="manufacturer" class="required"
									value="${product.manufacturer}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field6">产地</label>:
							</div>
							<div class="field-widget">
								<input name="made_in" class="required"
									value="${product.made_in}" />
							</div>
						</div>
					</fieldset>
					<input class="submit" type="submit" value="注册" /><br />
				</form>
			</div>
		</center>
	</c:if>
	<c:if test="${c =='vendor' }">
		<form action="<c:url value='/InManagerServlet?method=searchVendor'/>"
			method="post">
			<center>
				<input type="text" name="search" /> <input type="submit"
					class="submit" value="搜索" /><br />
			</center>
		</form>
		<form action="<c:url value='/InManagerServlet?method=updateVendor'/>"
			method="post">
			<c:if test="${vendor != null }">
				<center>
					<div class="form_content">
						<fieldset>
							<legend>供商管理</legend>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">供货商代号</label>:
								</div>
								<div class="field-widget">
									<input name="v_ID" class="required" value="${vendor.v_ID}"
										readonly />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field2">供货商名称</label>:
								</div>
								<div class="field-widget">
									<input name="name" class="required" value="${vendor.name}" />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field3">供货商地址</label>:
								</div>
								<div class="field-widget">
									<input name="address" class="required"
										value="${vendor.address}" />
								</div>
							</div>
						</fieldset>
						<input name="choice" class="submit" type="submit" value="提交" /> <input
							name="choice" class="submit" type="submit" value="删除" /> <br />
					</div>
				</center>
			</c:if>
		</form>

		<form action="<c:url value='/InManagerServlet?method=addVen_brand'/>"
			method="post">
			<c:if test="${vendor != null }">
				<center>
				<p>${msg }</p>
					<div class="form_content">
						<fieldset>
							<div class="form-row">
								<div class="field-label">
									<label for="field1">供货商代号</label>:
								</div>
								<div class="field-widget">
									<input name="v_ID" class="required" value="${vendor.v_ID}"
										readonly />
								</div>
							</div>
							<div class="form-row">
								<div class="field-label">
									<label for="field2">代理品牌</label>:
								</div>
								<div class="field-widget">
									<input name="brand_ID" class="required"
										value="${ven_brand.brand_ID}" />
								</div>
							</div>
						</fieldset>
						<input name="choice" class="submit" type="submit" value="提交" /> <br />
					</div>
				</center>
			</c:if>
		</form>

	</c:if>
	<c:if test="${c =='addvendor' }">
		<center>
			<div class="form_content">
				<form action="<c:url value='/InManagerServlet?method=addVendor'/>"
					method="post">
					<fieldset>
						<legend>添加供商</legend>
						<div class="form-row">
							<div class="field-label">
								<label for="field1">供货商名称</label>:
							</div>
							<div class="field-widget">
								<input name="name" class="required" value="${vendor.name}" />
							</div>
						</div>
						<div class="form-row">
							<div class="field-label">
								<label for="field2">供货商地址</label>:
							</div>
							<div class="field-widget">
								<input name="address" class="required" value="${vendor.address}" />
							</div>
						</div>
					</fieldset>
					<input name="choice" class="submit" type="submit" value="提交" />
				</form>
			</div>
		</center>

	</c:if>
	<c:if test="${c =='pro_sto' }">
	<center>
			<div class="form_content">
		<form action="<c:url value='/InManagerServlet?method=addPro_sto'/>"
			method="post">
			<fieldset>
			<legend>商品入库</legend>
			<p>${msg }</p>
			<div class="form-row">
							<div class="field-label">
								<label for="field1">存储序号</label>:
							</div>
							<div class="field-widget">
								<input name="ps_ID" class="required" value="${pro_sto.ps_ID}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field2">商店代号</label>:
							</div>
							<div class="field-widget">
								<input name="store_ID" class="required" value="${pro_sto.store_ID}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field3">货物代号</label>:
							</div>
							<div class="field-widget">
								<input name="p_ID" class="required" value="${pro_sto.p_ID}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field4">供货商代号</label>:
							</div>
							<div class="field-widget">
								<input name="v_ID" class="required" value="${pro_sto.v_ID}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field5">价格</label>:
							</div>
							<div class="field-widget">
								<input name="price" class="required" value="${pro_sto.price}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field6">数量</label>:
							</div>
							<div class="field-widget">
								<input name="amount" class="required" value="${pro_sto.amount}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field7">upc-code</label>:
							</div>
							<div class="field-widget">
								<input name="upc_code" class="required" value="${pro_sto.upc_code}" />
							</div>
			</div>
			<div class="form-row">
							<div class="field-label">
								<label for="field8">产品生产日期</label>:
							</div>
							<div class="field-widget">
								<input name="product_date" class="required" value="${pro_sto.product_date}" />
							</div>
			</div>
			</fieldset>
			<input name="choice" class="submit" type="submit" value="提交" />
		</form>
		</div>
		</center>
		<center>
		<form action="<c:url value='/InManagerServlet?method=uploadFile'/>"
			method="post" enctype="multipart/form-data">
			<input type="file" name="file"> <input type="submit" class="submit"
				name="upload" value="上传">
		</form>
				<br>
		</center>
	</c:if>
</body>
</html>