<%@ page import="com.yidao.jdbc.uitls.Ulog" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    session.setAttribute("loginUser", username);        //模拟登录操作，在session中存入登录用户的用户名
    String strPath = request.getContextPath() + "/filter/message.jsp";
    Ulog.i("strPath", strPath);
    response.sendRedirect(request.getContextPath() + "/filter/message.jsp");//重定向至留言板页面
%>