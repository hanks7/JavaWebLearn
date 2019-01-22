<%@ page import="com.yidao.jdbc.uitls.Ulog" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/16
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>application:和Android 的application作用域一样</title>
</head>
<body>

<% Object o=application.getAttribute("count");
        Ulog.i(o);
    if (o == null) {
        application.setAttribute("count",1);
        Ulog.i("o == null");
    }else{
        Ulog.i("else");
        int count = Integer.parseInt(o.toString());
        application.setAttribute("count",++count);
    }
%>
<h1><%=application.getAttribute("count")%></h1>
</body>
</html>
