package com.yidao.jdbc.imooc.day2el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * el 表达式练习
 */
@WebServlet("/info2")
public class ELServlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student stu=new Student("侯建军","18670801569");
//		request.setAttribute("grade", "B");
//		request.getServletContext().setAttribute("grade", "C");
        HttpSession session = request.getSession();
        session.setAttribute("student", stu);
        session.setAttribute("grade", "A");

        request.getRequestDispatcher("el/el_info.jsp").forward(request, response);
    }

}
