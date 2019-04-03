package com.yidao.jdbc.test.servlet;

import com.yidao.jdbc.uitls.UtilJdbcMySql;
import com.yidao.jdbc.uitls.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        UtilJdbcMySql.startMySQLConn();
        UtilJdbcMySql.useDB();
        MyUtils.trueMessage(response, UtilJdbcMySql.setlect());
        UtilJdbcMySql.stopMySQLConn();

    }
}
