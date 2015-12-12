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
 <body style="background:url(<%=request.getContextPath()%>/img/bgimg2.jpg);background-size:cover;">
 <div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
       <%@ include file="common_employee.jsp"  %> 
       <br>
 <font face="幼圆" size="5" align="left">查询条件</font> <br>
 <center>
 <form action="see.do" enctype="multipart/form-data">
  <font face="幼圆" size="5">申请时间：</font>
  <input class="Wdate" type="text" name="reimburse.reimburse_time" style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="幼圆" size="5">申请单状态：</font>
  <select id="reimburse.reimburse_state" name="reimburse.reimburse_state" style="width:220px;height:30px;">
  <option value=></option>
<option value="未审核">未审核</option>
<option value="未通过">未通过</option>
<option value="通过">通过</option>
</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" id="reimburse.employee_id" name="reimburse.employee_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>"/>
<input type="hidden" name="flag" value="1"/>
<input type="submit" class="btn btn-primary" value="查询"><br><br>

<c:if  test="${!empty reimburses}">
<table border="1"  class="table table-condensed table-hover"style="background: rgba(224 ,238, 238, 0.3);filter: alpha(opacity=30)" id=triptablist>
<font face="幼圆" size="5"><th>申请单单号</th><th>申请类型</th><th>申请时间</th><th>申请单状态</th><th>操作</th>
<c:forEach items="${reimburses}" var="emp">
<c:if  test="${emp.reimburse_state=='不通过' || emp.reimburse_state=='未审核'}">
<tr><td><a href="reimburse/${emp.reimburse_id}.do?flag=1">${emp.reimburse_id}</a></td><td>${emp.reimburse_type}</td><td>${emp.reimburse_time}</td><td>${emp.reimburse_state}</td><td><a href="reimburse/${emp.reimburse_id}.do?flag=2">更改</a></td>
</c:if>
<c:if  test="${emp.reimburse_state=='通过' || emp.reimburse_state=='已报销'}">
<tr><td><a href="reimburse/${emp.reimburse_id}.do?flag=1">${emp.reimburse_id}</a></td><td>${emp.reimburse_type}</td><td>${emp.reimburse_time}</td><td>${emp.reimburse_state}</td><td></td>
</c:if>
</font>
</c:forEach>
</table>
<s:url id="pre_page" value="see.do">
   <s:param name="pageNow" value="pageNow-5"/>
   <s:param name="reimburse.reimburse_time" value="#session.Reimburse_time"/>
   <s:param name="reimburse.employee_id" value="#session.employee_id"/>
   <s:param name="reimburse.reimburse_state" value="#session.Reimburse_state"/>
   <s:param name="flag"  value="2"/>
</s:url>

<s:url id="next_page" value="see.do">
<s:param name="pageNow" value="pageNow+5" />
<s:param name="reimburse.reimburse_time"  value="#session.Reimburse_time"/>
   <s:param name="reimburse.employee_id"  value="#session.employee_id"/>
   <s:param name="reimburse.reimburse_state"  value="#session.Reimburse_state"/>
    <s:param name="flag"  value="2"/>
</s:url>
<s:a href="%{pre_page}">上一页</s:a>
<s:a href="%{next_page}">下一页</s:a>

</c:if></form>
 </center>
 </div></div></div>
 </body>
</html>