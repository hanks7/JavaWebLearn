<%@ page import="com.yidao.jdbc.uitls.Ulog" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/19
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发重定向传值</title>
</head>
<body>
<div class="main">
<%
        Ulog.i("request.getAttribute",request.getAttribute("username"));

        Ulog.i("application.getAttribute",application.getAttribute("username"));

%>

</div>

</body>
</html>
