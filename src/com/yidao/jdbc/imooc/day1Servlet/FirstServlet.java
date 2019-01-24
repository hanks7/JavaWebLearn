package com.yidao.jdbc.imooc.day1Servlet;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://localhost:8080/jdbc/FirstServlet?name=123
 * <p>
 * http://localhost:8080/jdbc/FirstServlet?name=123&mobile=138456456456&sex=test-spec1&spec=test-spec2&spec=test-spec3
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    public FirstServlet() {
        Ulog.i("正在创建FirstServlet对象");
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        Ulog.i("正在初始化FirstServlet对象");
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String methodName = request.getMethod();
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String sex = request.getParameter("sex");
        String[] specs = request.getParameterValues("spec");
        PrintWriter out = response.getWriter();//向浏览器输出的数据流
        out.println("<h1>method:" + methodName + "</h1>");
        out.println("<h1>name:" + name + "</h1>");
        out.println("<h1>mobile:" + mobile + "</h1>");
        out.println("<h1>sex:" + sex + "</h1>");
        for (int i = 0; i < specs.length; i++) {
            out.println("<h2>spec:" + specs[i] + "</h2>");
        }
        out.println("<a href='http://www.baidu.com'>Baidu</a>");
    }


    @Override
    public void destroy() {
        Ulog.i("正在销毁servlet对象");
    }
}
