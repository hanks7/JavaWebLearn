<%@ page import="com.yidao.jdbc.uitls.Ulog" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/9/19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp声明语法</title>

</head>
<body>

<%--<%! int getStr() {
    return 1234;
}%>
<%
    int j = 0;
    for (int i = 1; i < 101; i++) {
        j += i;
    }
    out.println(getStr());

    out.println(j); %>
<%=
getStr() %>
<%
    getStr(); %>--%>

<%! int getdata(){
    int d=0;
    for (int i = 1; i <= 100; i++) {
        d+=i;
        Ulog.i(i);

    }
    return d;
}%>
1-100数字的和 :
<%= out.println(getdata())%>
</body>
</html>
