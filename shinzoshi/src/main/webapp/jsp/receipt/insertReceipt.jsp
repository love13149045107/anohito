<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>insertReceipt</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<script type="text/javascript">
		function selectType(){
			document.getElementById('s').value=document.getElementById('ss').value;
		}
	</script>
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/receipt/insert" method="post">
     	<input type="hidden" name="storerkey" id="s">
    	<table>
    	<tr>
			<td>货主编码:</td>
			<td><input type="text" name="receipt.storerkey" id="ss" onchange="selectType()"></td>
		</tr>
		<tr>
			<td>供应商:</td>
			<td><input type="text" name="receipt.company"></td>
		</tr>
		<tr>
			<td>供应商联系电话:</td>
			<td><input type="text" name="receipt.phone"></td>
		</tr>
		<tr>
			<td>地址:</td>
			<td><input type="text" name="receipt.address"></td>
		</tr>
		<tr>
			<td>收货单类型:</td>
			<td><input type="text" name="receipt.type"></td>
		</tr>
		<tr>
			<td>状态:</td>
			<td>
				<select name="receipt.status">
					<option value="未收货">未收货</option>
					<option value="已收货">已收货</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>备注:</td>
			<td><input type="text" name="receipt.comment"></td>
		</tr>

		<tr>
			<td>
				<input type="submit" value="创建">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/receipt/findAll'"/>
			</td>
		</tr>
	</table>
    </form>
  </body>
</html>
