<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import = "java.util.Date" %>
<%@page import = "java.text.SimpleDateFormat" %>
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String value = format.format(new Date());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>新商品</title>
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
	<div class="container">
		<form action="/mystore/newGoods" id="newForm" method="post" onsubmit="return jud()">
			<h3>创建新商品</h3>
			<span>商品名称：</span>
			<input id="goodsName" name="goodsName" type="text" class="allInput"value="" />
			<br><br>
			<span>商品类型：</span>
			<!-- <input id="categoryName" name="categoryName" type="text" class="allInput"value="" /> -->
			<select id="categoryName" name="categoryName">
			<c:forEach items="${category}" var="category">
              <option value =${category.name}>${category.name}</option>
             </c:forEach>
            </select>
			<br><br>
			<span>生产日期：</span>
			<input id="date" name="date" type="text" class="allInput"value="<%=value%>" readonly/>
			<br><br>
			<span>商品价格：</span>
            <input id="price" name="price" type="text" class="allInput"value=""/>
			<br><br>
			<input type="submit" class="btn btn-success" value="创建新商品" />
		</form>
	</div>
	<script>
        function jud() {
            var categoryName = document.querySelector('#categoryName').value;
            var goodsName = document.querySelector('#goodsName').value;
            if (!goodsName) {
            	alert('请输入商品名称');
                return false;
            } else if(!categoryName){
            	alert('请输入类别');
                return false;
            } else if(!categoryName && !goodsName && !price){
            	alert('请输入内容！');
            } else if(!price){
            	alert('请输入价格！');
            }else{
            return true;
        }
    </Script>
</body>
</html>