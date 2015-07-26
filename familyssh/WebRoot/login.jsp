<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
  <s:include value="userTop.jsp"></s:include>
  <div style="margin: 0 auto;width: 300px;">
  <br/>
  <br/>
  <br/>
  <s:fielderror name="error"></s:fielderror>
  <s:form action="login" namespace="/" method="post">
  <label>帐号：</label>
  <input type="text" name="user.userAccount" class="form-control" placeholder="请输入帐号" required="required"><br/>
  <label>密码：</label>
  <input type="password" name="user.userPassword" class="form-control" placeholder="请输入密码" required="required"><br/>
  <input type="submit" value="登录"  class="btn btn-primary">
  <a href="index.jsp"  class="btn btn-default">找回密码</a>
  </s:form>
  </div>
  
  
  </body>
</html>
