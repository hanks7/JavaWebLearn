package com.yidao.jdbc.imooc.servlet.cookie;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies/login")
public class SetCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        Ulog.i("用户登录成功");
        Cookie cookie = new Cookie("user", "admin");
        cookie.setMaxAge(60 * 60 * 24 * 7);//cookie的最大值, 这里设置的是7天 秒*分*时*天
        response.addCookie(cookie);
        response.getWriter().println("login success");

    }

}

