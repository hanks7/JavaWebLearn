<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yidao.jdbc.imooc.day2el.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="coreTag" %>
<%--
如果你想使用jstl表达式你需要两个jar包分别是:taglibs-standard-impl-1.2.5.jar
                                            taglibs-standard-spec-1.2.5.jar
                                            即可放在javaweb的lib文件夹下,也可放在tomcat 的lib文件夹下,最好是放在Tomcat的lib 因为别的项目也可以使用

"http://java.sun.com/jsp/jstl/core":是tomcat核心标签库  prefix:汉译-前缀 使用coreTag这个前缀表示"core核心标签库"
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

<%

    List<String> list = new ArrayList<>();
    list.add("A");
    list.add("B");
    list.add("C");
    session.setAttribute("list", list);

    List<Student> stus = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
        Student s=new Student();
        s.setName("aaa"+i);
        s.setMobile(i+""+i+""+i);
        stus.add(s);
    }
    session.setAttribute("stus", stus);

    request.setAttribute("amt", 1987654.326);
    request.setAttribute("now", new java.util.Date());
    request.setAttribute("html", "<a href='index.html'>index</a>");
    request.setAttribute("nothing", null);
    request.setAttribute("score", 60);
    request.setAttribute("grade", "A");
%>

<coreTag:if test="${requestScope.score>=60}">
    <h1 style="color:green">恭喜,你已通过测试</h1>
</coreTag:if>

<coreTag:if test="${requestScope.score<60}">
    <h1 style="color:green">对不起,再接再厉</h1>
</coreTag:if>

<coreTag:choose>
    <coreTag:when test="${requestScope.grade=='A'}">
        <h1>你很优秀</h1>
    </coreTag:when>
    <coreTag:when test="${requestScope.grade=='B'}">
        <h1>良好</h1>
    </coreTag:when>
    <coreTag:otherwise>
        <h1>一切随缘吧</h1>
    </coreTag:otherwise>
</coreTag:choose>


<div>null默认值：<coreTag:out value="${requestScope.nothing }" default="无"></coreTag:out></div><%--null默认值：无--%>
<br/>
<%--escapeXml="true"是否需要转义--%>
<div><coreTag:out value="${ requestScope.html}" escapeXml="true"></coreTag:out></div> <%--<a href='index.html'>index</a>--%>
<div><coreTag:out value="${ requestScope.html}" escapeXml="false"></coreTag:out></div><%--index--%>
<div><coreTag:out value="${ requestScope.html}"  ></coreTag:out></div><%--<a href='index.html'>index</a>--%>





<%--
  items var varStatus对应 集合 集合内的对象 position
varStatus="myIndex" 使用${myIndex.index} 表示下标志
--%>

<coreTag:forEach items="${sessionScope.list }" var="li">
    <span> ${li}</span>
</coreTag:forEach>

<h1>集合长度${sessionScope.stus.size()}</h1>

<%--               items                         var        varStatus         对应 集合 集合内的对象 position--%>
<coreTag:forEach items="${sessionScope.stus }" var="stu" varStatus="myIndex">
    <h1>下标${myIndex.index}内容 ${stu.name}</h1>
</coreTag:forEach>

</body>
</html>