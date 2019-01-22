<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2019/1/17
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>求一千以内的质素</title>
</head>

<%!
    public static ArrayList<Integer> get() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 2; i < 100; i++) {
            boolean boo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    boo = false;
                    break;
                }
            }
            if (boo) {
                list.add(i);
            }

        }
        return list;
    }

%>
<% for (Integer t : get()) {
%>
<span style="color: #000; font-size: 18px"><%=t%></span><br/>

<%
    }
%>
<body>

</body>
</html>
