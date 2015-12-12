<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"></style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styledcar.css"  type="text/css" />

<!-- 登录和修改密码所需的css文件 -->
<link rel="shortcut icon" href="<%=request.getContextPath() %>/../favicon.ico"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/demo.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style1.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/animate-custom.css" />
 <script>
function addCheck()
{
var name=document.getElementById("user_id").value;
var password=document.getElementById("user_pw").value;
var obj1=document.getElementById("show1");
var obj2=document.getElementById("show2");
if(name.length != 10) 
{ 
	obj1.style.display="block";
	document.getElementById("user_id").focus(); 
	return false; 
}
else
	{
	obj1.style.display="none";
	}
if ( password.length > 16 || password.length < 6) {                
	obj2.style.display="block";
	document.getElementById("user_pw").focus();
	return false;
	} else { 
		obj2.style.display="none";       
		}
}
</script>
</head>
<body style="background-image: url(<%=request.getContextPath()%>/img/loginbg.jpg);background-size:cover">
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
      <div>
     <%@ include file="common.jsp"  %>
     </div>
     <br><br>
<section style="align:right">				
<div id="container_demo" style="align:right">
   <a class="hiddenanchor" id="toregister"></a>
     <a class="hiddenanchor" id="tologin"></a>
        <div id="wrapper">
           <div id="login" class="animate form">
<form  action="login.servlet" autocomplete="on"> 
  <h1>登录</h1> 
  <p><label >类型：</label><br>
<select type="select" name="Item" id="type" required="required" style="width:380px;height:40px;color:black;">    
 <option value="普通员工">普通员工 </option> 
    <option value="财务部">财务部</option> 
    <option value="审批领导">审批领导</option> 
    <option value="超级管理员">超级管理员</option>  
     </select> 
</p>
<p> 
<label for="username" class="uname" data-icon="u" >用户名：</label>
<input  id="user_id"  placeholder="输入工号" class="form-control" border="1" name="username" required="required" onkeyup="addCheck()"/></td>
<font face="楷体" size="3" color="000000"><td style="size:3">
<label  id="show1" >工号为10位的固定长度数字</label>
<span id="hintUserName"></span>
</font>
</p>
<p> 
<label for="password" class="youpasswd" data-icon="p">密码：</label>
<td><input id="user_pw" type="password" class="form-control" required="required" placeholder="输入密码" name="password" onkeyup="addCheck()"/>
<span id="hintPassword"></span></td>
<font face="楷体" size="3" color="000000"><td><label  id="show2" >密码的长度在6到16位</label>
</font>
</p>
<p class="keeplogin"> 
<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
<label for="loginkeeping">记住密码</label>
</p>
<p class="login button">
<input  type="submit" class="btn btn-primary" value="登录" /> 
</p>
<p class="change_link">
登录遇到问题?
<a href="#toregister" class="to_register">去解决</a>
</p>
</form>
</div>
<div id="register" class="animate form">
     <form   autocomplete="on"> 
          <h1>登录说明 </h1> 
<p> 
<label  class="uname" >1.统一身份认证用户名为本人工号，初始密码为123456；</label>
</p>
<p> 
<label class="youpasswd" >2.如果输入的账号密码登录不成功，请尝试使用密码 888888 进行登录；
</label>
</p>
<p> 
<label class="youpasswd" >3.如果账号密码仍然无法登录，请拨打技术支持电话 027-68778177 或发送电子邮件到 aboutmy@ccnu.edu.cn 联系网络中心蔡老师或曹老师寻求帮助。</label>
</p>
<p class="change_link">  
去登录？
<a href="#tologin" class="to_register">登录</a>
</p>
</form>
</div>
</div>
</div>  
</section>
</div>
</div>
</div>
<div class="street" >
		<div class="car">
		<div class="car-body">
			<div class="car-top-back">
				<div class="back-curve"></div>
			</div>
			<div class="car-gate"></div>
			<div class="car-top-front">
				<div class="wind-sheild"></div>
			</div>
			<div class="bonet-front"></div>
			<div class="stepney"></div>
		</div>
		
		<div class="front-bumper"></div>
		<div class="tyre">		
			<div class="gap"></div>	
		</div>
		<div class="tyre front">
			<div class="gap"></div>	
		</div>
		<div class="car-shadow"></div>
	</div>
	</div>
</body>
</html>