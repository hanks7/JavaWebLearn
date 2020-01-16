<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    request.setAttribute("amt", 1987654.326);
    request.setAttribute("now", new java.util.Date());
    request.setAttribute("html", "<a href='index.html'>index</a>");
    request.setAttribute("nothing", null);
%>
<!--
    formatDate pattern
    yyyy - 四位年
    MM - 两位月
    dd - 两位日
    HH - 24小时制
    hh - 12小时制
    mm - 分钟
    ss - 秒数
    SSS - 毫秒
 -->



<%--注意格式时间 formatDate  和格式数字 formatNumber fmt:描述是不一样的--%>




<div>${now }</div>  <%--Thu Jan 16 13:09:18 CST 2020--%>
<div><fmt:formatDate value="${ now }" pattern="yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒"/></div><%--2020年01月16日 13时09分18秒 665毫秒--%>
<br/>

<div>${requestScope.amt }</div>  <%--1987654.326--%>
<br/>
<%--pattern="0.00" 表示保留小数点后两位,并不止是三位数,解释不清,你自己试试就知道了--%>
<div>¥<fmt:formatNumber value="${requestScope.amt }" pattern="0.00"></fmt:formatNumber>元</div>  <%--¥1987654.33元--%>
<div>¥<fmt:formatNumber value="${requestScope.amt }" pattern="0,00.00"></fmt:formatNumber>元</div><%--¥1,98,76,54.33元--%>
<br/>


<br/>

</body>
</html>