<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>头像更新</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  </head>
  
  <body>
  <%if(request.getSession().getAttribute("user")==null)
  {
  	response.sendRedirect("index.jsp");
  }
   %>
  
  
  <s:include value="userTop.jsp"></s:include>
   <div style="width: 300px;margin: 0 auto;">
   <br/>
   <br/>
   <br/>
   <s:fielderror></s:fielderror>
   <s:if test="#session.userPI.userLogo==null">
     <img id="logo" alt="默认头像" src="userLogo/user_large.jpg" width="200px" height="200px">
   </s:if>
   <s:else>
   <img id="logo" alt="头像" src="${session.userPI.userLogo}" width="200px" height="200px">
   </s:else>
   <form action="uploadUserLogo" enctype="multipart/form-data" method="post">
   <s:file name="upload" id="file"></s:file>
   <input type="submit" value="上传 " class="btn btn-success">
   <a href="userCenter.jsp" class="btn btn-default ">返回</a>
   </form>
   
   <script type="text/javascript">
					$("#file").change(function()
					{
					
						var file = this.files[0]; 
						
    					if(!/image\/\w+/.test(file.type)){ 
       					alert("文件必须为图片！"); 
    					}
    					else
    					{
    						
    						var reader = new FileReader();
    						reader.readAsDataURL(this.files[0]);
    						 reader.onload = function(e){ 
    						 $("#logo").attr("src", this.result);
    						
    						 }
    					}
					})
					</script>
  
 
   </div>
  </body>
</html>
