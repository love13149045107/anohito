<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>insertLoc</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
     <form action="${pageContext.request.contextPath }/loc/insert" method="post">
    	<table>
     	<tr>
			<td>库位编码:</td>
			<td><input type="text" name="loc" value="${loc.loc }"></td>
		</tr>
		<tr>
			<td>库位类型:</td>
			<td>
				<select name="type">
					<option value="OTHER">OTHER</option>
					<option value="CASE">CASE</option>
					<option value="PICK">PICK</option>
					<option value="STAGE">STAGE</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>库位区域:</td>
			<td><input type="text" name="putawayzone" value="${loc.putawayzone }"></td>
		</tr>
		<tr>
			<td>堆栈限制:</td>
			<td><input type="text" name="stacklimit" value="${loc.stacklimit }"></td>
		</tr>
		<tr>
			<td>地面托盘数:</td>
			<td><input type="text" name="footprint" value="${loc.footprint }"></td>
		</tr>
		<tr>
			<td>库存数量:</td>
			<td><input type="text" name="quantity" value="${loc.quantity }"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="添加">
			</td>
			<td>
				<input type="button" value="取消" onclick="window.location='${pageContext.request.contextPath }/loc/findAll'"/>
			</td>
		</tr>
	</table>
    </form>
  </body>
</html>
