<%@ page language="java" import="java.util.*,com.tablebean.*,com.bean.Family" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>关系设定</title>
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
     <br/><br/><br/>
     
     <div class="container">
     <table class="table table-bordered">
     <tr><td>姓名</td><td>父亲</td><td>母亲</td><td>配偶</td></tr>
     <s:iterator value="list" id="family">
     <tr>
     
     <td>
     <div class="row">
     <div class="col-md-2"> <img width="50px" height="50px" alt="无法显示" src='<s:property value="#family.myself.userLogo" />'>
     </div>
     <div class="col-md-8">
            &nbsp;&nbsp;姓名：<s:property value="#family.myself.userName"/><br/>
            &nbsp;&nbsp;性别：<s:property value="#family.myself.userSex"/><br/>
            &nbsp;&nbsp;诞晨：<s:date name="#family.myself.userBirthday" format="yyyy-MM-dd" />  
     </div>
     </div>
     </td>
     
     <td>
     <div class="row">
     <div class="col-md-2"> <img width="50px" height="50px" alt="无法显示" src='<s:property value="#family.father.userLogo" />'>
     </div>
     <div class="col-md-8">
            &nbsp;&nbsp;姓名：<s:property value="#family.father.userName"/><br/>
            &nbsp;&nbsp;性别：<s:property value="#family.father.userSex"/><br/>
            &nbsp;&nbsp;诞晨：<s:date name="#family.father.userBirthday" format="yyyy-MM-dd" />  
     <form action="" method="post" >
     <input type="submit" value="设置父亲" class="btn btn-primary"> 
     </form>
     </div>
     </div>
     </td>
     
      <td>
     <div class="row">
     <div class="col-md-2"> <img width="50px" height="50px" alt="无法显示" src='<s:property value="#family.mother.userLogo" />'>
     </div>
     <div class="col-md-8">
            &nbsp;&nbsp;姓名：<s:property value="#family.mother.userName"/><br/>
            &nbsp;&nbsp;性别：<s:property value="#family.mother.userSex"/><br/>
            &nbsp;&nbsp;诞晨：<s:date name="#family.mother.userBirthday" format="yyyy-MM-dd" />  
     <form action="" method="post" >
     <input type="submit" value="设置母亲" class="btn btn-primary"> 
     </form>
     </div>
     </div>
     </td>
     
      <td>
     <div class="row">
     <div class="col-md-2"> <img width="50px" height="50px" alt="无法显示" src='<s:property value="#family.Spouse.userLogo" />'>
     </div>
     <div class="col-md-8">
            &nbsp;&nbsp;姓名：<s:property value="#family.Spouse.userName"/><br/>
            &nbsp;&nbsp;性别：<s:property value="#family.Spouse.userSex"/><br/>
            &nbsp;&nbsp;诞晨：<s:date name="#family.Spouse.userBirthday" format="yyyy-MM-dd" />  
     <form action="" method="post" >
     <input type="submit" value="设置配偶" class="btn btn-primary"> 
     </form>
     </div>
     </div>
     </td>
     <!--  
     <td>
     <form action="" method="post" >
     <input type="submit" value="设置父亲" class="btn btn-primary"> 
     </form>
     <form action="" method="post" >
     <input type="submit" value="设置母亲" class="btn btn-primary"> 
     </form>
     <form action="" method="post" >
     <input type="submit" value="设置配偶" class="btn btn-primary"> 
     </form>
     
     </td>
     -->
     
     </tr>
     
     </s:iterator>
     
     </table>
     </div>
     
  </body>
</html>
