<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--

page                    Scope
request                 Scope
session                 Scope
application             Scope
注意为什么可以不用写 requestScope 或者sessionScope (Scope:范围/作用域)也可以显示
原因:不写表示,默认前面有 pageScope requestScope sessionScope  applicationScope,依次谁有值显示哪个.
****所以还是写上吧****

但是: 有一个是没有作用域的 就param 它是get或者post传来的参数  在servlet中得到的方式是
String teacher = request.getParameter("teacher");

在el表达式得到的方式是${param.teacher }

--%>

<h1>姓名：${student.name }</h1>
<h2>手机：${requestScope.student.mobile }</h2>
<h2>评级：${requestScope.grade }</h2>
<h2>讲师：${param.teacher }</h2>
<h2>概要：${student }</h2>
</body>
</html>