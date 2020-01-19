<%@ page import="com.yidao.jdbc.uitls.CookieUtils" %>
<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Ulog.i("basePath", basePath);
%>
<base href="<%=basePath%>">  <%--值包含href 不包含form action --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="LoginRegister/css/login.css">
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="LoginRegister/login.jsp">登录</a> <a href="LoginRegister/regist.jsp">注册</a>
        </h1>

    </div>
    <%
        String username = "";
        // 获得从客户端携带过来的所有的Cookie
        Cookie[] cookies = request.getCookies();
        // 从Cookie的数组中查找指定名称的Cookie
        Cookie cookie = CookieUtils.findCookie(cookies, "username");
        if (cookie != null) {
            username = cookie.getValue();
        }

        if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }

        String msg = "";
        if (request.getAttribute("msg") != null) {
            msg = (String) request.getAttribute("msg");
        }

    %>
    <h3><font color="red"><%=msg %>
    </font></h3>
    <form action="/jdbc/LoginServlet" method="post">
        <table>
            <tr>
                <td class="td1">用户名</td>
                <td><input type="text" class="input1" name="username" value="<%=username %>"></td>
            </tr>
            <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
            </tr>
            <tr>
                <td class="td1" colspan="2">
                    <input type="checkbox" name="remember" value="true" checked="checked"> 记住用户名
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div class="btn-red">
                        <input type="submit" value="登录" id="login-btn">
                    </div>
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>