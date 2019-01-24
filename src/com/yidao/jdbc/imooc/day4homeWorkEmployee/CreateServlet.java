package com.yidao.jdbc.imooc.day4homeWorkEmployee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

        String empno = request.getParameter("empno");
        String ename = request.getParameter("ename");
        String department = request.getParameter("department");
        String job = request.getParameter("job");
        String salary = request.getParameter("salary");

        Employee emp = new Employee(Integer.parseInt(empno) , ename , department , job , Float.parseFloat(salary));
        ServletContext context = request.getServletContext();
        List employees = (List)context.getAttribute("employees");
        employees.add(emp);
        context.setAttribute("employees", employees);

        request.getRequestDispatcher("day4homeWorkEmployee/employee.jsp").forward(request, response);
	}

}
