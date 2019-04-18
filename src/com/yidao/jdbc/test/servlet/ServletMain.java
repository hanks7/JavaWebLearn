package com.yidao.jdbc.test.servlet;

import com.yidao.jdbc.uitls.UtilJdbc;
import com.yidao.jdbc.uitls.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http://localhost:8080/jdbc/Servlet1
 * http://172.16.1.132:8080/jdbc/Servlet1
 */
@WebServlet("/Servlet1")
public class ServletMain extends HttpServlet {
    /**
     * Myservlet:是此工程名称 test:是web.xml<url-pattern>名字</url-pattern>
     * http://localhost:8080/untitled/test
     * <p>
     * http://localhost:8080/index.jsp
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Myservlet:是此工程名称 test:是web.xml<url-pattern>名字</url-pattern>
     * http://localhost:8080/Tag.do
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilJdbc.startMySQLConn();
        UtilJdbc.useDB();
//        try {
//            Thread.sleep(10 *60*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        MyUtils.trueMessage(response, UtilJdbc.setlect());
        UtilJdbc.stopMySQLConn();

    }
}
