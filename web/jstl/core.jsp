<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstlTag" %>
<%--
如果你想使用jstl表达式你需要两个jar包分别是:taglibs-standard-impl-1.2.5.jar
                                            taglibs-standard-spec-1.2.5.jar
                                            即可放在javaweb的lib文件夹下,也可放在tomcat 的lib文件夹下,最好是放在Tomcat的lib 因为别的项目也可以使用

"http://java.sun.com/jsp/jstl/core":是tomcat核心标签库  prefix:汉译-前缀 使用c这个前缀表示"core核心标签库"
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>jstl表达式</title>

    <style>
        span {
            color: #2eb11d
        }

        h1 {
            color: #2eb11d
        }
    </style>
</head>
<body>
<%--
for (String l : list) {
String content=  l;
}
var="l" 表示的就是 String l  jstl写法很奇特,也就遍历集合好用,其他的用处不大
varStatus="myIndex" 使用${myIndex.index} 表示下标志 注意java foreach是没有下标值的s
--%>

<jstlTag:forEach items="${sessionScope.list }" var="li">
    <span> ${li}</span>
</jstlTag:forEach>

<h1>集合长度${sessionScope.stus.size()}</h1>

<jstlTag:forEach items="${sessionScope.stus }" var="stu"
                 varStatus="myIndex"> <%-- items var varStatus对应 list<Student> Student position--%>
    <h1>下标${myIndex.index}内容 ${stu.name}</h1>
</jstlTag:forEach>

</body>
</html>