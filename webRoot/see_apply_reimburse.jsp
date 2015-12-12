<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"
    %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>查看报销申请</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>
<script> 

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
  <label align="center">
  <font face="幼圆" size="6">员工差旅费报销单</font>
 </label>
  </center> <form>
 <center>
    <c:forEach items="${reimburses}" var="emp">
  <div align="left"> <font face="幼圆" size="5">申请日期：${emp.reimburse_time}</font></div>
  <font face="幼圆" size="4">
  <table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
  <tr><td class="col-sm-2">单位</td><td class="col-sm-4">XX公司</td>
  <td class="col-sm-2">部门</td><td class="col-sm-4"><%//=request.getSession().getAttribute("department_name").toString() %></td></tr>
   <tr><td>出差人姓名</td><td><%//=request.getSession().getAttribute("name").toString() %></td>
  <td>预计款</td><td>${emp.total_money}</td></tr>
   <tr><td >申请类型：</td><td >${emp.reimburse_type}</td><td>备注</td><td>${emp.reimburse_remark}</td></tr>
    </table></font>
 <font face="幼圆" size="4"><table border="1"  class="table table-condensed"style="background: rgba(135,206 ,250, 0.3) !important;filter: alpha(opacity=30)">
  <font face="幼圆" size="5"> <tr>交通票价</tr></font>
   <tr><td>交通费用总额</td><td colspan="4">${emp.trans_totalmoney}</td></tr>
  
   <tr><td colspan="2">起程</td><td colspan="2">到达</td><td rowspan="2">金额</td></tr>
   <tr><td>时间</td><td>地名</td><td>时间</td><td>地名</td></tr>
      <c:forEach items="${transs}" var="emp2">
   <tr><td>${emp2.trans_start_time}</td><td>${emp2.trans_start_address}</td><td>${emp2.trans_end_time}</td><td>${emp2.trans_end_address}</td><td>${emp2.trans_money}</td>
   </tr> 
   </c:forEach> 
   </table>
   <font face="幼圆" size="4"><table border="1"  class="table table-condensed"style="background: rgba(244, 164 ,96, 0.3) !important;filter: alpha(opacity=30)">
   <font face="幼圆" size="5"><tr>其他费用</tr>
   <tr><td>交通费用总额</td><td colspan="2">${emp.other_totalmoney}</td></tr>
  
    <tr><td >项目</td><td >金额</td><td >票据张数</td></tr>
      <c:forEach items="${other_expenses}" var="emp3">
   <tr><td>${emp3.other_expense_name}</td><td>${emp3.other_expense_money}</td><td>${emp3.ticket_num}</td></tr>
    </c:forEach>
        </c:forEach>
   </table> 
   </center>
   <center>
    <input type="button" onclick="back()" class="btn btn-primary" value="返回" style="width:220px;height:40px;color:white;">
    </center>
  </form>
      </div></div>
     </div>
 </body>
</html>