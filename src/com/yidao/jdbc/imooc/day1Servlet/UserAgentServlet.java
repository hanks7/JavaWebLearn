package com.yidao.jdbc.imooc.day1Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class UserAgentServlet
 */
@WebServlet("/ua")
public class UserAgentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userAgent = request.getHeader("User-Agent");

        if (userAgent.length() > 0) {
            System.out.println("userAgent已存在");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(userAgent);
        String output = "";
        if (userAgent.contains("Windows NT")) {
            output = "<h1>这是ＰＣ端首页</h1>";
        } else if (userAgent.contains("iPhone") || userAgent.contains("Android")) {
            output = "<h1>这是移动端首页</h1>";
        }
        response.getWriter().println(output);
    }

}
