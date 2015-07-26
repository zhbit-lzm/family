<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
     <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    
     
  </head>
  
  <body>
   <s:include value="userTop.jsp"></s:include>
   
   <div style="margin:0 auto; width: 400px; float: inherit;">
   <br/>
   <br/>
   <br/>
   <s:fielderror></s:fielderror>
   <s:form action="register" namespace="/" method="post">
   <table >
   <tr><td><label>注册帐号：</label></td></tr>
   
   <tr><td>
   <input id="userAccount" type="text" name="user.userAccount" class="form-control" placeholder="请输入帐号" required="required"> 
   </td><td>
   <span id="su"></span>
   </td></tr>
	
   <tr><td><label>密码：</label></td></tr>
   <tr><td>
   <input type="password" id="p1" name="user.userPassword" class="form-control" placeholder="请输入密码" required="required">
   </td><td>
   <span id="sp1"></span>
   </td></tr>
   
   <tr><td><label>重复密码：</label></td></tr>
   <tr><td>
   <input type="password" id="p2"  class="form-control" placeholder="请输入密码" required="required"><br/>
   </td><td>
   <span id="sp2"></span>
   </td></tr>
   
   <tr><td><label>电子邮件</label></td></tr>
   <tr><td>
   <input type="email" id="e1" name="user.userEmail" class="form-control" placeholder="请输入邮件" required="required"><br/>
   </td></tr>
   
   <tr><td>
   <input id="but1" type="submit" value="注册"  class="btn btn-primary">
 
   <script type="text/javascript">
   $("#but1").click(function(){
   
   var account=$("#userAccount").val();
   var p1=$("#p1").val();
   var p2=$("#p2").val();
	
	if(account.length<6||account.length>18)//6-18位的帐号
	{
		$("#su").text("帐号长度必须为6-18位");
		$("#su").removeClass();
		$("#su").addClass("glyphicon glyphicon-remove");
		return false;
	}
	else
	{
		$("#su").text("");
		$("#su").removeClass();
		$("#su").addClass("glyphicon glyphicon-ok");
	}
	
	if(p1.length<6||p1.length>18)
	{
		$("#sp1").text("密码长度必须为6-18位");
		$("#sp1").removeClass();
		$("#sp1").addClass("glyphicon glyphicon-remove");
		return false;
	}
	else
	{
		$("#sp1").text("");
		$("#sp1").removeClass();
		$("#sp1").addClass("glyphicon glyphicon-ok");
	}
	
	if(p1!=p2)
	{
		$("#sp2").text("密码必须一致");
		$("#sp2").removeClass();
		$("#sp2").addClass("glyphicon glyphicon-remove");
		return false;
	}
	else
	{
		$("#sp2").text("");
		$("#sp2").removeClass();
		$("#sp2").addClass("glyphicon glyphicon-ok");
	}
   
   
   return true;
   })
   </script>
 
   <input type="reset" value="重置" class="btn btn-warning">
   </td>
   </table>
   </s:form>
 	
   </div>
  </body>
</html>
