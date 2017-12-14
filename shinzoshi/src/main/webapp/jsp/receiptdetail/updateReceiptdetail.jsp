<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>updateReceiptdetail</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/receiptdetail/update" method="post">
     	<input type="hidden" name="storerkey" value="${receiptdetail.storerkey}">
     	<input type="hidden" name=receiptdetailId value="${receiptdetail.receiptdetailId}">
    	<table>
    	<tr>
			<td>货主编码:</td>
			<td>${receiptdetail.storerkey}</td>
		</tr>
     	<tr>
			<td>货品编码:</td>
			<td><input type="text" name="sku" value="${receiptdetail.sku}"></td>
		</tr>
		<tr>
			<td>数量:</td>
			<td><input type="text" name="quantity" value="${receiptdetail.quantity}"></td>
		</tr>
		<tr>
			<td>货品名称:</td>
			<td><input type="text" name="name" value="${receiptdetail.name}"></td>
		</tr>
		<tr>
			<td>货品类型:</td>
			<td><input type="text" name="category" value="${receiptdetail.category}"></td>
		</tr>
		<tr>
			<td>重量:</td>
			<td><input type="text" name="weight" value="${receiptdetail.weight}"></td>
		</tr>
		<tr>
			<td>收货库位:</td>
			<td>
				<select name="loc">
					<option value="${receiptdetail.loc }">${receiptdetail.loc }</option>
					<c:forEach var="loc" items="${list }">
						<option value="${loc.loc }">${loc.loc }</option>
					</c:forEach>
				</select>
			</td>
		</tr>

		<tr>
			<td>
				<input type="submit" value="修改">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/receiptdetail/findReceiptdetailByStorerkey/${receiptdetail.storerkey}'"/>
			</td>
		</tr>
	</table>
    </form>
  </body>
</html>
