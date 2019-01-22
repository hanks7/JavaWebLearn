package com.yidao.jdbc.homeWork;

import com.yidao.jdbc.uitls.MyUtils;
import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/ServletPost")
public class ServletPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Ulog.i("ServletPost",username,password);
        MyUtils.trueMessage(response, "hello world");
    }

    /**
     * http://localhost:8080/jdbc/Servlet6?username=1&password=2
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
