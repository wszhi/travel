<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
            <%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>员工修改个人信息</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>

<script> 
function check()
{
    var date = document.getElementById("birth").value;
    var result = date.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
    if(result==null)
    {
    	$('#birth').popover('show');
        return false;
    }
    var tel = document.getElementById("tel").value;
    var  re = tel.match(/^1[35]\d{9}$/);
    if (re == null) {
    	$('#tel').popover('show');
    	return false; 
    }
}
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
  <font face="幼圆" size="6">员工修改个人信息</font><br><br>
  </center>
   <form action="../updateinfor.do"  method="post" onSubmit="javascript: return check()">
 <br>
  <center>
 <font face="幼圆" size="3">
 <table  class="table table-bordered table-condensed table-hover"  border="0" class="col-sm-12" style="background: rgba(135 ,206 ,255, 0.3) !important;filter: alpha(opacity=30)">
<tr ><td align="right" class="col-sm-2">员工名：</td><td class="col-sm-4" id=""><input required="required" class="form-control" type="text" name="employee.name" value="${employee.name}"/></td>
<td align="right" >性别：</td><td  class="col-sm-10" id="employee.sex">${employee.sex}</td></tr>
  <tr ><td align="right"  class="col-sm-2" >出生年月：</td><td  class="col-sm-4"><input required="required" class="form-control" type="text" id="birth" name="employee.birth"  value="${employee.birth}"
  title="error information"  
      data-container="body" data-toggle='popover' data-placement="bottom" 
     data-content="出生年月的日期格式不正确!"/></td>
  <td align="right" class="col-sm-2" >电话：</td><td  class="col-sm-4"><input required="required" class="form-control" id="tel" type="text" name="employee.tel"  value="${employee.tel}"
  title="error information"  
      data-container="body" data-toggle='popover' data-placement="bottom" 
     data-content="电话输入错误!"/></td></tr>
  <tr ><td align="right" class="col-sm-2">地址：</td><td class="col-sm-4"><input class="form-control" type="text" name="employee.address"  value="${employee.address}"/></td>
  <td align="right" class="col-sm-2">Email：</td><td  class="col-sm-4"><input class="form-control" type="email" name="employee.email"  value="${employee.email}"/></td></tr>
  <tr ><td align="right" class="col-sm-2">证件号：</td><td id="employee.Identity_num">${employee.identity_num}</td>
  <td align="right" class="col-sm-2">入职时间：</td><td id="employee.entry_time">${employee.entry_time}</td></tr>
   <tr ><td align="right" class="col-sm-2">部门：</td><td ><%=request.getSession().getAttribute("department_name").toString()%></td>
  <td align="right" class="col-sm-2">职位：</td><td id="employee.position">${employee.position}</td></tr>
 <tr ><td align="right" class="col-sm-2">月薪：</td><td colspan="8"id="employee.salary">${employee.salary}</td></tr>
  </table><br><br>
  <input type="hidden" id="employee.employee_id" name="employee.employee_id" value="${employee.employee_id}"/>
  <input type="hidden" name="flag" value="1"/>
   <input type="submit"  class="btn btn-primary"  value="提交" style="width:220px;height:40px;color:white;" >
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onclick="back()" class="btn btn-primary" value="返回" style="width:220px;height:40px;color:white;">
  
    </font> </center></form>
     </div>
</div>
</div>
</body>
</html>