<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body style="background:url(<%=request.getContextPath()%>/img/bgimg2.jpg) no-repeat;background-size:cover;">
<div>
<%@ include file="common.jsp"  %>
<a href="<%=request.getContextPath() %>/login.jsp"><span class="letter" data-letter="退出普通员工端" >退出普通员工端</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath() %>/indexstep.jsp"><span class="letter" data-letter="差旅步骤演示" >差旅步骤演示</span></a>
<br><marquee direction=left>
<font face="楷体" size=5 color="#A0522D">欢迎！<%=request.getSession().getAttribute("name").toString()%> 请及时在网上进行申请！</font></marquee>
</div>
<br>
<script>
$('.carousel').carousel({
   interval: 2000
    pause:"hover"
  })
</script>
<div id="myCarousel" class="carousel slide">
   <!-- 轮播（Carousel）指标 -->
   <ol class="carousel-indicators " interval="data-interval:1000">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
   </ol>  
   <!-- 轮播（Carousel）项目 -->
   <div class="carousel-inner" >
      <div class="item active" >
         <img src="<%=request.getContextPath() %>/img/roll1.jpg"  alt="First slide" style="width:100%">
      </div>
      <div class="item" >
         <img src="<%=request.getContextPath() %>/img/roll2.jpg" alt="Second slide" style="width:100%">
      </div>
      <div class="item" >
         <img src="<%=request.getContextPath() %>/img/roll3.jpg" alt="Third slide" style="width:100%">
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
       <a data-slide="prev" href="#myCarousel" class="left carousel-control">‹</a>
    <a data-slide="next" href="#myCarousel" class="right carousel-control">›</a>
    
</div> 

<nav class="navbar  nav-pills"  role="navigation" style="background:#EEC591;
    border-color: #4876FF #4876FF transparent;">  
<div> <font face="幼圆" size="4">
      <ul class="nav nav-pills nav-justified"  >
              <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" >出差申请<span class="caret"></span></a>
      			<ul class="dropdown-menu">
         			<li ><a href="<%=request.getContextPath() %>/apply_travel.jsp">申请出差</a></li>
         			<li class="divider"></li>
         			<li><a href="<%=request.getContextPath() %>/Triptable_list.jsp">查看出差申请</a></li>
      			</ul>
   			</li>
              <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" >报销申请<span class="caret"></span></a>
      			<ul class="dropdown-menu">
         			<li><a href="<%=request.getContextPath() %>/table_list.jsp">查看报销申请</a></li>
      			</ul>
   			</li>
   			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" >个人信息<span class="caret"></span></a>
      			<ul class="dropdown-menu">
      			<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=1">查看个人信息</a></li>
				<li class="divider"></li>
				<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=2">修改个人信息</a></li>
      			
      			</ul>
   			</li>
               <li ><a href="<%=request.getContextPath() %>/update_pw.jsp">修改密码</a></li>
      </ul>
   </font></div>
</nav> 

</body>
</html>