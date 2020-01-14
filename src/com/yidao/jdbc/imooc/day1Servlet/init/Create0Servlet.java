package com.yidao.jdbc.imooc.day1Servlet.init;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <!--服务启动时,第一个加载的servlet，优先加载 0表示 优先级最高，相当于android的application-->
 *     <servlet>
 *         <servlet-name>CreateServlet</servlet-name>
 *         <servlet-class>com.yidao.jdbc.imooc.day1Servlet.init.CreateServlet</servlet-class>
 *         <load-on-startup>0</load-on-startup>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>CreateServlet</servlet-name>
 *         <url-pattern>/CreateServlet</url-pattern>
 *     </servlet-mapping>
 *
 *     也可以通过注解来注册启动时加载 例如 ：@WebServlet(urlPatterns = "/CreateServlet", loadOnStartup = 0)
 *     注意一定要添加url映射地址
 *
 *     http://localhost:8080/jdbc/CreateServlet
 */
@WebServlet(name = "CreateServlet")
public class Create0Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Ulog.i("服务启动时,第一个加载的servlet，优先加载 0表示 优先级最高，相当于android的application");
        //在web.xml中配置
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
