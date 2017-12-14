<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面出错了。。。</title>
<style type="text/css">
	a:link,a:visited{text-decoration:none;}
    a:hover{color:red;text-decoration:underline;}
</style>
</head>
<body>
<a href="${pageContext.request.contextPath }">点击这里返回首页</a><br>
<hr>
页面出错了。。。<br>
错误信息如下：<br><%=exception.getMessage() %>
</body>
</html>