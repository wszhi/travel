<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"
    %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
<%@ include file="common_manager.jsp"  %>

<div id="quform">
<center><font face="幼圆" size="6"><caption>已经审批出差申请列表</caption></font></center>
<font face="幼圆" size="4">
<table border="1" class="table table-bordered table-condensed table-hover" style="background: rgba(255 ,239, 213, 0.6) !important;filter: alpha(opacity=30)">
        <tr bgcolor="#caf787">
         <th>序号</th>
         <th>申请时间</th>
         <th>工号</th>
         <th>职位</th>
         <th>目的地</th>
         <th>出差事由</th>
         <th>日程安排</th>
         <th>备注</th>
         <th>审批工号</th>
         <th>审批意见</th>
         <th>理由</th>
        </tr>
     <c:if test="${!empty triptabs}">
    <c:forEach items="${triptabs}" var="emp">
    <tr>
            <td>${emp.travel_id} </td>
            <td>${emp.apply_time}</td>
            <td>${emp.employee_id}</td>
            <td>${emp.position}</td>
            <td>${emp.destination}</td>
            <td>${emp.reason}</td>
            <td>${emp.schedule}</td>
            <td>${emp.remark}</td>
            <td>${emp.manager_id}</td>
            <td>${emp.state}</td>
            <td>${emp.man_rea}</td>
          
    </tr>
</c:forEach></c:if>
</table>
</div></div></div></div>
</body>
</html>

