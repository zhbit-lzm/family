<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户授权管理</title>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>
  <s:include value="userTop.jsp"></s:include>
    <div style="margin: 0 auto;width: 980px;">
    <br/>
    <br/>
    <br/>
    <table class="table table-bordered">
    <tr><td>用户编号</td><td>用户电子邮件</td><td>授权</td><td colspan="2">操作</td></tr>
    <s:iterator id="list" value="userList">
    <tr>
    <td><s:property value="#list.oid" /></td>
    <td><s:property value="#list.userEmail"/></td>
    <s:if test="#list.usable==true">
    <td>已授权</td>
    </s:if>
    <s:else>
    <td>没授权</td>
    </s:else>
    
    <td>
    <form action="acceptUser" method="post">
    <input type="submit" value="授权" class="btn btn-success">
    <input name="user.oid" type="hidden" value='<s:property value="#list.oid"/>' >
    </form>
    </td>
    <td>
    <form action="refuseUser" method="post">
    <input type="submit" value="拒绝" class="btn btn-danger">
    <input name="user.oid" type="hidden" value='<s:property value="#list.oid"/>' >
    </form>
    </td>
    
    </tr>
    </s:iterator>
    </table>
    </div>
  </body>
</html>
