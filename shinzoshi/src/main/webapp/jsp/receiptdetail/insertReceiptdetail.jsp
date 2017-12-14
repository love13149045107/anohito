<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>insertReceiptdetail</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/receiptdetail/insert" method="post">
     	<input type="hidden" name="storerkey" value="${storerkey}">
    	<table>
    	<tr>
			<td>货主编码:</td>
			<td>${storerkey}</td>
		</tr>
     	<tr>
			<td>货品编码:</td>
			<td><input type="text" name="sku"></td>
		</tr>
		<tr>
			<td>数量:</td>
			<td><input type="text" name="quantity"></td>
		</tr>
		<tr>
			<td>货品名称:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>货品类型:</td>
			<td><input type="text" name="category"></td>
		</tr>
		<tr>
			<td>重量:</td>
			<td><input type="text" name="weight"></td>
		</tr>
		<tr>
			<td>收货库位:</td>
			<td>
				<select name="loc">
					<c:forEach var="loc" items="${list }">
						<option value="${loc.loc }">${loc.loc }</option>
					</c:forEach>
				</select>
			</td>
		</tr>

		<tr>
			<td>
				<input type="submit" value="创建">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/receiptdetail/findReceiptdetailByStorerkey/${storerkey}'"/>
			</td>
		</tr>
	</table>
    </form>
  </body>
</html>
