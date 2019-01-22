<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2019/1/17
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用jsp完成 1+到100 得到总和</title>
</head>

<%
    int t = 0;
    for (int i = 1; i < 101; i++) {
        t += i;
    }
%>
<%= "<span>" + t + "</span>" %>
<body>

</body>
</html>
