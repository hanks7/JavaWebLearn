package com.yidao.jdbc.imooc.day1Servlet.init;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 也可以通过注解
 */
@WebServlet(name = "CreateServlet")
public class Create1Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        Ulog.i("导入数据库数据库");
        //在web.xml中配置
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
