<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2019/1/17
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--
    http://172.16.1.132:8080/jdbc/jsp/test1.jsp
    --%>
    <%--
    jsp语法:
    1.<% java代码 %>  jsp代码块  eg:<% Ulog.i("hello world");%>
                相当于在servlet中 service(HttpServletRequest request, HttpServletResponse response)中运行,
                或者public static void main(String[] args)中运行
                当然也可以声明变量
    2.<%! 声明语句 %>   jsp声明结构块 用于声明变量或方法 <%! 声明语句 %>
    3.<%= java代码块 %>   jsp输出指令    <%= "<b>"+name+"</b>" %>  其实等于 out.println("<b>"+name+"</b>");
    4.<%@ 处理指令 %>     jsp处理指令 <%@ page contentType="text/html;charset=UTF-8" language="java" %>;<%@ page import="com.yidao.jdbc.uitls.Ulog" %> 导包用的
    --%>
</head>
<% Ulog.i("hello world");%>
<%! String content = "houjianjun say hi<br/>";%>
<%! String log(JspWriter out) throws IOException {
    String message = "<b>" + content + "</b>";
    out.println(message);
    return message;
}%>
<%= log(out) %>
<body>

</body>
</html>
