<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户个人中心</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  	<link rel="stylesheet" type="text/css" href="css/button.css">
  </head>
  <body>
  
  <%if(request.getSession().getAttribute("user")==null)
  {
  response.sendRedirect("index.jsp");
  }
   %>
    <s:include value="userTop.jsp"></s:include>
    <div style="width: 980px; margin: 0 auto;">
   <div class="row">
   <br/>
   <br/>
   <br/>
 	<div class="col-md-4"><form action="resetPassword.jsp"><input type="submit" value="修改密码" class="mybutton"></form></div>
    <div class="col-md-4"><form><input type="submit" value="修改头像" class="mybutton"></form></div>
    <div class="col-md-4"><form><input type="submit" value="修改个人 信息" class="mybutton"></form></div>
   </div>
   </div>
    
    
  </body>
</html>
