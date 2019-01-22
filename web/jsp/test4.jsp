<%@page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>jsp页面重用</title>
</head>

<body>
<%@include file="include/header.jsp" %>
<%
    out.println("<h1>新闻标题</h1>");
    out.println("<p>新闻正文</p>");
%>
<%@include file="include/footer.jsp" %>
</body>
</html>
