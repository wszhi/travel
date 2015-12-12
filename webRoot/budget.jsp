<%@page import="com.lds.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.lds.entity.Budget"%>
<%
   	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
 <%@ include file="common_finance.jsp"  %>
 <br>
<%	
	if(null != request.getSession().getAttribute("IsEmpty")){
%>
	<script type="text/javascript">
		alert("更新失败");
	</script>
<%

	request.getSession().setAttribute("IsEmpty", null);
	}
	String submit = "提交";
	String update = "更新";
	String empty = "";
	Budget budget = null;
	if(null != request.getSession().getAttribute("budget")){
		budget =(Budget)request.getSession().getAttribute("budget");
	}
	Employee employee =(Employee)request.getSession().getAttribute("employee");
%>
<form action="<%=path %>/dealBudget.do" method="post">
	<table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
		<tr>
			<td>申请人：</td>
			<td><%=employee.getName() %></td>
		</tr>
		<tr>
			<td>员工号：</td>
			<td><%=employee.getEmployee_id() %></td>
		</tr>
		<tr>
			<td>预算详情：</td>
			<td><textarea name="detail" cols="30" rows="10"><%=null==budget?empty:budget.getTravel_detail()%></textarea></td>
		</tr>
		<tr>
			<td>总金额：</td>
			<td><input type="text" name="budget_money" value="<%=null==budget?empty:budget.getBudget_money()%>"></td>
		</tr>
		<tr>
			<td>财务人员工号：</td>
			<td><input type="text" name="finance_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>" readonly="true"></td>
		</tr>
	</table>
	<input type="submit" name = "submit" value="<%=null==budget?submit:update%>" class="btn btn-primary">
</form></div></div></div>
</body>
</html>