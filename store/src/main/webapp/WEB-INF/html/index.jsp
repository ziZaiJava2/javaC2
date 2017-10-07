<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	display: flex;
}

form {
	font-family: "微软雅黑";
	margin: auto;
	text-align: center;
}
</style>
<script>
var X = document.getElementsByClassName("shoppingId");
alert(X[0].innerText);
</script>

<script type="text/javascript">
	function jum() {
		window.location.href = "shopping";
	}
	function jump() {
		window.location.href = "newCategory";
	}
	function jumpp() {
		window.location.href = "newGoods";
	}
	function jumppp() {
		window.location.href = "deleteGoods";
	}
	function jumpppp() {
		window.location.href = "user";
	}
</script>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
</head>
<body style="background: #e1e9eb;">
<%
    String temp = request.getParameter("getT");
%>
	<div class="container">
		<form action="/mystore/getGoods" id="mainForm" method="post">
			<table class="tab1">
				<tbody>
					<tr>
						<td width="90" align="right">名称：</td>
						<td><input id="goodsName" name="goodsName" type="text"
							class="allInput" value="" /></td>
						<td width="90" align="right">类别：</td>
						<td><input id="categoryName" name="categoryName" type="text"
							class="allInput" value="" /></td>
						<td width="85" align="right"><input type="submit"
							class="btn btn-primary" value="查 询" />&nbsp;&nbsp;&nbsp;</td>
						<td width="85" align="right"><input type="button"
							class="btn btn-primary" value="添加新商品类"
							onclick="javascrtpt:jump()" />&nbsp;&nbsp;&nbsp;</td>
						<td width="85" align="right"><input type="button"
							class="btn btn-primary" value="添加新商品"
							onclick="javascrtpt:jumpp()" />&nbsp;&nbsp;&nbsp;</td>
						<td width="85" align="left"><a href="/mystore/user">Hi~${user.name},${user.id},${user.sex}</a></td>
						<td width="85" align="left"><a href="/mystore/shopping">我的购物车</a></td>
					</tr>
				</tbody>
			</table>
			</form>
			<form action="/mystore/shopping" id="mainForm" method="post">
			<table width="100%" class="table table-striped">
				<caption>商品列表</caption>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>类别</th>
					<th>生产日期</th>
					<th>价格</th>
					<th>操作</th>
				</tr>			
				<tbody>
					<c:forEach items="${goods}" var="good">
						<tr>
							<td class = "I">${good.id}</td>
							<td class = "T">${good.name}</td>
							<td>${good.category}</td>
							<td>${good.date}</td>
							<td>${good.price}</td>
							<td>
							<a href="/mystore/addToCar?getT=${good.name}&getP=${good.price}">加入购物车</a>&nbsp;&nbsp;&nbsp;
							<a href="/mystore/deleteGoods?getI=${good.id}">删除</a>
							</td>
						</tr>				
					</c:forEach>
				</tbody>
			</table>
			</form>
	</div>
</body>
</html>