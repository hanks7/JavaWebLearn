package com.yidao.jdbc.imooc.day3jstl;

import com.yidao.jdbc.imooc.day2el.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * el 表达式练习
 */
@WebServlet("/core")
public class CoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        session.setAttribute("list", list);

        List<Student> stus = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Student s=new Student();
            s.setName("aaa"+i);
            s.setMobile(i+""+i+""+i);
            stus.add(s);
        }
        session.setAttribute("stus", stus);

        request.getRequestDispatcher("jstl/core.jsp").forward(request, response);
    }

}
