<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
            + request.getServletContext().getContextPath();
    Ulog.i("basepath",basePath);
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <title>九大内置对象测试题</title>

    <style>
        .main {
            margin: 100px auto;
            border: 1px red solid;
            width: 1000px;
            height: 200px;
        }

        input {
            margin-top: 12px;
        }
    </style>
</head>
<body>
<div class="main">
    <form
            action="/jdbc/TestBuiltInObjectsServlet"
            method="post"
            id="formID2"
            enctype="UTF-8">
        <div>
            <input type="text" maxlength="10" name="param1" placeholder="请输入要查询的单词"/>
            <input type="submit" value="查询"/>
        </div>

    </form>

</div>
</body>
</html>