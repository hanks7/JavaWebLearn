<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/12
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>自由编程</title>
    <style type="text/css">
    </style>

</head>
<body>
<div class="main ">
    <h1><%=response.getCharacterEncoding()%>
    </h1><br><!-- response练习 -->
    <%
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String account2 = pageContext.getRequest().getParameter("account");
    %>

    账号:<%=account%><br>
    密码:<%=password%><br>
    session-account:<%=session.getAttribute("account")%><br>

    config对象:<%=config.getServletName()%><br>

    config获取web.xml中的 init-param中的值 <%=config.getInitParameter("age")%><br>


    <% if (account.equals("")) throw new Exception("account 输入不能为空"); %>


</div>
</body>
</html>
