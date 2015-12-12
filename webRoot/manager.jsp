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
<s:form action="manager.do" >
<table>
<tr><td><font face="幼圆" size="5">提交时间</td>
<td><input id="Text1" style="width:250px;height:35px;" class="form-control" name="triptab.apply_time" onClick="calendar.show({ id: this })" type="text" /></td>
<td>&nbsp;&nbsp;&nbsp;<font face="幼圆" size="5">出差时间</td>
<td><input id="Text1" style="width:250px;height:35px;" class="form-control" name="triptab.start_time" onClick="calendar.show({ id: this })" type="text" /></td>
<td>&nbsp;&nbsp;&nbsp;<font face="幼圆" size="5">
<select name ="triptab.type" style="width:250px;height:35px;" >
   <option value="普通">普通</option >
   <option value="紧急" selected = "selected" >紧急</option >
 </select ></font></td>
<td><input type="hidden" style="width:250px;height:35px;" class="form-control" id="triptab.department" name="triptab.department" value="<%=request.getSession().getAttribute("department_name").toString()%>"/>
</td>   
<td>&nbsp;&nbsp;&nbsp;<font face="幼圆" size="5"><s:submit value="查询" class="btn btn-primary" theme="simple"/></font></td>
</tr>
</table>




	<center > <br> <br>
  <font face="幼圆" size="6">未审批出差申请列表</font><br><br>
  <font face="幼圆" size="4">
<table border="1" class="table table-bordered table-condensed table-hover" style="background: rgba(255 ,250, 205, 0.6) !important;filter: alpha(opacity=30)">
	
        <tr bgcolor="#caf787">
         <th>序号</th>
         <th>申请时间</th>
         <th>工号</th>
         <th>职位</th>
         <th>目的地</th>
         <th>出差事由</th>
         <th>日程安排</th>
         <th>备注</th>
         <th>操作</th>
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
            <td><button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" onclick="myclick(${emp.travel_id})">审批</button></td>
    </tr>
</c:forEach></c:if></center>
</table>
</s:form>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"  aria-hidden="true">× </button>
            <h2>审批</h2>
         </div>
          <div class="modal-body">
        <s:form id="spform" name="spform"  action="update1.do">
        <label for="triptab.manager_id">审批工号</label>
        <input type="text" name="triptab.manager_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>" tabindex="3" readonly="true"
     class="txtfield" />
    	<label for="triptab.state">审批意见</label>
    	 <select name="triptab.state" class="txtfield">
     	 <option value="通过">通过</option>
      	<option value="不通过">不通过</option>
      	</select>
     	 <label for="triptab.man_rea">审批理由:</label>
     	 <input type="text" name="triptab.man_rea"  tabindex="2" class="txtfield"/>
            <button type="button" class="btn btn-default" onclick="back()"  data-dismiss="modal">关闭</button>
            <input type="text"  name="triptab.travel_id" id="triptab.travel_id"   style="display:none;" />
            <input type="text"  name="triptab.department"  value="<%=request.getSession().getAttribute("department_name").toString()%>"  style="display:none;" />
            <input type="submit" name="loginbtn" id="loginbtn"  value="提交" tabindex="3"  class="btn btn-primary" />
          </s:form>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal  keyboard: true -->
	
 <script type="text/javascript">
 function youclick(){ $('#myModal').modal({
		keyboard: true   
	   }) 
 };   
function myclick( travel){
document.getElementById("triptab.travel_id").value=travel;//传值，用隐藏input来接收myclick函数传的id值
$('#spform').submit(function(e){
  
});
function click( ){
	history.back()
}
}
</script></div></div></div></div>
</body>
</html>

           

