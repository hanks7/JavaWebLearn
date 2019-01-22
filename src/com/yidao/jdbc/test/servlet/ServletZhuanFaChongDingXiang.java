package com.yidao.jdbc.test.servlet;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletZhuanFaChongDingXiang")
public class ServletZhuanFaChongDingXiang extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * http://localhost:8080/getParameter/zhuanFaChongDingXiang.jsp
     * <p>
     * http://localhost:8080/ZhuanFaChongDingXiang.do
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Ulog.i("username=" + username);
        Ulog.i("password=" + password);


        if ("admin".equals(username) && "123".equals(password)) {
            request.getRequestDispatcher("/success.jsp").forward(request, response);//转发实现跳转 浏览器地址不会发生改变, 浏览器请求一次,能传值
        } else {
            response.sendRedirect("/fail.jsp");//重定向 浏览器地址会发生改变,浏览器请求2次,不能传值  一定要注意在eclipse中 一定要加工程名JdbcDemo2  "/JdbcDemo2/fail.jsp"
        }
    }
}
