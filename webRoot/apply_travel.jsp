<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/My97DatePicker/WdatePicker.js"></script>
<title>员工出差申请</title>
<!-- 透明表单 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styletc.css" media="screen" type="text/css" />
    <script src="<%=request.getContextPath()%>/js/modernizrtc.js"></script>
 
<script> 
function check()
{
    var date = document.getElementById("chucstarttime").value;
    var date2 = document.getElementById("chucendtime").value;
    var result = date.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
    var result2 = date2.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
    if(result==null)
    {
    	$('#chucstarttime').popover('show');
        return false;
    }
    if(result2==null)
    {
    	$('#chucendtime').popover('show');
        return false;
    }
}
$(document).ready(function(){
  $("img").click(function(){
    var div=$("div");  
    div.animate({left:'1210px'},"slow");
   // height:'toggle'
  });
});
</script> 

</head>
<body>
 <div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
       <%@ include file="common_employee.jsp"  %> 
       <br>
<center > 
  <font face="幼圆" size="6">员工出差申请表</font><br><br>
  </center>
   <form action="apply_travel.do"  method="post" onSubmit="javascript: return check()">
 <div><font face="幼圆" size="5">申请日期：</font>
 <input class="Wdate" type="text" id="triptab.apply_time" name="triptab.apply_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
 </div>
 <br>
  <center>
 <font face="幼圆" size="3">
 <table  class="table  table-condensed table-hover"  border="1" class="col-sm-12" style="background: rgba(205, 201, 201, 0.3) !important;filter: alpha(opacity=30)" >
 
 <tr ><td class="col-sm-2">申请人工号</td><td colspan="5" class="col-sm-10">
 <%=request.getSession().getAttribute("employee_id").toString() %>
 </td></tr>
 <tr><td>部门</td><td colspan="5"><%=request.getSession().getAttribute("department_name").toString() %></td></tr>
  <tr ><td class="col-sm-2">出差地点</td><td colspan="5" class="col-sm-10"><input  class="form-control"  required="required" name="triptab.destination" id="triptab.destination"/></td></tr>
  <tr><td >申请类型</td><td colspan="5" class="col-sm-10">
   <select type="select" name="triptab.type" id="triptab.type" style="width:220px;height:30px;" required="required">    
 <option value="紧急">紧急 </option>
  <option value="普通">普通</option>
  </select>  
   </td></tr>
  <tr><td>事由</td><td colspan="5" class="col-sm-10"><input required="required" class="form-control"  name="triptab.reason" /></td></tr>
  <tr><td>出差时间</td><td colspan="2" class="col-sm-5"><input class="Wdate" type="text" id="triptab.start_time" name="triptab.start_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" 
  placeholder="输入格式如1993-01-01" required="required"
  id="chucstarttime" title="error information"  
      data-container="body" data-toggle='popover' data-placement="bottom" 
     data-content="出差时间的日期格式不正确!"/></td>
  <td>至</td><td colspan="2" class="col-sm-5">
  <input class="Wdate" type="text" id="triptab.end_time" name="triptab.end_time"  style="width:220px;height:30px;"
 onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" 
  placeholder="输入格式如1993-01-01" required="required"
  id="chucendtime" title="error information"  
      data-container="body" data-toggle='popover' data-placement="bottom" 
     data-content="出差时间的日期格式不正确!"/></td></tr>
    <tr><td >行程安排</td><td colspan="5" class="col-sm-10"><input class="form-control" required="required" name="triptab.schedule" /></td></tr>  
	<tr><td >备注</td><td colspan="5" class="col-sm-10"><input class="form-control"  name="triptab.remark" /></td></tr>
   </table><br><br>
 <input type="hidden" id="triptab.employee_id" name="triptab.employee_id" value="<%=request.getSession().getAttribute("employee_id").toString()%>"/>
 <input type="hidden" id="triptab.department" name="triptab.department" value="<%=request.getSession().getAttribute("department_name").toString()%>"/>
 <input type="hidden" id="triptab.position" name="triptab.position" value="<%=request.getSession().getAttribute("position").toString()%>"/>
  <input type="hidden" id="triptab.travel_state" name="triptab.travel_state" value="待报销"/>
   <input type="submit"  class="btn btn-primary" value="提交" style="width:220px;height:40px;color:white;">
    </font> </center></form>
     </div>
</div>
</div>
</body>
</html>