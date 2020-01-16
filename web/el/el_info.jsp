<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page import="com.yidao.jdbc.imooc.day2el.Student" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
            + request.getServletContext().getContextPath();
    Ulog.i("basepath",basePath);
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <title>EL表达式</title>
</head>
<body>
<%--

page                    Scope
request                 Scope
session                 Scope
application             Scope
注意为什么可以不用写 requestScope 或者sessionScope (Scope:范围/作用域)也可以显示
原因:不写表示,默认前面有 pageScope requestScope sessionScope  applicationScope,依次谁有值显示哪个.如果有相同的key取值从作用域最小的取值(applicationScope作用域最大)
****为了严谨所以还是写上吧****

但是: 有一个是没有作用域的 就param 它是get或者post传来的参数  在servlet中得到的方式是
String teacher = request.getParameter("teacher");

在el表达式得到的方式是${param.teacher }

el表达式也支持运算和逻辑运算
${1+300}
${1<==3 && 2>4}

--%>

<%
    Student stu = (Student) request.getAttribute("student");
%>

<h3>Name：<%=stu.getName()%>  </h3>
<h3>Mobile：<%=stu.getMobile()%></h3>
<h3>grade：<%=request.getAttribute("grade")%></h3>
<h3>概要：<%=stu%></h3>
<br/>
<h2>以下是EL表达式</h2>
<h3>姓名：${student.name }</h3>
<h3>概要：${student}</h3>   <%--想要打印student 必须重写Student的toString() 否则输出就是一个hashCode--%>
<h3>年级：${requestScope.grade }</h3>
<h3>讲师：${requestScope.teacher}</h3>
<h3>手机：${requestScope.student.mobile }</h3>

<%--http://localhost:8080/jdbc/el/el_info.jsp?teacher=kkk 通过传参--%>
<h3>teacher：${param.teacher }</h3>



</body>
</html>