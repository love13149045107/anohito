<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到仓库管理系统</title>
<style type="text/css">
	a:link,a:visited{text-decoration:none;}
    a:hover{color:green;text-decoration:underline;}
</style>
</head>
<body>
	<div style="padding-top:30px;padding-left:30px">
		<img src="images/logo.png"/>
		<h1 style="color:green">欢迎来到仓库管理系统！</h1>
		<a href="storer/storer">货主管理</a><br>
		<a href="sku/findAll">货品管理</a><br>
		<a href="loc/findAll">库位管理</a><br>
		<a href="receipt/findAll">收货单管理</a><br>
		<a href="orders/findAll">出库单管理</a><br>
		<a href="skuxLoc/findSkuxLoc">库存管理</a><br>
	</div>
</body>
</html>