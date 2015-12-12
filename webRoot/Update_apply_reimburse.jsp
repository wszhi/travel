<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>更改报销申请</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>

 </head>
 <body>
 <div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
     <%@ include file="common_employee.jsp"  %>
 <center>
 <font face="幼圆" size="6">员工差旅费报销单</font>
 <form action="../update.do" enctype="multipart/form-data">
    <c:forEach items="${reimburses}" var="emp">
  <div> <font face="幼圆" size="5">申请日期：${emp.reimburse_time}</font>
 </div>
  <table border="1" class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
  <tr><td>单位</td><td>XX公司</td><td>部门</td><td><%=request.getSession().getAttribute("department_name").toString() %></td>
  </tr>
  <tr><td>出差人姓名</td><td><%=request.getSession().getAttribute("name").toString() %></td>
  <td>预计款</td><td><input type="text" required="required" id="reimburse.total_money" name="reimburse.total_money" value="${emp.total_money}" class="form-control"></td></tr>
   <tr><td>申请类型：</td><td><select required="required" type="select" name="reimburse.reimburse_type" id="reimburse.reimburse_type">    
 <option value="紧急">紧急 </option>
  <option value="普通">普通</option>
  </select></td><td>备注</td> <td ><input type="text" id="reimburse.reimburse_remark" name="reimburse.reimburse_remark" value="${emp.reimburse_remark}" class="form-control"></td>
  </tr> 
     <input type="hidden" id="reimburse.reimburse_id" name="reimburse.reimburse_id" value="${emp.reimburse_id}"/>
     
 </table>
  <table   border="1" class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
  <tr>交通票价</tr>
  <tr><td>交通费用总额</td><td colspan="4"><input type="text" name="reimburse.trans_totalmoney" value="${emp.trans_totalmoney}" class="form-control"></td></tr>
  
  <tr><td colspan="2">起程</td><td colspan="2">到达</td><td >金额</td></tr>
   <tr><td>时间</td><td>地名</td><td>时间</td><td>地名</td></tr>
   <%
   int i=0;
   %>
    <c:forEach items="${transs}" var="emp2">
   <tr>
   <td ><input class="Wdate" type="text"  name="transs[<%=i%>].trans_start_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"  value="${emp2.trans_start_time}"/></td>
   <td ><input type="text" name="transs[<%=i%>].trans_start_address" value="${emp2.trans_start_address}" class="form-control"></td>
   <td ><input class="Wdate" type="text"  name="transs[<%=i%>].trans_end_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"  value="${emp2.trans_end_time}"/>
   <td ><input type="text" name="transs[<%=i%>].trans_end_address" value="${emp2.trans_end_address}" class="form-control"></td>
   <td ><input type="text"  name="transs[<%=i%>].trans_money" value="${emp2.trans_money}" class="form-control"></td>
  </tr>  
  <%
  i++;
  %> 
  </c:forEach>
  </table>
  <table  border="1" class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
 <tr>其他费用</tr>
 <tr><td>其他费用总额</td><td colspan="2"><input type="text" name="reimburse.other_totalmoney" value="${emp.other_totalmoney}" class="form-control"></td></tr>
  
<tr> <td >项目</td><td >金额</td><td >票据张数</td></tr>
<%
   int j=0;
   %>
<c:forEach items="${other_expenses}" var="emp3">
 <tr><td ><input type="text" name="other_expenses[<%=j%>].other_expense_name" value="${emp3.other_expense_name}" class="form-control"></td>
   <td ><input type="text"  name="other_expenses[<%=j%>].other_expense_money" value="${emp3.other_expense_money}" class="form-control"></td>
   <td ><input type="text"  name="other_expenses[<%=j%>].ticket_num" value="${emp3.ticket_num}" class="form-control"></td>
  </tr>
  <%
  j++;
  %>
 </c:forEach>
   </c:forEach> 
   </table>
   <center>
   <input type="hidden" name="flag" value="1"/>
  <input type="submit" class="btn btn-primary" value="提交" style="width:220px;height:40px;color:white;">
    </center>
     </form> 
 </body>
</html>