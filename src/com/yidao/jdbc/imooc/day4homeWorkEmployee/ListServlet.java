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

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        if (context.getAttribute("employees") == null) {
            List list = new ArrayList();
            list.add(new Employee(7731, "刘志敏", "市场部", "客户代表", 10000f));
            list.add(new Employee(8871, "张倩", "研发部", "运维工程师", 8000f));
            context.setAttribute("employees", list);
        }
        request.getRequestDispatcher("day4homeWorkEmployee/employee.jsp").forward(request, response);
    }

}
