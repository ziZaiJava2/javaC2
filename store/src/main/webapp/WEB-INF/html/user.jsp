<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户主页</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	display: flex;
}

form {
	margin: auto;
	text-align: center;
}
</style>
</head>
<body style="background: #e1e9eb;">
	<div class="container">
		<form action="/mystore/user" id="mainForm" method="post">
			<table width="100%" class="table table-striped">
				<caption>用户信息</caption>
				<tr>
					<th>id</th>
					<th>姓名</th>
					<th>性别</th>
					<th>密码</th>
					<th>操作</th>
				</tr>
				<tbody>
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.sex}</td>
						<td>${user.password}</td>
						<td><input type="submit" class="btn btn-primary"
							value="退出登录"/></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>