package com.yidao.jdbc.imooc.day2el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * el 表达式练习
 */
@WebServlet("/info1")
public class ELServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student stu=new Student("hanks7","18670801569");

        request.setAttribute("student",stu);
        request.setAttribute("grade","A");
        request.setAttribute("teacher","Teacher");



        request.getRequestDispatcher("el/el_info.jsp?teacher=kkk").forward(request,response);



    }

}
