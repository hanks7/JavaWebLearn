package com.yidao.jdbc.homeWork;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/jdbc/HomeWorkServlet?parameter1=1&parameter2=2
 */
@WebServlet("/HomeWorkServlet")
public class HomeWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter1 = request.getParameter("parameter1");
        String parameter2 = request.getParameter("parameter2");
        int total = Integer.valueOf(parameter1) + Integer.valueOf(parameter2);
        Ulog.i("ServletPost", parameter1, parameter2);

        response.getWriter().println("<span>加法计算器:<br/>运算结果为:<span/>" + total);

    }
}
