<%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/12
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自由编程</title>
    <style type="text/css">
        .main span {
            width: 200px;
            line-height: 50px;
            margin: 0 auto;
            display: block;
            text-align: center;
        }
    </style>
    <% int x = -5, y = 0;
        if (x < 0) {
        }%>

</head>
<body>
<div class="main ">
    <span >当x<0时,输出</span>
    <span >x=<%
        out.println(x);
    %></span>
    <span >y=<%
        if (x > 0) {
        y=1;
        out.println(y);
        } else if (x < 0) {
            y = -1;
            out.println(y);
        } else {
            y = 0;
            out.println(y);
        }
    %></span>
</div>
</body>
</html>
