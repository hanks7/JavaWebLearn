package com.yidao.jdbc.imooc.day1Servlet.pattern;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pattern/*")
public class PatternServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询员工的基本信息
		//获取当前访问的URL
		String url = request.getRequestURL().toString();
		Ulog.i(url);

		String id = url.substring(url.lastIndexOf("/") + 1);
		int eid =  Integer.parseInt(id);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println(id);
		if(eid == 1) {
			out.println("张三");
		}else if(eid == 2) {
			out.println("李四");
		}else {
			out.println("其他员工");
		}

	}

}
