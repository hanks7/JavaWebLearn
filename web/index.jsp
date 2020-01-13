<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String basePath = request.getScheme() + ":" + "//" + request.getServerName() + ":" + request.getServerPort() + "/"
            + request.getServletContext().getContextPath();
        Ulog.i("basepath",basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录</title>
</head>
<body>
<form action="<%=basePath %>/ServletZhuanFaChongDingXiang" method="get">
    <p>用户名：<input type="text" name="username" value="admin"> </p>
    <p>密&nbsp;码：<input type="password" name="password" value="123"> </p>
    <p>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </p>

    <%=basePath %>
</form>
</body>
</html>