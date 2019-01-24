package com.yidao.jdbc.imooc.day1Servlet.session;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session/index")
public class GetSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        Ulog.i("GetSessionServlet",sessionId);

        String name = (String) session.getAttribute("name");
        Ulog.i("name",name);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("这是首页，当前用户为:" + name+"当前sessionId:"+sessionId);

    }

}
