<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>设置密码</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    

  </head>
  
  <body>
  <% if(request.getSession().getAttribute("PR")==null)
  {
  	response.sendRedirect("/index.jsp");
  }
   %>
    <s:include value="userTop.jsp"></s:include>
    <div style="margin: 0 auto;width: 300px;">
  <br/>
  <br/>
  <br/>
  <s:fielderror></s:fielderror>
 <form action="findBackPassword" method="post">
    <table>
    <tr><td>
    <label>新密码：</label></td></tr>
   
   <tr><td> <input type="password" id="p1" name="userPassword" class="form-control" placeholder="请输入新密码" required="required">
    </td><td>
    <span id="sp1"></span></td></tr>
    <tr><td>
    <label>重复输入密码：</label></td></tr>
    <tr><td>
    <input type="password" id="p2"  class="form-control" placeholder="请重复输入密码" required="required">
    </td><td>
    <span id="sp2"></span></td></tr>
    
    <tr><td>
	<input type="submit" id="bt" value="提交" class="btn btn-success">
	<input type="reset"  value="重置" class="btn btn-default"></td></tr>
   	</table>
    </form>
    
    
  	<script type="text/javascript">
  	$("#bt").click(function(){
  	var p1=$("#p1").val();
  	var p2=$("#p2").val();
  	
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
  
  </div>
    
  </body>
</html>
