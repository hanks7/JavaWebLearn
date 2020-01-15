package com.yidao.jdbc.imooc.day1Servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext服务器开始，其就存在，服务器关闭，其才释放
 */
@WebServlet("/servletcontext/default")
public class GetServletContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();

        //从配置文件中web.xml得到,相当于从Android vlues/string得到字符串
        String copyright = context.getInitParameter("copyright");
        String title = context.getInitParameter("title");


        context.setAttribute("copyright", copyright);
        context.setAttribute("title", title);

        String copyright2 = (String) context.getAttribute("copyright");
        String title2 = (String) context.getAttribute("title");

        response.setContentType("text/html;charset=utf-8");

        response.getWriter().println("<h1>" + title + "</h1>" + copyright);

    }

}

