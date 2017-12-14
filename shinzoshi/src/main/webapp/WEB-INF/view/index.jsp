<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<title>仓库管理系统-主页</title>
<link href="css/index.css" rel="stylesheet" type="text/css" />
 </head>
<body>
<div id="container">
	<div id="banner"><img src="images/logo.gif" /></div>
	<div id="globallink">
		<ul>
			<li><a href="index.jsp">首页</a></li>
			<li><a href="Department/frontlist" target="OfficeMain">部门</a></li> 
			<li><a href="Position/frontlist" target="OfficeMain">职位</a></li> 
			<li><a href="Employee/frontlist" target="OfficeMain">员工</a></li> 
		</ul>
		<br />
	</div> 

	<div id="loginBar">
	 
	  <form action="frontLogin" style="height:25px;margin:0px 0px 2px 0px;" method="post">
		用户名：<input type=text name="userName" size="12"/>&nbsp;&nbsp;
		密码：<input type=password name="password" size="12"/>&nbsp;&nbsp;
		<input type=submit value="登录" />
	  </form>
	 
	    <ul>
	    	<li><a href="UserInfo//update" target="OfficeMain">【修改个人信息】</a></li>
	    	<li><a href="logout">【退出登陆】</a></li>
	    </ul>

	</div> 

	<div id="main">
	 <iframe id="frame1" src="desk.jsp" name="OfficeMain" width="100%" height="100%" scrolling="yes" marginwidth=0 marginheight=0 frameborder=0 vspace=0 hspace=0 >
	 </iframe>
	</div>
	<div id="footer">
		<p>&nbsp;&nbsp;更多设计到：<a href="http://www.shuangyulin.com" target="_blank">双鱼林设计网</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.jsp"><font color=red>后台登陆</font></a></p>
	</div>
</div>
</body>
</html>
