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
@WebServlet("/info1")
public class StudentServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu=new Student();
        stu.setName("Test");

        String grade="A";
        request.setAttribute("student",stu);
        request.setAttribute("grade",grade);
        request.getRequestDispatcher("el/el_info.jsp").forward(request,response);



    }

}
