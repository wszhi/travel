<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"
    %>
    <%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>出差申请单列表</title>
</head>
 <style>
 body {
  	-webkit-background-size: cover;
	  -moz-background-size: cover;
	  -o-background-size: cover;
	  background-size: cover;
    padding-top:20px;
    font-family: 'Lato', sans-serif;
}
 </style>
 <body style="background:url(<%=request.getContextPath()%>/img/bgimg2.jpg);background-size:cover;">
  <div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
       <%@ include file="common_employee.jsp"  %> 
       <br>
       <font face="幼圆" size="5">查询条件：</font> 
 <center>
 <form action="see2.do" enctype="multipart/form-data">
  
  <font face="幼圆" size="5">申请时间：</font>
  <input class="Wdate" type="text" name="triptab.apply_time" style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="幼圆" size="5">申请单状态：</font>
  <select id="triptab.state" name="triptab.state" style="width:220px;height:30px;">
  <option value=></option>
<option value="未审核">未审核</option>
<option value="未通过">未通过</option>
<option value="通过">通过</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" id="triptab.employee_id" name="triptab.employee_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>"/>
<input type="hidden" name="flag" value="1"/>
<input type="submit" class="btn btn-primary" value="查询"><br><br>
</form>
<c:if  test="${!empty triptabs}">
<font face="幼圆" size="4">
<table border="1"  class="table table-condensed table-hover"style="background: rgba(230, 230, 250, 0.3);filter: alpha(opacity=30)" id=triptablist>
<tr bgcolor="#87CEFA"><th >申请单单号</th><th>申请类型</th><th>申请时间</th><th>申请单状态</th><th>操作</th><th>状态</th></tr>
<c:forEach items="${triptabs}" var="emp">
<c:if  test="${emp.state!='通过' && emp.travel_state=='待报销'}">
<tr>
<td><a href="triptab/${emp.travel_id}.do?flag=1">${emp.travel_id}</a></td><td>${emp.type}</td><td>${emp.apply_time}</td><td id="state">${emp.state}</td><td><a href="triptab/${emp.travel_id}.do?flag=2">更改</a><td><a href="#" onclick="check(${emp.travel_id})">待报销</a></td>
</tr>
</c:if>
<c:if  test="${emp.state!='通过' && emp.travel_state=='已报销'}">
<tr>
<td><a href="triptab/${emp.travel_id}.do?flag=1">${emp.travel_id}</a></td><td>${emp.type}</td><td>${emp.apply_time}</td><td id="state">${emp.state}</td><td><a href="triptab/${emp.travel_id}.do?flag=2">更改</a></td><td>已报销</td>
</tr>
</c:if>
<c:if  test="${emp.state=='通过' && emp.travel_state=='待报销'}">
<tr>
<td><a href="triptab/${emp.travel_id}.do?flag=1">${emp.travel_id}</a></td><td>${emp.type}</td><td>${emp.apply_time}</td><td id="state">${emp.state}</td><td></td><td><a href="apply_reimburse.jsp?reimburse.travel_id=${emp.travel_id}">待报销</a></td>
</tr>
</c:if>
<c:if  test="${emp.state=='通过' && emp.travel_state=='已报销'}">
<tr>
<td><a href="triptab/${emp.travel_id}.do?flag=1">${emp.travel_id}</a></td><td>${emp.type}</td><td>${emp.apply_time}</td><td id="state">${emp.state}</td><td></td><td>已报销</td>
</tr>
</c:if>
</c:forEach>
</table>
<s:url id="pre_page" value="see2.do">
   <s:param name="pageNow" value="pageNow-3"/>
   <s:param name="triptab.apply_time" value="#session.Apply_time"/>
   <s:param name="triptab.employee_id" value="#session.employee_id"/>
   <s:param name="triptab.state" value="#session.State"/>
   <s:param name="flag"  value="2"/>
</s:url>

<s:url id="next_page" value="see2.do">
<s:param name="pageNow" value="pageNow+3" />
<s:param name="triptab.apply_time"  value="#session.Apply_time"/>
   <s:param name="triptab.employee_id"  value="#session.employee_id"/>
   <s:param name="triptab.state"  value="#session.State"/>
    <s:param name="flag"  value="2"/>
</s:url>
<s:a href="%{pre_page}">上一页</s:a>
<s:a href="%{next_page}">下一页</s:a>

</c:if></font>
 </center><br><br>
	 </div>
</div>
</div>
<script type="text/javascript">
function check(id ){
	var state=document.getElementById("state").value;
	if(state=='通过')
		{
		 window.location.href="apply_reimburse.jsp?reimburse.travel_id=id";
		}
    else
    	{
    	alert("您还不能申请报销！");
    	}
}
</script>
</body>
</html>