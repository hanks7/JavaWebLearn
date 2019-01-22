<%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/15
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext 作用域,当前页有效,相当于全局变量的hashMap</title>
</head>
<body>
<%
   pageContext.include("header.jsp");
   pageContext.setAttribute("key","value");
    pageContext.getAttribute("key");
%>
<%=pageContext.getAttribute("key")%>
<br>
</body>
</html>
