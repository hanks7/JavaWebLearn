<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/12
  Time: 16:30
  To change this template use File | Settings | File Templates.

  http://localhost:8080/getParameter/login.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP内置对象</title>
    <style type="text/css">
        .main{
            border:solid red 1px;
            margin: 0 auto;
            width: 200px;
        }
    </style>
</head>
<body>
<div class="main">
    <%String account = "123";
        session.setAttribute("account", account);%>

    config对象:<%=config.getServletName()%><br>

    config获取web.xml中的 init-param中的值 <%=config.getInitParameter("age")%><br>
    <form action="http://localhost:8080/getParameter/control.jsp" id="form1">
        account : <input type="text" name="account"><br>
        password: <input type="text" name="password"><br>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
