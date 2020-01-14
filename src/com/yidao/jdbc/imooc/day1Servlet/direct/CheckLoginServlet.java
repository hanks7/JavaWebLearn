package com.yidao.jdbc.imooc.day1Servlet.direct;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/direct/check")
public class CheckLoginServlet extends HttpServlet {

	/**
	 * 转发 只是servlet中调用url,并不是浏览器调用
	 * 重定向则是浏览器去调用url 而且要加上contextPath(在这个项目就是"/jdbc") 浏览器中的url肯定会发生变化.在加上本身也是Servlet也是通过url调用的
	 * 所以浏览器会调用两次url这么一说(注:并不是两个相同的url,课程中有误解的嫌疑)
	 *
	 * 如果用转发，可以直接用request、response。如果用重定向就只能用session 来传值
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ulog.i("用户登录成功");
		request.setAttribute("username", "admin");


		//转发
		request.getRequestDispatcher("/direct/index").forward(request, response);

		//重定向   需要增加contextPath
//		response.sendRedirect("/jdbc/direct/index");
	}

}

