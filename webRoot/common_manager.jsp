<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/hDate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/table.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/monitor.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/object.js"></script>


<link href="<%=request.getContextPath()%>/css/hDate.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/spstyle.css" rel="stylesheet" type="text/css" media="all" /> 
<link rel="shortcut icon" href="http://designshack.net/favicon.ico"/>
<link rel="icon" href="http://designshack.net/favicon.ico"/>
<link href="<%=request.getContextPath()%>/css/hDate.css" rel="stylesheet" />
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>


<link href="<%=request.getContextPath()%>/css/spstyle.css" rel="stylesheet" type="text/css" media="all" /> 
</head>
<body style="background-color:#E6E6FA">
<div>
<%@ include file="common.jsp"  %>
<a href="<%=request.getContextPath() %>/login.jsp"><span class="letter" data-letter="退出审批领导端" >退出审批领导端</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<font face="楷体" size=5 color="#A0522D">欢迎！<%=request.getSession().getAttribute("name").toString() %></font>
</div>
<br><hr>
<br>
<nav class="navbar  nav-pills"  role="navigation" style="background:#dbbff2;
    border-color: #4876FF #4876FF transparent;">  
<div>
      <font face="幼圆" size="4"><ul class="nav nav-pills nav-justified"  >
          <li> <a href="<%=request.getContextPath() %>/manager.jsp">未审批申请表</a></li>
             <li> <a href=findall.do?triptab.department=<%=request.getSession().getAttribute("department_name").toString()%>>已审批申请表</a></li>
            <li> <a href="<%=request.getContextPath() %>/baoxiao.jsp">未审批报销表</a></li>
			<li><a href="bxfindall.do?reimburse.department=<%=request.getSession().getAttribute("department_name").toString()%>">已审批报销表</a></li>
   			<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=1">查看个人信息</a></li>
			<li><a href="<%=request.getContextPath() %>/employeeinfor/<%=request.getSession().getAttribute("employee_id").toString()%>.do?flag=2">修改个人信息</a></li>
      		<li ><a href="<%=request.getContextPath() %>/update_pw.jsp">修改密码</a></li>

      </ul></font>

   </div>
</nav> 			
</body>
</html>