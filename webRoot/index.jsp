<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
<!-- 字体反转 -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css"  type="text/css" />
<!-- 可选的Bootstrap主题文件 -->
<script src="<%=request.getContextPath() %>/css/bootstrap-theme.min.css"></script>
<!-- jQuery文件,在bootstrap.min.js 之前引入 -->
<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<!-- 字体变换 -->
<script src="<%=request.getContextPath() %>/css/style.css"></script>
<script src="<%=request.getContextPath() %>/js/prefixfree.min.js"></script>
<script src="<%=request.getContextPath() %>/js/modernizr.js"></script>


</head>
<body >
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
      <table><tr><td class="col-sm-12">
	<img src="<%=request.getContextPath() %>/img/name.png"  width="400" height="90" >
	<img src="<%=request.getContextPath() %>/img/titlei.png"  >

 </td><td align="right" class="col-sm-6">
<span style="display:inline-block;">
<a href="<%=request.getContextPath() %>/login.jsp"><button  class="btn btn-primary" style="width:100px;height:30px;background:#FF7F00;color:white;">用户登录</button></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#"><button  class="btn btn-primary" style="width:100px;height:30px;background:#FF7F00;color:white;">加入收藏</button></a>
<br>
<img src="<%=request.getContextPath() %>/img/titlei2.png"  >

</span></td></tr>
</table>
<br>

<br>
</div></div></div>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="background:#EEffff;
    border-color: #0000CD #0000CD transparent;">  
<font face="黑体" size="4" color="black">
<ul class="nav nav-pills nav-justified"  >
         <li><a href="<%=request.getContextPath() %>/iindex.jsp">首页</a></li>
         <li ><a href="#">公司简介</a></li>
         <li ><a href="#">公司概况</a></li>
         <li ><a href="#">项目案例</a></li>
         <li ><a href="#">消息通知</a></li>	
   		<li ><a href="#">联系我们</a></li>
      </ul>
    </font>  
   
</nav> 
	
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
         <img src="<%=request.getContextPath() %>/img/roll11.png"  alt="First slide" style="width:100%">
      </div>
      <div class="item" >
         <img src="<%=request.getContextPath() %>/img/roll22.png" alt="Second slide" style="width:100%">
      </div>
      <div class="item" >
         <img src="<%=request.getContextPath() %>/img/roll33.png" alt="Third slide" style="width:100%">
      </div>
   </div>
   <!-- 轮播（Carousel）导航 -->
       <a data-slide="prev" href="#myCarousel" class="left carousel-control">‹</a>
    <a data-slide="next" href="#myCarousel" class="right carousel-control">›</a>
</div> 
<br><br>
<form>
<div class="container" >
   <div class="row" >
      <div class="col-xs-12" >
<table>
<tr>
<td>
<img src="img/index1.png" width="230" height="290"  ></td><td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="img/index2.png" width="230" height="290" ></td><td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="img/index3.png" width="230" height="290"  ></td><td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="img/index4.png" width="230" height="290" >
</tr></table>
<br><br>
<table>
<tr>
<td class="col-sm-6" colspan="3">
<span><hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<font face="黑体" size="4" color="#FFA500">公司活动| ACTIVITIES</font>
<hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<br>
<a href="#">您集赞，优行送礼，0元机票随机抽</a><br>
<a href="#">公司商旅史上最简单粗暴的送礼活动就要开始了。惊喜一：动动手指...</a>
<a  href="#">【了解详情】</a><br>
<a href="#"><img src="<%=request.getContextPath() %>/img/active.jpg" width="500" height="200"/></a>
</span>
</td><td class="col-sm-6" colspan="3">
<span><hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<font face="黑体" size="4" color="#FFA500">最新资讯| NEWS</font>
<hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<br>
<ul >
<li><a href="#">【差旅趋势】中小企业成差旅市场后起之秀</a><span class="float_r">2015-07-30</span></li>
	<li><a href="#">【商旅服务】航班乘客还愿意为哪些额外服务掏钱？</a><span class="float_r">2015-07-27</span></li>
	<li><a href="#">【航空前沿】多因素引领中国航企进入发展黄金期</a><span class="float_r">2015-07-24</span></li>
	<li><a href="#">【航空服务】高端公务航空服务落地中国啦！</a><span class="float_r">2015-07-22</span></li>
	<li><a href="#">【商旅生活】想倒时差睡好觉怎么破？</a><span class="float_r">2015-07-20</span></li>
</ul>
</span>
<br><br><br><br><br><br><br>
</td>
</tr><tr>
<td colspan="6">
<span><hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<font face="黑体" size="4" color="#FFA500">合作流程| PROCESS</font>
<hr style="height:5px;border:none;border-top:5px ridge #00BFFF;" />
<br>
<a href="#"><img src="<%=request.getContextPath() %>/img/index6.png" /></a>
</span>
</td>
</tr>
<tr bgcolor="#DCDCDC">
<td  class="col-sm-2" ><font face="黑体" size="4" color="black">联系我们</font>
<br>
<ul >
    <li><a href="#">400-666-3232</a></li>
	<li><a href="#">深圳总公司</a></li>
	<li><a href="#">上海分公司</a></li>
	<li><a href="#">北京分公司</a></li>
	<li><a href="#">海南分公司</a></li>
	<li><a href="#">杭州分公司</a></li>
	<li><a href="#">昆明公司</a></li>
</ul>
</td ><td class="col-sm-2"></td>
<td class="col-sm-2" ><font face="黑体" size="4" color="black">按访问者</font>
<br>
<ul >
    <li><a href="#">IT专家</a></li>
    <li><a href="#">差旅经理</a></li>
    <li><a href="#">财务专家</a></li>
    <li><a href="#">商务旅行者</a></li>
</ul>
</td><td class="col-sm-2"></td>
<td class="col-sm-2" >
<p ><font face="黑体" size="4" color="black">友情链接</font></p>
<ul >
	<li><a href="#">12306官网</a></li>
	<li><a href="#">志勋网络</a></li>
	<li><a href="#" >更多</a></li>
</ul>
</td><td class="col-sm-2"></td>
</tr>
</table>
</div></div></div>
</form>
</body>
</html>