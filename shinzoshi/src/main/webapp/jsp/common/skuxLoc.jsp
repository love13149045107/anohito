<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>skuxLoc</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<style type="text/css">
		td,th{background-color:#ffffff}
		th{text-align:left}
		a:link,a:visited{text-decoration:none;}
        a:hover{color:green;text-decoration:underline;}
	</style>
  </head>
  	
<body>
<p align="right"><a href="${pageContext.request.contextPath }"><font size="2px">返回首页</font></a></p>
<h2 style="color:red" align="center">当前库位的库存情况</h2>
<table border="0" bgcolor="#d8d8d8" width="98%" align="center" cellpadding="2" cellspacing="1">
 	<tr>
      <th>货品编码</th>
      <th>货品名称</th>
      <th>库位编码</th>
      <th>库存数量</th>
    </tr>
	<tbody id="content_table_body">
		<c:forEach items="${list}" var="i">
				<tr>
					<td>
						${i.sku}
					</td>
					<td>
						${i.name}
					</td>
					<td>
						${i.loc}
					</td>
					<td>
						${i.quantity}
					</td>
									
				</tr>
			</c:forEach>
	</tbody>
  	</table>
  </body>
</html>
