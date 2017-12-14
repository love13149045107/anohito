<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>receiptdetail</title>
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
<p align="right"><a href="${pageContext.request.contextPath }/receipt/findAll"><font size="2px">返回收货单管理</font></a></p>
<h2 style="color:red" align="center">收货明细管理</h2>
<table border="0" bgcolor="#d8d8d8" width="98%" align="center" cellpadding="2" cellspacing="1">
 	<tr>
 	  <th>货主编码</th>
      <th>货品编码</th>
      <th>数量</th>
      <th>货品名称</th>
      <th>货品类型</th>
      <th>重量</th>
      <th>收货库位</th>
      <th>操作 <a href=<c:if test="${status!='已收货' }">${pageContext.request.contextPath }/receiptdetail/insertReceiptdetail/${storerkey}</c:if><c:if test="${status=='已收货' }">javascript:void(0)</c:if> style="font-weight:normal">添加收货明细</a></th>
    </tr>
	<tbody id="content_table_body">
		<c:forEach items="${list}" var="i">
				<tr>
					<td>
						${i.storerkey}
					</td>
					<td>
						${i.sku}
					</td>
					<td>
						${i.quantity}
					</td>
					<td>
						${i.name}
					</td>
					<td>
						${i.category}
					</td>
					<td>
						${i.weight}
					</td>
					<td>
						${i.loc}
					</td>
					<td>
						<a href=<c:if test="${status!='已收货' }">${pageContext.request.contextPath }/receiptdetail/toUpdatePage/${i.receiptdetailId}/${i.storerkey}</c:if><c:if test="${status=='已收货' }">javascript:void(0)</c:if>>修改  </a>
						<a href=<c:if test="${status!='已收货' }">${pageContext.request.contextPath }/receiptdetail/delete/${i.receiptdetailId}/${i.storerkey}</c:if><c:if test="${status=='已收货' }">javascript:void(0)</c:if> onclick="return confirm('确认删除吗？想好了吗？');"> 删除 </a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
  	</table>
  </body>
</html>
