<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>查看员工出差申请</title>
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
<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
     <%@ include file="common_employee.jsp"  %>

<center > 
  <font face="幼圆" size="6">员工出差申请表</font><br><br>
  </center><form>
  <c:forEach items="${triptabs}" var="emp">
 <div><font face="幼圆" size="5">申请日期：${emp.apply_time}</font>
 </div>
 <br>
  <center>
 <font face="幼圆" size="3">
 <table  class="table table-condensed table-hover"  border="1" class="col-sm-12" style="background: rgba(191 ,239, 255, 0.3);filter: alpha(opacity=30)">
 
 <tr ><td class="col-sm-2">申请人工号</td><td colspan="5" class="col-sm-10">
 <%=request.getSession().getAttribute("employee_id").toString() %>
 </td></tr>
 <tr><td class="col-sm-2">部门</td><td colspan="5" class="col-sm-10">
 <%=request.getSession().getAttribute("department_name").toString() %></td></tr>
  <tr ><td class="col-sm-2">出差地点</td><td colspan="5" class="col-sm-10">${emp.destination}</td></tr>
  <tr><td >申请类型</td><td colspan="5" class="col-sm-10">${emp.type}</td></tr>
  <tr><td>事由</td><td colspan="5" class="col-sm-10">${emp.reason}</td></tr>
  <tr><td>出差时间</td><td colspan="2" class="col-sm-5">${emp.start_time}</td>
  <td>至</td><td colspan="2" class="col-sm-5">${emp.end_time}</td></tr>
    <tr><td >行程安排</td><td colspan="5" class="col-sm-10">${emp.schedule}</td></tr>  
	<tr><td >备注</td><td colspan="5" class="col-sm-10">${emp.remark}</td></tr>
   </c:forEach>
   </table>
   <input type="button" onclick="back()" class="btn btn-primary" value="返回" style="width:220px;height:40px;color:white;">
  </form><br><br>
    </font> </center>
     </div>
</div>
</div>
</body>
</html>