package com.yidao.jdbc.login;

import com.yidao.jdbc.bean.User;
import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        List<User> list = new ArrayList<>();
        getServletContext().setAttribute("list", list);
        Ulog.i("InitServlet", "init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * http://localhost:8080/aaa.do
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ulog.i("InitServlet", "doget");
    }

}
