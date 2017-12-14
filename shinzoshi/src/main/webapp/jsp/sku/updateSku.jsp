<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>updateSku</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/sku/update" method="post">
     <input type="hidden" name="sku" value="${sku.sku }">
     <table>
     	<tr>
			<td>货品编码:</td>
			<td>${sku.sku }</td>
		</tr>
		<tr>
			<td>货品名字:</td>
			<td><input type="text" name="name" value="${sku.name}"></td>
		</tr>
		<tr>
			<td>货品类型:</td>
			<td><input type="text" name="category" value="${sku.category }"></td>
		</tr>
		<tr>
			<td>重量:</td>
			<td><input type="text" name="weight" value="${sku.weight }"></td>
		</tr>
		<tr>
			<td>零售价:</td>
			<td><input type="text" name="retailprice" value="${sku.retailprice }"></td>
		</tr>
		<tr>
			<td>采购价:</td>
			<td><input type="text" name="purchaseprice" value="${sku.purchaseprice }"></td>
		</tr>
		<tr>
			<td>备注:</td>
			<td><input type="text" name="comment" value="${sku.comment }"></td>
		</tr>
		<tr>
			<td>货主编码:</td>
			<td>
			<select name="storerkey" id="sel">
				<option value="0">=请选择=</option>
				<c:forEach var="storer" items="${list }">
					<option value="${storer.storerkey }" <c:if test="${sku.storerkey==storer.storerkey }">selected</c:if>>${storer.storerkey }</option>
				</c:forEach>
			</select>	
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="修改">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/sku/findAll'"/>
			</td>
		</tr>
	</table>
    </form>
     
  </body>
</html>
