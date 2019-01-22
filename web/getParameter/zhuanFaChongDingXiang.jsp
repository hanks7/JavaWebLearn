<%--
  Created by IntelliJ IDEA.
  User: hjj
  Date: 2018/10/19
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .main{
            border:solid red 1px;
            margin: 0 auto;
            width: 200px;
        }
    </style>
</head>
<body>
<div class="main">
    <form action="http://localhost:8080/ZhuanFaChongDingXiang.do" id="form1">
        account&nbsp;&nbsp;&nbsp;: <input type="text" name="username"><br>
        password: <input type="text" name="password"><br>
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
