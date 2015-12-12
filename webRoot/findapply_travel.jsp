<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lds.entity.Department"%>
<%@page import="com.lds.entity.Employee"%>
<%@page import="com.lds.entity.Triptab"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>员工出差申请</title>
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
<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
 <%@ include file="common_finance.jsp"  %>
<%
	Employee employee = (Employee)request.getSession().getAttribute("employee");
	Department department = (Department)request.getSession().getAttribute("department");
	Triptab triptab =(Triptab)request.getSession().getAttribute("triptab");
	Date date = triptab.getApply_time();
	Date date1 = triptab.getStart_time();
	Date date2 = triptab.getEnd_time();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String s = sdf.format(date);
	String s1 = sdf.format(date1);
	String s2 =sdf.format(date2);
%>
<center> 
  <font face="幼圆" size="6">员工出差申请表</font><br><br>
</center>
<center>
  <form action="<%=path %>/budget.do"  method="post" >
 <div><font face="幼圆" size="5">申请日期：<%=s%></font></div>
 <br>
 <table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
 	<tr>
 		<td>申请人工号</td><td colspan="5"><%=employee.getEmployee_id()%></td>
 	</tr>
	<tr>
		<td>部门</td>
		<td><%=department.getDepartment_id() %></td>
	</tr>
  	<tr>
  	<td>出差地点</td>
  	<td colspan="5"><%=triptab.getDestination() %></td>
  	</tr>
  	<tr>
  	<td>申请类型</td>
  	<td colspan="5"><%=triptab.getType() %></td>
  	</tr>
  	<tr>
  		<td>事由</td>
  		<td colspan="5"><%=triptab.getReason() %></td>
  	</tr>
 	<tr>
 		<td>出差时间</td>
 		<td colspan="2" ><%=s1 %></td>
 		<td>至</td>
 		<td colspan="2" ><%=s2 %></td>
 	</tr>
	<tr>
		<td>行程安排</td>
		<td colspan="5"><%=triptab.getSchedule() %></td>
	</tr>  	
	<tr>
		<td>备注</td>
		<td colspan="5"><%=triptab.getRemark() %></td>
	</tr>
   </table>
   <input type="button" onclick="back()" value="返回" class="btn btn-primary">
   <input type="submit" value="预算表" class="btn btn-primary">
   <br/>
   <br/>
 	
</form>
</center>
 </div>
</div>
</div>
</body>
</html>