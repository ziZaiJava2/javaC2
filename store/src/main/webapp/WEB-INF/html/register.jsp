<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body style="background: #e1e9eb;">
    <div style="padding: 20px 600px 10px;">
        <form action="/mystore/register" method="post" onsubmit="return jud()">
            <h1>用户注册</h1>
            <br>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                <input type="text" class="form-control" placeholder="your name" name="name" id="name">
            </div>
            <div class="radio">
                <label><input type="radio" name="sex" id="sex" value="男" checked> 男</label>
                <label><input type="radio" name="sex" id="sex" value="女" checked> 女</label>
            </div>
            </br>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                <input type="password" class="form-control" placeholder="your password" name="password" id="password">
            </div>
            </br>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                <input type="password" class="form-control" placeholder="input your password again" name="password_sure" id="password_sure">
            </div>
            </br>
            <div>
                <input type="submit" class="btn btn-success" value="注册">
                <a href="/mystore/login"><input type="button" class="btn btn-success" value="返回登入界面"></input></a>
            </div>

        </form>
    </div>
    <script>
        function jud() {
            var name = document.querySelector('#name').value;
            var password = document.querySelector('#password').value;
            var password_sure = document.querySelector('#password_sure').value;
            var sex = document.querySelector('#sex').value;
            if (!name) {
                alert('姓名不能为空！');
                return false;
            } else if (!password) {
                alert('密码不能为空！')
                return false;
            } else if (password !== password_sure) {
                alert('两次密码不一致!')
                return false;
            } else if (!sex) {
                alert('性别不能为空！')
                return false;
            } else if (!id) {
                alert('id不能为空')
                return false;
            } else {
                return true;
            }
        }
    </Script>
</body>
</html>