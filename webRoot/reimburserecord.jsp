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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/record.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function div(obj) {
		form1.jsParam.value = obj.rowIndex;
		form1.submit();
	}
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
	
	function back(){
		history.back();
	}
	
	window.onload=function(){
		altRows('table');
	}
</script>
<title>Insert title here</title>
</head>
<%
	if(null != request.getSession().getAttribute("reimburses")){
		ArrayList<Reimburse> reimburses =(ArrayList<Reimburse>)request.getSession().getAttribute("reimburses");
		ArrayList<Employee> employees = (ArrayList<Employee>)request.getSession().getAttribute("employees");
		request.setAttribute("reimburses", reimburses);
		request.setAttribute("employees", employees);
	}
	int id = 1;
%>

<body>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
 <%@ include file="common_finance.jsp"  %>
	<form action="<%=path %>/reimbursedetail.do" method="post" id="form1" name="form1">
	<input type="hidden" name="jsParam">
	<table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)"
	id="table">
	<div>
		<s:div>
			<tr style="height:50px" class="first">
				<td  style="font-size: 25px;text-align: center;">序号</td>
				<td style="font-size: 25px;text-align: center;">申请人</td>
				<td style="font-size: 25px;text-align: center;">申请类型</td>
				<td style="font-size: 25px;text-align: center;">申请时间</td>
				<td style="font-size: 25px;text-align: center;">总金额</td>
			</tr>
		</s:div>
		<s:iterator value="#request.reimburses" var="Reimburse" status="st">
			<s:div style="background:#ff0000;margin:10px">
			<tr  onclick="div(this)" style="height:50px;cursor:pointer" class="first">
				<td style="font-size: 25px;text-align: center;"><%=id %></td>
				<%id = id + 1; %>
				<td  style="font-size: 25px;text-align: center;"><s:property value="#request.employees[#st.index].name"/></td>
				<td style="font-size: 25px;text-align: center;"><s:property value="#Reimburse.reimburse_state"/></td>
				<td style="font-size: 25px;text-align: center;"><s:property value="#Reimburse.reimburse_time"/></td>
				<td style="font-size: 25px;text-align: center;"><s:property value="#Reimburse.total_money"/></td>
			</tr>
			</s:div>
		</s:iterator>
	</div>
	</table>
	</form></div></div></div>
</body>
</html>