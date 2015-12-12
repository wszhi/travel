<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script src='js/jquery.js'></script>
  <script src="js/index.js"></script> 
<script> 

function back() {
	history.back();
}
</script> 
</head>
<body style="background-image: url(<%=request.getContextPath()%>/img/loginbg.jpg);background-size:cover">
 
    <div class='container'>
      <div class="col-xs-12" > 
<%@ include file="common.jsp"  %>
 
<br><br>
<br>
<div style="text-align:center;clear:both">
</div>
  <div class='containerr'>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylestep.css"  type="text/css" />
 <h1>差旅流程</h1>
  <span onclick="back()" class='close' ></span>
  <div class='slider-containerr'>
    <div class='slider-turn'>
      <p>填写出差申请，提交<br>
      <a href='apply_travel.jsp' target='_blank' title='出差申请'>去填写</a></p>
      <p>查看出差申请，审核通过<br>
      <a href='see_apply_travel.jsp' target='_blank' title='查看出差申请'>查看</a></p>
      <p>出差</p>
      <p>填写报销申请，提交<br>
      <a href='apply_reimburse.jsp' target='_blank' title='报销申请'>去填写</a></p>
      <p>查看报销申请<br>
      <a href='see_apply_reimburse.jsp' target='_blank' title='查看出差申请'>查看</a></p>
      <p>提示时上交材料</p>
      <p>查看审核通过</p>
      <p>报销的钱下发，结束 !</p>
    </div>
  </div>
  <div class='bottom'>
    <div class='step'>
      <span></span>
      <ul>
        <li data-num='1'></li>
        <li data-num='2'></li>
        <li data-num='3'></li>
        <li data-num='4'></li>
        <li data-num='5'></li>
        <li data-num='6'></li>
        <li data-num='7'></li>
        <li data-num='8'></li>
      </ul>
    </div>
    <button class='btn'>Next</button>
  </div>



</div>
</div>
</div>
</body>
</html>