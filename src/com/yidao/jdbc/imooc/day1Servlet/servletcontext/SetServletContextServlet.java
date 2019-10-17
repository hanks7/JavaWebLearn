package com.yidao.jdbc.imooc.day1Servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SetServletContextServlet
 *
 * ServletContext服务器开始，其就存在，服务器关闭，其才释放
 */
@WebServlet("/servletcontext/init")
public class SetServletContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        context.setAttribute("copyright", "Copyright © 2019 imooc.com All Rights Reserved | 京ICP备 12003892号-11");
        context.setAttribute("title", "慕课网程序员的梦工厂");

        response.getWriter().println("init success");

    }

}
