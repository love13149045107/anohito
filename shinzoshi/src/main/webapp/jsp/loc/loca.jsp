<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>loc</title>
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
<h2 style="color:red" align="center">库位管理</h2>
<table border="0" bgcolor="#d8d8d8" width="98%" align="center" cellpadding="2" cellspacing="1">
 	<tr>
 	  <th>库位编码</th>
      <th>库位类型</th>
      <th>库位区域</th>
      <th>堆栈限制</th>
      <th>地面托盘数</th>
      <th>库存数量</th>
      <th>操作 <a href="${pageContext.request.contextPath }/jsp/loc/insertLoc.jsp" style="font-weight:normal">添加</a></th>
    </tr>
	<tbody id="content_table_body">
		<c:forEach items="${list}" var="i">
				<tr>
					<td>
						${i.loc}
					</td>
					<td>
						${i.type}
					</td>
					<td>
						${i.putawayzone}
					</td>
					<td>
						${i.stacklimit}
					</td>
					<td>
						${i.footprint}
					</td>
					<td>
						${i.quantity}
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/loc/delete/${i.loc}" onclick="return confirm('确认删除吗？想好了吗？');">删除 </a>
						<a href="${pageContext.request.contextPath }/loc/toUpdateLocPage/${i.loc}"> 修改</a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
  	</table>
  </body>
</html>
