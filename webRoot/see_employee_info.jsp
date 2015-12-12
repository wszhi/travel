<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
            <%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>员工信息完善</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>
 
<script> 
$(document).ready(function(){
  $("img").click(function(){
    var div=$("div");  
    div.animate({left:'1210px'},"slow");
   // height:'toggle'
  });
});
function back() {
	history.back();
}
</script> 

</head>
<body >
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
<center > 
  <font face="幼圆" size="6">员工查看个人信息</font><br><br>
  </center>
   <form action=""  method="post" >
 <br>
  <center>
 <font face="幼圆" size="3">
 <table  class="table table-bordered table-condensed table-hover"  border="0" class="col-sm-12" style="background: rgba(255 ,246 ,143, 0.3);filter: alpha(opacity=30)">
<tr ><td align="right" class="col-sm-2">员工名：</td><td class="col-sm-4">${employee.name}</td>
<td align="right" >性别：</td><td  class="col-sm-10">${employee.sex}</td></tr>
  <tr ><td align="right"  class="col-sm-2" >出生年月：</td><td  class="col-sm-4">${employee.birth}</td>
  <td align="right" class="col-sm-2" >电话：</td><td  class="col-sm-4">${employee.tel}</td></tr>
  <tr ><td align="right" class="col-sm-2">地址：</td><td class="col-sm-4">${employee.address}</td>
  <td align="right" class="col-sm-2">Email：</td><td  class="col-sm-4">${employee.email}</td></tr>
  <tr ><td align="right" class="col-sm-2">证件号：</td><td >${employee.identity_num}</td>
  <td align="right" class="col-sm-2">入职时间：</td><td >${employee.entry_time}</td></tr>
   <tr ><td align="right" class="col-sm-2">部门：</td><td ><%=request.getSession().getAttribute("department_name").toString()%></td>
  <td align="right" class="col-sm-2">职位：</td><td >${employee.position}</td></tr>
 <tr ><td align="right" class="col-sm-2">月薪：</td><td colspan="8">${employee.salary}</td></tr>
 
  </table><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="back()" class="btn btn-primary" value="返回" style="width:220px;height:40px;color:white;">
     
</font> </center></form>
     </div>
</div>
</div>
</body>
</html>