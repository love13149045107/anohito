<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>receipt</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<style type="text/css">
		td,th{background-color:#ffffff}
		th{text-align:left}
		a:link,a:visited{text-decoration:none;}
        a:hover{color:green;text-decoration:underline;}
	</style>
	<script type="text/javascript">
		function check(id){
			var isConfirm = window.confirm("确认收货吗？想好了吗？");
			if(isConfirm){
				location.href="${pageContext.request.contextPath }/receipt/takeGoods/"+id;
			}	
		}
	</script>
  </head>
  	
<body>
<p align="right"><a href="${pageContext.request.contextPath }"><font size="2px">返回首页</font></a></p>
<h2 style="color:red" align="center">收货单管理</h2>
<table border="0" bgcolor="#d8d8d8" width="98%" align="center" cellpadding="2" cellspacing="1">
 	<tr>
 	  <th>货主编码</th>
      <th>供应商</th>
      <th>供应商联系电话</th>
      <th>地址</th>
      <th>收货单类型</th>
      <th>状态</th>
      <th>备注</th>
      <th>操作 <a href="${pageContext.request.contextPath }/receipt/toInsertPage" style="font-weight:normal">创建收货单</a></th>
    </tr>
	<tbody id="content_table_body">
		<c:forEach items="${list}" var="i">
				<tr>
					<td>
						${i.storerkey}
					</td>
					<td>
						${i.company}
					</td>
					<td>
						${i.phone}
					</td>
					<td>
						${i.address}
					</td>
					<td>
						${i.type}
					</td>
					<td>
						${i.status}
					</td>
					<td>
						${i.comment}
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/receiptdetail/findReceiptdetailByStorerkey/${i.storerkey}"> 查看明细  </a>
						<button type="button" <c:if test="${i.status=='已收货' }">disabled="disabled"</c:if> onclick="return check(${i.storerkey});">收货</button>
						<a href="${pageContext.request.contextPath }/receipt/delete/${i.storerkey}" onclick="return confirm('确认删除吗？想好了吗？');"> 删除 </a>
					</td>
				</tr>
			</c:forEach>
	</tbody>
  	</table>
  </body>
</html>
