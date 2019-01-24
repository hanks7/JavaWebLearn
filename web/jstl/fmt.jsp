<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div>${now }</div>
<div><fmt:formatDate value="${ now }" pattern="yyyy年MM月dd日 HH时mm分ss秒 SSS毫秒"/></div>
<br/>

<div>${amt }</div>
<br/>
<%--pattern="0.00" 表示保留小数点后两位,并不止是三位数,解释不清,你自己试试就知道了--%>
<div>¥<fmt:formatNumber value="${amt }" pattern="0.00"></fmt:formatNumber>元</div>
<div>¥<fmt:formatNumber value="${amt }" pattern="0,00.00"></fmt:formatNumber>元</div>
<br/>

<div>null默认值：<c:out value="${nothing }" default="无"></c:out></div>
<br/>
<%--escapeXml="true"是否需要转义--%>
<div><c:out value="${ html}" escapeXml="true"></c:out></div>
<br/>

</body>
</html>