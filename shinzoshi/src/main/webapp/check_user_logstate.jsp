<%@ page language="java" import="java.util.*,com.ggjj.zhzz.pojo.Admin" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Admin admin=(Admin)session.getAttribute("admin");
if(admin==null){
    response.getWriter().println("<script>top.location.href='" + basePath + "index.jsp';</script>");
}
%>