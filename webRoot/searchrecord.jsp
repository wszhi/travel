<%@page import="com.lds.action.Finance_record"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lds.entity.Reimburse"%>
<%@page import="com.lds.entity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%
    	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function altRows(id){
		var table=document.getElementById(id);
		var rows = document.getElementsByTagName("tr");
		for(i = 0;i<rows.length;i++){
			if(i%3 == 0){
				rows[i].className="first";
			}else if(i%3 == 1){
				rows[i].className="second";
			}else{
				rows[i].className="third";
			}
		}
	}
	function triptab(obj){
		form1.index.value = obj.parentNode.parentNode.rowIndex;
		form1.action = "searchtriptab.do";
		form1.submit();
	}
	function reimburse(obj){
		form1.index.value = obj.parentNode.parentNode.rowIndex;
		form1.action = "searchreimburse.do";
		form1.submit();
	}
	
	window.onload=function(){
		altRows('table');
	}
	
	function search(){
		location.href="searchfor.do";
	}
</script>
<title>Insert title here</title>
</head>
<%

	if(null != request.getSession().getAttribute("finance_records")){
		ArrayList<Finance_record> finance_records = (ArrayList<Finance_record>)request.getSession().getAttribute("finance_records");
		request.setAttribute("finance_records", finance_records);
	}
	int id = 1;
%>

<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
 <%@ include file="common_finance.jsp"  %>
	<form action="<%=path %>/searchfor.do" method="post" id="form1" name="form1">
	<input type="hidden"  name="index" id="index"> 
	<table>
	<tr><td><font face="幼圆" size="4">员工号：</font></td>
	<td><input type="text" style="width:250px;height:35px;" class="form-control" name="employee_id" >
	</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="幼圆" size="4">审批人工号：</font></td>
	<td><input type="text" style="width:250px;height:35px;" class="form-control" name="manager_id">
	</td></tr>
	<tr><td><font face="幼圆" size="4">申请时间：</font></td>
	<td><input type="text" style="width:250px;height:35px;" class="form-control" name="start_time"  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})">
	</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face="幼圆" size="4">报销时间：</font></td>
	<td><input type="text" style="width:250px;height:35px;" class="form-control"  name="reimburse_time"  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})">
	</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="search" class="btn btn-primary" style="width:180px;height:35px;color:white;" value="查询">
	<input type="hidden" name="jsParam"></td></tr>
	</table><br><br><br>
	<table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)"
	id="table">
	<div>
		<s:div>
			<tr class="first" bgcolor="#FFE7BA">
				<td  style="text-align: center;">序号</td>
				<td style="text-align: center;">申请人工号</td>
				<td style="text-align: center;">申请人姓名</td>
				<td style="text-align: center;">审批人工号</td>
				<td style="text-align: center;">审批人姓名</td>
				<td style="text-align: center;">报销原因</td>
				<td style="text-align: center;">报销总金额</td>
				<td style="text-align: center;">报销时间</td>
				<td style="text-align: center;">申请表查询</td>
				<td style="text-align: center;">报销单查询</td>
			</tr>
		</s:div>
		<s:iterator value="#request.finance_records" var="Finance_record" status="st">
			<s:div >
			<tr class="first">
				<td style="text-align: center;"><%=id %></td>
				<%id = id + 1; %>
				<td  style="text-align: center;"><s:property value="#Finance_record.employee_id"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.employee_name"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.manager_id"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.manager_name"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.reason"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.total_money"/></td>
				<td style="text-align: center;"><s:property value="#Finance_record.reimburse_time"/></td>
				<td style="text-align: center;"><input type="button"  class="btn btn-primary" style="width:120px;height:35px;color:white;" value="查看申请单" onclick="triptab(this)"></td>
				<td style="text-align: center;"><input type="button" class="btn btn-primary" style="width:120px;height:35px;color:white;" value="查看报销单" onclick="reimburse(this)"></td>
			</tr>
			</s:div>
		</s:iterator>
	</div>
	</table>
	</form></div></div></div>
</body>
</html>