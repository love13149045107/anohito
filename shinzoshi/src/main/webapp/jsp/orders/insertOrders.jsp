<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>insertOrders</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<script type="text/javascript">
		var a1=new Array();
		var a2=new Array();
		<c:forEach var="sku" items="${list }">
			a1.push("${sku.sku }");
			a2.push("${sku.name }");
		</c:forEach>
		function selectType(){
			var se1=document.getElementById('se1');
			var se2=document.getElementById('se2');
			var i=0;
			for(i=0;i<a1.length;i++){
				 if(se1.value==a1[i])
					 break;
				}
			se2.value=a2[i];
		}
	</script>
  </head>
  
  <body>

     <form action="${pageContext.request.contextPath }/orders/insert" method="post">
    	<table>
		<tr>
			<td>货品编码:</td>
			<td>
				<select name="sku" id="se1" onchange="selectType()">
					<c:forEach var="sku" items="${list }">
						<option value="${sku.sku }">${sku.sku }</option>
					</c:forEach>
				</select>	
			</td>
		</tr>
		<tr>
			<td>货品名称:</td>
			<td><input type="text" name="name" value="${list[0].name }" id="se2" readonly/></td>
		</tr>
		<tr>
			<td>数量:</td>
			<td><input type="text" name="quantity"></td>
		</tr>
		
		<tr>
			<td>
				<input type="submit" value="创建">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/orders/findAll'"/>
			</td>
		</tr>
	</table>
    </form>
  </body>
</html>
