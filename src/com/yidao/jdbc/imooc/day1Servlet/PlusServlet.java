package com.yidao.jdbc.imooc.day1Servlet;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 慕课网 对应的是http://localhost:63343/JavaWebLearn/web/html/html-html/11-form表单-input.html
 */
@WebServlet( "/PlusServlet")
public class PlusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value1 = request.getParameter("param1");
        String value2 = request.getParameter("param1");
        int parameter1 = Integer.valueOf(value1);
        int parameter2 = Integer.valueOf(value2);
        int intTotal  = parameter1+parameter2;
        Ulog.i("intTotal",intTotal);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(intTotal);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
