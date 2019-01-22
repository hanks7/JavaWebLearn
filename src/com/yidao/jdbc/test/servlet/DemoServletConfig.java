package com.yidao.jdbc.test.servlet;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DemoServletConfig")
public class DemoServletConfig extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     *  <servlet>
     *         <servlet-name>DemoServletConfig</servlet-name>
     *         <servlet-class>com.yidao.jdbc.test.servlet.DemoServletConfig</servlet-class>
     *         <init-param>
     *             <param-name>age</param-name>
     *             <param-value>100</param-value>
     *         </init-param>
     *     </servlet>
     *
     *     <servlet-mapping>
     *         <servlet-name>DemoServletConfig</servlet-name>
     *         <url-pattern>/config.do</url-pattern>
     *     </servlet-mapping>
     *     
     *     servletConfig 作用:主要就是获取 <init-param>
     *                 <param-name>age</param-name>
     *                 <param-value>100</param-value>
     *             </init-param>
     *
     *
     * http://localhost:8080/config.do
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = getServletConfig().getInitParameter("age");
        Ulog.i("config",str);

    }
}
