<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
 <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  </head>
  
  <body>
  <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
  <%
    if(request.getSession().getAttribute("user")==null)
    {
   %>
  <ul class="nav nav-pills">
  <li role="presentation" ><a href="index.jsp">首页</a></li>
  <li role="presentation" ><a href="login.jsp">登录</a></li>
  <li role="presentation" ><a href="register.jsp">注册</a></li>
  <li role="presentation" ><a href="sendCode.jsp">找回密码</a></li>
  </ul>
  <%}
  else
  {
  %>
  <ul class="nav nav-pills">
  <s:if test="#session.userPI.userLogo==null">
    <li><img alt="默认头像" src="userLogo/user_large.jpg" width="50px" height="50px"></li>
   </s:if>
   <s:else>
   <li><img alt="头像" src="${session.userPI.userLogo}" width="50px" height="50px"></li>
   </s:else>
  
  <li role="presentation" ><a href="index.jsp">首页</a></li>
  <li role="presentation" ><a href="userCenter.jsp">个人中心</a></li>
  <li role="presentation" ><a href="logout">退出</a></li>
 
  
  </ul>

  <% 
  }
   %>
  </div>
  </nav>
  </body>
</html>
