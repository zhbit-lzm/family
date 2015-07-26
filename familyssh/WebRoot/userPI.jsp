<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ taglib  prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户个人信息</title>
    <sx:head extraLocales="UTF-8" />
  </head>
  
  <body>
  <%
  	if(request.getSession().getAttribute("user")==null)
  	{
  		response.sendRedirect("/index.jsp");
  	}
   %>
   
   <div style="width: 500px;margin: 0 auto;">
   <s:include value="userTop.jsp"></s:include>
   <br/>
   <br/>
   <br/>
   <form action="updateUserPI">
   <table class="table table-bordered">
   <tr><td width="100px">姓名：</td><td><input type="text" name="PI.userName"  value='<s:property value="PI.userName" />' required="required" class="form-control"></td></tr>
   
   <s:if test="PI.userSex==\"男\"">
   <tr><td>性别：</td><td>男<input type="radio" value="男" name="PI.userSex" checked="checked">女<input type="radio" value="女" name="PI.userSex"></td></tr>
   </s:if>
   <s:else>
   <tr><td>性别：</td><td>男<input type="radio" value="男" name="PI.userSex">女<input type="radio" value="女" name="PI.userSex" checked="checked"></td></tr>
   </s:else>
   
   
   <tr><td>地址：</td><td><input type="text" name="PI.userAddress" value='<s:property value="PI.userAddress" />' required="required" class="form-control"></td></tr>
   <tr><td>电话：</td><td><input type="text" name="PI.userPhone" value='<s:property value="PI.userPhone" />' required="required" class="form-control"></td></tr>
   <tr><td>出生日期：</td><td><sx:datetimepicker name="PI.userBirthday" displayFormat="yyyy-MM-dd"  value="%{PI.userBirthday}"/> </td></tr>
   <input type="hidden" name="PI.oid" value='<s:property value="PI.oid"/>'>
   <tr><td colspan="2"><input type="submit" value="修改" class="btn btn-success"><a href="userCenter.jsp" class="btn btn-default">返回</a></td></tr>
   </table>
   </form>
   
   
   
   </div>
    
  </body>
</html>
