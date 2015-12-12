    <%@ page language="java" contentType="text/html; charset=utf-8"    
            pageEncoding="utf-8"%>    
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"></style>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>填写报销申请</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>
 </head>
 <body>
 <div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
       <%@ include file="common_employee.jsp"  %> 
       <br>
     <center>
      <label align="center">
  <font face="幼圆" size="6">员工差旅费报销单</font>
 </label></center>
 <form action="insert.do" enctype="multipart/form-data">
  <div > <font face="幼圆" size="5">申请日期：</font>
<input class="Wdate" type="text" id="reimburse.reimburse_time" name="reimburse.reimburse_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
 </div>
<br>
<center>

  <table border="1" class="table table-condensed" style="background: rgba(255 ,192 ,203, 0.3) !important;filter: alpha(opacity=30)"  id="other_expenseList">
  <tr><td>单位</td><td>XX公司</td>
  <td>部门</td><td>
   <%=request.getSession().getAttribute("department_name").toString() %> 
  </td></tr>
  <tr>
  <td class="col-sm-2">出差人姓名</td><td class="col-sm-4"><%=request.getSession().getAttribute("name").toString() %></td>
  <td class="col-sm-2">预计款</td><td class="col-sm-4"><input type="text" required="required" name="reimburse.total_money" id="reimburse.total_money" class="form-control"></td></tr>
  <tr><td >申请类型：</td><td colspan="3">
   <select colspan="3" type="select" required="required" name="reimburse.reimburse_type" id="reimburse.reimburse_type" style="width:220px;height:30px;">    
 <option value="紧急">紧急 </option>
  <option value="普通">普通</option>
  </select> 
  </td></tr>
  <tr><td>备注</td><td colspan="3"><input colspan="3" type="text" id="reimburse。reimburse_remark" name="reimburse.reimburse_remark" class="form-control"></td>
   </tr>
  </table>
  <table border="1"  class="table table-condensed"style="background: rgba(230 ,230 ,250, 0.3) !important;filter: alpha(opacity=30)">
  <font face="幼圆" size="5"><tr>其他费用</tr>
  <tr><td>其他费用总额</td><td colspan="2"><input type="text" name="reimburse.other_totalmoney" class="form-control"></td></tr>
  <tr><td class="col-sm-4">项目</td><td class="col-sm-4">金额</td><td class="col-sm-4">票据张数</td></tr>
  <tr>
  <td style="padding:5px;"><input type="text" name="other_expenses[0].other_expense_name" class="form-control"></td>
   <td style="padding:5px;"><input type="text" name="other_expenses[0].other_expense_money" class="form-control"></td>
   <td style="padding:5px;"><input type="text" name="other_expenses[0].ticket_num" class="form-control" ></td>
  </tr>
  <tr>
   <td style="padding:5px;"><input type="text" name="other_expenses[1].other_expense_name" class="form-control"></td>
   <td style="padding:5px;"><input type="text"  name="other_expenses[1].other_expense_money" class="form-control"></td>
   <td style="padding:5px;"><input type="text" name="other_expenses[1].ticket_num" class="form-control" ></td>
  </tr>
  </table>
  <table border="1" class="table table-condensed" style="background: rgba(188 ,238, 104, 0.3);filter: alpha(opacity=30)" id="transList">
  <font face="幼圆" size="5"><tr>交通票价</tr>
  <tr><td>交通费用总额</td><td colspan="4"><input type="text" name="reimburse.trans_totalmoney" class="form-control"></td></tr>
  
  <tr><td colspan="2">起程</td><td colspan="2">到达</td><td rowspan="2">金额</td></tr>
   <tr><td>时间</td><td>地名</td><td>时间</td><td>地名</td></tr>
   <tr>
   <td style="padding:5px;"><input class="Wdate" type="text" id="transs[0].trans_start_time" name="transs[0].trans_start_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></td>
   <td style="padding:5px;"><input type="text" name="transs[0].trans_start_address" class="form-control"></td>
   <td style="padding:5px;"><input class="Wdate" type="text" id="transs[0].trans_end_time" name="transs[0].trans_end_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" /></td>
   <td style="padding:5px;"><input type="text"  name="transs[0].trans_end_address" class="form-control"></td>
   <td style="padding:5px;"><input type="text" name="transs[0].trans_money" class="form-control"></td>
   </tr>
   <tr>
   <td style="padding:5px;"><input class="Wdate" type="text" id="transs[1].trans_start_time" name="transs[1].trans_start_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
</td>
   <td style="padding:5px;"><input type="text" name="transs[1].trans_start_address" class="form-control"></td>
   <td style="padding:5px;"><input class="Wdate" type="text" id="transs[1].trans_end_time" name="transs[1].trans_end_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
   </td>
   <td style="padding:5px;"><input type="text"  name="transs[1].trans_end_address" class="form-control"></td>
   <td style="padding:5px;"><input type="text" name="transs[1].trans_money" class="form-control"></td>
   </tr> 
   </table><br><br>
    <input type="hidden" id="reimburse.employee_id" name="reimburse.employee_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>"/>
    <input type="hidden" id="reimburse.department" name="reimburse.department" value="<%=request.getSession().getAttribute("department_name").toString()%>"/>
    <input type="hidden" id="reimburse.travel_id" name="reimburse.travel_id" value="<%=request.getParameter("reimburse.travel_id")%>"/>
   <input type="submit"  value="提交" class="btn btn-primary" style="width:220px;height:40px;color:white;">
     </center>  
     </form>
	 <br><br>
	 </div>
</div>
</div>
</body>
</html>