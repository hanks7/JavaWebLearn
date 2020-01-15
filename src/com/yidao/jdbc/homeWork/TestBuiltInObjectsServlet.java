package com.yidao.jdbc.homeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/TestBuiltInObjectsServlet")
public class TestBuiltInObjectsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param1 = request.getParameter("param1");
        HashMap hashMap = new HashMap<String, String>();
        hashMap.put("apple", "苹果");
        hashMap.put("banner", "香蕉");
        hashMap.put("orange", "橙子");

        if(hashMap.containsKey(param1)) {
            //转发
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }else{
            //转发
            request.getRequestDispatcher("/error/500.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
