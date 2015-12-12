<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>

</head>
<script>
function addCheck()
{
var password=document.getElementById("user_pw").value;
var password1=document.getElementById("user_pw1").value;
var password2=document.getElementById("user_pw2").value;

var obj2=document.getElementById("show2");
var obj3=document.getElementById("show3");
var obj4=document.getElementById("show4");
if ( password.length > 16 || password.length < 6) {                
	obj2.style.display="block";
	} else { 
		obj2.style.display="none";       
		}
if ( password1.length > 16 || password1.length < 6) {                
	obj3.style.display="block";
	} else { 
		obj3.style.display="none";       
		}
if ( password2.length > 16 || password2.length < 6) {                
	obj4.style.display="block";
	} else { 
		obj4.style.display="none";       
		}
}
</script>
</head>
<body bgcolor="EBEBEB">
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
<%String rrole=request.getSession().getAttribute("role").toString();
 if(rrole.equals("普通员工")){
	 %>
	 <%@ include file="common_employee.jsp"  %>
	 <%  
 }
if(rrole.equals("财务部")){
	%>
	 <%@ include file="common_finance.jsp"  %>
	 <% 
	 
 }
if(rrole.equals("审批领导")){
	%>
	 <%@ include file="common_manager.jsp"  %>
	 <%
}
 %>
</div>
<br><br>
<img src="<%=request.getContextPath()%>/img/login.jpg" width="400" height="500" align=left hspace="50"><br><br>
 
<center > 
  <label align="center"><font face="幼圆" size="6">修改密码</font></label>
</center>
<form action="updatepw.servlet"  method="post" >
<table align="left">
<tr>
<td><font face="幼圆" size="4" color="A0522D"><label>用户名：</label></font></td>
<td><input  id="user_id" style="boder:2px inset #BCD2EE"  placeholder="输入工号" name="username" value="<%=request.getSession().getAttribute("employee_id").toString()%>" readonly="true"/></td>

</tr>
<tr><td>
<font face="幼圆" size="4" color="A0522D"><label>旧密码：</label></font></td>
<td><input id="user_pw" type="password"  placeholder="输入密码" name="password" onkeyup="addCheck()"/>
<span id="hintPassword"></span></td>
<td><font face="楷体" size="3" color="000000"><label  id="show2" >密码的长度在6到16位</label></font></td>
</tr>
<tr>
<td><font face="幼圆" size="4" color="A0522D"><label>新密码：</label></font></td>
<td><input id="user_pw1" type="password"  placeholder="输入密码" name="password1" onkeyup="addCheck()"/>
<span id="hintPassword"></span></td>
<td><font face="楷体" size="3" color="000000"><label  id="show3" >密码的长度在6到16位</label></font></td>
</tr>
<tr>
<td><font face="幼圆" size="4" color="A0522D"><label>再次确认密码：</label></font></td>
<td><input id="user_pw2" type="password"  placeholder="输入密码" name="password2" onkeyup="addCheck()"/>
<span id="hintPassword"></span></td>
<td><font face="楷体" size="3" color="000000"><label  id="show4" >密码的长度在6到16位</label></font></td>
</tr>
<tr><td></td>
<td conspan="3" align="center"><input type="submit" class="btn btn-primary" value="提交" /></td>
</table>
</form>
</div>
</div>
</div>
</body>
</html>