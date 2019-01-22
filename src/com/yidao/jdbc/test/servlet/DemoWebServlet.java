package com.yidao.jdbc.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/jdbc/DemoWebServlet
 * @WebServlet(name = "DemoWebServlet") 你如果想使用WebServlet 请注意两者的区别 别忘记"/"
 */
@WebServlet("/DemoWebServlet")
public class DemoWebServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("hello world");
    }

}
