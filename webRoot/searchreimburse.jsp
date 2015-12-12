    <%@page import="com.lds.entity.Department"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.lds.entity.Employee"%>
<%@page import="com.lds.entity.Other_expense"%>
<%@ page language="java" contentType="text/html; charset=utf-8"    
            pageEncoding="utf-8"%>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
 <%@page import="com.lds.entity.Trans"%>
  <%@page import="com.lds.entity.Reimburse"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"></style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function Isconfirm(){
		var IS = confirm("确认完成报销？");
		if(IS== true){
			form1.submit();
		}
	}
	function back() {
		history.back();
	}
</script>
<title>查看报销申请</title>
 </head>
 <body>
 <div class="container" >
   <div class="row" >
      <div class="col-xs-12" > 
 <%@ include file="common_finance.jsp"  %>
 <%
	ArrayList<Trans> trans =(ArrayList<Trans>)request.getSession().getAttribute("trans");
 	ArrayList<Other_expense> other_expenses = (ArrayList<Other_expense>)request.getSession().getAttribute("other_expenses");
 	Employee employee = (Employee)request.getSession().getAttribute("employee");
 	Reimburse reimburse = (Reimburse)request.getSession().getAttribute("reimburse");
 	Department department = (Department)request.getSession().getAttribute("department");
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
 	String s = sdf.format(reimburse.getReimburse_time());
 	request.setAttribute("trans", trans);
 	request.setAttribute("other_expenses", other_expenses);
 	int id= 1;
 %>
 <a href="searchrecord.jsp" >报销记录表《《</a><a>报销单详情</a>

      <center > 
  <label align="center">
  <font face="幼圆" size="6">员工差旅费报销单</font>
 </label>
  </center>
 <form action="<%=path %>/backreimburse.do" name="form1" enctype="multipart/form-data">
  <div > <font face="幼圆" size="5">申请日期：<%=s%></font>
 </div>
<br>
<center>
  <table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
 <tr><td>单位</td><td>XX公司</td>
  <td>部门</td><td>
   <%=department.getDepartment_name() %> 
  </td></tr>
  <tr>
  <td class="col-sm-2">出差人姓名</td><td class="col-sm-4"><%=employee.getName() %></td>
  <td class="col-sm-2">预计款</td><td class="col-sm-4"><%=reimburse.getTotal_money()%></td></tr>
  <tr><td >申请类型：</td><td colspan="3"><%=reimburse.getReimburse_type() %>
  </td></tr>
  <tr><td>备注</td><td colspan="3"><%=reimburse.getReimburse_remark() %></td>
   </tr>
  </table>
  <table border="1" class="table table-condensed" style="background: rgba(255 ,192 ,203, 0.3) !important;filter: alpha(opacity=30)"  id="other_expenseList">
  <font face="幼圆" size="5"><tr>其他费用</tr>
  <tr><td class="col-sm-3">项目</td><td class="col-sm-3">金额</td><td class="col-sm-3">票据张数</td><td class="col-sm-3">动作</td></tr>
  <s:iterator value="#request.other_expenses" var="Other_expense" status="st">
  <tr onclick="div(this)"  class="first">
  <td style="text-align: center;"><%=id %></td>
  <%id= id + 1; %>
  <td style="padding:5px;"><s:property value="#Other_expense.other_expense_name"/></td>
   <td style="padding:5px;"><s:property value="#Other_expense.other_expense_money"/></td>
   <td style="padding:5px;"><s:property value="#Other_expense.ticket_num"/></td>
  </tr>
  </s:iterator>
  </table>
  
  <table border="1" class="table table-condensed" style="background: rgba(188 ,238, 104, 0.3) !important;filter: alpha(opacity=30)" id="transList">
  
  <font face="幼圆" size="5"><tr>交通票价</tr>
  
  <tr><td colspan="2">起程</td><td colspan="2">到达</td><td rowspan="2">金额</td></tr>
  
   <tr><td>时间</td><td>地名</td><td>时间</td><td>地名</td></tr>
  <s:iterator value="#request.trans" var="Trans" status="st1">
   <tr>
   <td ><s:property value="#Trans.trans_start_time"/></td>
   <td ><s:property value="#Trans.trans_start_address"/></td>
   <td ><s:property value="#Trans.trans_end_time"/></td>
   <td ><s:property value="#Trans.trans_end_address"/></td>
   <td ><s:property value="#Trans.trans_money"/></td>
   <input name='txtTRLastIndex' type='hidden' id='txtTRLastIndex' value="1" />
   </tr>
   </s:iterator>
   </table><br><br>
   <input type="button" value="返回" class="btn btn-primary" style="width:220px;height:40px;color:white;" onclick="back()">
   <input type="hidden" id="reimburse.employee_id" name="reimburse.employee_id" value="<%=3%>"/>
   <input type="hidden" id="reimburse.department" name="reimburse.department" value="<%=4%>"/>
     </center>  
     </form><br><br>
	 </div>
</div>
</div>
</body>
</html>