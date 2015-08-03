<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>找回密码</title>
     <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
   <s:include value="userTop.jsp"></s:include>
    <div style="width: 400px;margin: 0 auto;">
    <br/><br/><br/>
    <s:fielderror></s:fielderror>
    <form action="checkCodeEmail" method="post">
    <label>请输入注册邮箱：</label>
	<input type="email" class="form-control" id="userEmail" placeholder="请输入您的注册邮箱" required="required" name="userEmail" >
	<input type="button" id="get" value="获取验证码" class="btn btn-warning">
	<br/>
	<label>请输入验证码：</label>
	<input type="text" class="form-control" id="userCode" placeholder="请输入您得到验证码" required="required" name="userCode" >
	<input type="submit" class="btn btn-success" value="确认">
	</form>
	<script type="text/javascript">
	$("#get").stop(true,true).click(function(){
	var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	
	//发送验证码到邮箱
	var userEmail=$("#userEmail").val();
	if(userEmail==null||userEmail.length==0)
	{
	alert("邮件不能为空,验证码发送失败");
	return;
	}
	if(!reg.test(userEmail))
	{
	alert("您输入的不是邮箱，请重新输入");
	return;
	}
	
	//异步请求获取验证码，并将验证码写入数据库
	$.ajax({data:{
	userEmail:$("#userEmail").val()
	},dataType:"JSON",success:function(date){
	
	if(date=="false")
	{
		alert("该邮箱不存在");
	}
	
	}
	,type:"post",url:"sendCode"})
	
	
	
	//60s后重新获取验证码
	 count = 60;
	 $("#get").attr("disabled", true);
	 
	 	  var time=setInterval(function(){
		      
			  $("#get").val(count+"s后重新获取验证码");
			  if (count == 0) 
			  {
			     $("#get").val("获取验证码").removeAttr("disabled");
			     clearInterval(time);
			  }
			  else
			  {
			  count--;
			  }
		  }, 1000);
	
	})
	
	</script>
    
    </div>
  </body>
</html>
