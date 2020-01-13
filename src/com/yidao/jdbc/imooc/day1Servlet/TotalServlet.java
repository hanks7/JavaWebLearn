package com.yidao.jdbc.imooc.day1Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/jdbc/total1?value=1
 */
@WebServlet("/total1")
public class TotalServlet extends HttpServlet {
    int intTotal = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("value");
        int parameter = Integer.valueOf(value);
        intTotal += parameter;
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(intTotal);

    }
}
