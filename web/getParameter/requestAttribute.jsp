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
    <title>request 作用域</title>
</head>
<body>
<%
    request.setAttribute("keyA","valuesB");
    request.getRequestDispatcher(".jsp").forward(request,response);
%>
</body>
</html>
