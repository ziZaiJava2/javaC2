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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>用户登录</title>
<style>
        body {
            background-image: url(/065029thkbeuejem3xi1bb.jpg);
            display: flex;
        }

        form {
            margin: auto;
            text-align: center;
        }

        .forgetpwd {
            display: block;
            float: right;
            clear: left;
            width: 100px;
            text-align: right;
            line-height: 30px;
        }
    </style>
</head>
<body style="background: #e1e9eb;">
	 <div style="padding: 20px 600px 10px;">
        <form action="/mystore/login" method="post" onsubmit=" return jud()" class="bs-example bs-example-form">
            <h1>登 录</h1>
            <font color = "red">${error}</font>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                <input type="input" class="form-control" placeholder="your name" name="name" id="name">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                <input type="password" class="form-control" placeholder="your password" name="password" id="password">
                <!-- <p>密码：<input type="password" name="password" id="password"></p>-->
            </div>
            <a href="#" class="forgetpwd" for="password">忘记密码？</a>
            <br>
            <div>
                <input type="submit" class="btn btn-success" value="登录">
                <a href="/store/mystore/register">注册新用户</a>
            </div>
        </form>
    </div>
    <script>
        function jud() {
            var name = document.querySelector('#name').value;
            var password = document.querySelector('#password').value;
            if (!name) {
                alert('用户名不能为空！');
                return false;
            } else if (!password) {
                alert('密码不能为空！')
                return false;
            } else {
                return true;
            }
        }
    </script>
</body>
</html>