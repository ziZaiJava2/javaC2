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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新商品类</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
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
<body style="background: #e1e9eb;">
	<div class="container" style="padding: 20px 400px 10px;">
		<form action="/mystore/newCategory" id="newForm" method="post"
			onsubmit="return jud()">
			<h3>创建新商品类</h3>
			<br><br>
			<div class="input-group">
				<span class="input-group-addon">类别：</span> <input id="categoryName"
					name="categoryName" type="text" class="form-control" value="" />
			</div>
			
			<br><br>
			
			<div>
				<input type="submit" class="btn btn-success" value="创建新类别" />
			</div>
		</form>
	</div>
	<script>
		function jud() {
			var categoryName = document.querySelector('#categoryName').value;
			if (!categoryName) {
				alert('请输入类别');
				return false;
			} else {
				return true;
			}
		}
	</Script>
</body>
</html>