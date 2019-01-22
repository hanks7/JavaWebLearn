<%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/16
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session:主要用于跟踪会话,会话是代表第一次进入浏览器到关闭浏览器,在此期间与服务器的
        一系列交互(相当于Android的sharepreference),是一个放在application中的全局变量</title>
</head>
<body>
<% String account = "123";
    session.setAttribute("account", account); %>

<%=session.getAttribute("account")%>

<% session.setMaxInactiveInterval(5*60);//session有效保存五分钟%>

1.可以调用HttpSession的invalidate方法，立即销毁session域

2.当web应用被移除出web容器时

3.该web应用对应的session跟着销毁

</body>
</html>
