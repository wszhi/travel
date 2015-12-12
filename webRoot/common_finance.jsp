<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body style="background-color:#F0FFF0">
<div>
<%@ include file="common.jsp"  %> 
<a href="<%=request.getContextPath() %>/login.jsp"><span class="letter" data-letter="退出财务部端" >退出财务部端</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font face="楷体" size=5 color="#A0522D">欢迎！<%=request.getSession().getAttribute("name").toString() %></font>
</div>
<br><hr>
<br>

<nav class="navbar  nav-pills"  role="navigation" style="background:#C1FFC1;
    border-color: #4876FF #4876FF transparent;">  
<div>
     <font face="幼圆" size="4"> <ul class="nav nav-pills nav-justified"  >
          <li> <a href="<%=request.getContextPath() %>/login.do">员工出差申请表</a></li>
             <li> <a href="<%=request.getContextPath() %>/reimburse.do">报销申请表</a></li>
            <li> <a href="<%=request.getContextPath() %>/finance.do">生成报表</a></li>
			<li><a href="<%=request.getContextPath() %>/search.do">查询记录</a></li>
   			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" >个人信息<span class="caret"></span></a>
      			<ul class="dropdown-menu">
      			<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=1">查看个人信息</a></li>
				<li class="divider"></li>
				<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=2">修改个人信息</a></li>
      			
      			</ul>
   			</li>
   			<li ><a href="<%=request.getContextPath() %>/update_pw.jsp">修改密码</a></li>
      </ul></font>
   </div>
</nav> 

</body>
</html>