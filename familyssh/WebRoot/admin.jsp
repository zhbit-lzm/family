<%@ page language="java" import="java.util.*,com.tablebean.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员界面</title>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
  <%
  
  if(request.getSession().getAttribute("user")!=null)
  {
  	
  	 UserInfo user=(UserInfo)request.getSession().getAttribute("user");
  	 if(user.getUserType().getTypeValue()!=2)
  	 {
  	  response.sendRedirect("/index.jsp");
  	 }
  	 
  }
  else
  {
 	 response.sendRedirect("/index.jsp");
  }
  
   %>
  <s:include value="userTop.jsp"></s:include>
  <div style="margin: 0 auto;width: 300px;">
  <br/>
  <br/>
  <br/>
  <form action="getUsers" method="post">
  <input type="submit" class="btn btn-default" value="用户授权管理">
  </form>
  <form action="getAllRelationship" method="post">
  <input type="submit" class="btn btn-default" value="用户关系设定">
  </form>
  
  </div>
  
   
  </body>
</html>
