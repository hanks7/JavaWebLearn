<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Insert title here</title>
</head>
<body>
<%--
for (String l : list) {
String content=  l;
}
var="l" 表示的就是 String l  jstl写法很奇特,也就遍历集合好用,其他的用处不大
varStatus="myIndex" 使用${myIndex.index} 表示下标志 注意java foreach是没有下标值的s
--%>

<c:forEach items="${list }" var="l">
    <span style="color:#2eb11d"> ${l}</span>
</c:forEach>

<c:forEach items="${sessionScope.stus }" var="c" varStatus="myIndex">
    <h1 style="color:#2eb11d">${sessionScope.stus.size()-myIndex.index} ${c.name}</h1>
</c:forEach>

</body>
</html>