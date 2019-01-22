<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page import="com.yidao.jdbc.uitls.MyUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%--
    http://172.16.1.132:8080/jdbc/jsp/salary.jsp
    --%>
</head>
<body>
<table>
    <tr>
        <th>year</th>
        <th>salary</th>
    </tr>
    <%
        for (int i = 0; i <= 50; i++) {
            Ulog.i("hello world");
            out.println("<tr><td>" + i + "</td>");
            int sal = 0;
            if (i <= 5) {
                sal = 1500 + i * 150;
            } else if (i > 5 && i <= 10) {
                sal = 1500 + 150 * 5 + 300 * (i - 5);
            } else if (i > 10) {
                sal = 1500 + 150 * 5 + 300 * 5 + 375 * (i - 10);
            }
            out.println("<td>" + sal + "</td></tr>");
        }
    %>
</table>
</body>
</html>