<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
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
var X = document.getElementsByTagName("td");
alert(X[0].innerText);
</script>

<script type="text/javascript">
	function jum() {
		window.location.href = "goods"; 
	}
</script>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>我的购物车</title>
</head>
<body style="background: #e1e9eb;">
<%
    String temp = request.getParameter("getT");
%>
	<div class="container">
		<form action="/mystore/delshopping" id="mainForm" method="post">
		<table class="tab1">
				<tbody>
					<tr>
						<td width="85" align="right"><input type="button"
							class="btn btn-danger" value="返回商品列表" onclick="javascrtpt:jum()" />&nbsp;&nbsp;&nbsp;</td>
					</tr>
				</tbody>
			</table>
			<table width="100%" class="table table-striped">
				<caption>我的购物车列表,共${num}件货物,总价：${total}RMB。</caption>
				<tr>
					<th>编号</th>
					<th>商品名称</th>
					<th>价格</th>
					<th>购买者</th>
					<th>操作</th>
				</tr>
				<tbody>
					<c:forEach items="${shoppings}" var="shopping">
						<tr>
							<td  class = "T">${shopping.id}</td>
							<td>${shopping.goodsName}</td>
							<td>${shopping.price}</td>
							<td>${shopping.userName}</td>
							<td><a href="/mystore/delshopping?getT=${shopping.id}">删除此商品</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>