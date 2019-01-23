package com.yidao.jdbc.imooc.el;

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
@WebServlet("/info2")
public class StudentServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacher = request.getParameter("teacher");
        Student stu = new Student();
        stu.setName("子墨");
        stu.setMobile(null);
        String grade = "A";
//		request.setAttribute("grade", "B");
//		request.getServletContext().setAttribute("grade", "C");
        HttpSession session = request.getSession();
        session.setAttribute("student", stu);
        session.setAttribute("grade", grade);
        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add("C");

        session.setAttribute("list", list);
//		request.setAttribute("student", stu);
//		request.setAttribute("grade", grade);
        request.getRequestDispatcher("el/el_info.jsp").forward(request, response);
    }

}
