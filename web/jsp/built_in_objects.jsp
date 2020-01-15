<%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2020/1/15
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>jsp九大内置对象</title>
    <%--  14.jsp九大内置对象

      1.request
      2.response
      3.senssion
      4application
      5.out 输出对象 PrintWriter
      6.page 当前页面对象 this
      7.pageContext 页面当前上下文对象-PageContext
      8.config 应用配置对象 ServletConfig
      9.exception 应用异常对象 Throwable--%>


</head>
<body>
<%
    String url = request.getRequestURI().toString();
    out.println(url);

    String empty = null;
    empty.startsWith("h");

    out.println("<br>ABCCC");
    session.setAttribute("user", "张三");
    out.println((String) session.getAttribute("user"));

    String cp = application.getInitParameter("copyright");
    out.println("<hr/>");
    out.println(cp);



    pageContext.getRequest();
    pageContext.getResponse();
    pageContext.getSession();
    pageContext.getServletContext();

%>
</body>
</html>
