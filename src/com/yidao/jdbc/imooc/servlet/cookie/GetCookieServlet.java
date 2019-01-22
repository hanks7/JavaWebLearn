package com.yidao.jdbc.imooc.servlet.cookie;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookies/index")
public class GetCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//request.getCookies()用户获取所有的Cookie
		Cookie[] cs = request.getCookies();
		if(cs == null) {
			response.getWriter().println("还没有设置Cookie");
			return;
		}
		String user = null;
		for(Cookie c : cs) {
			Ulog.i(c.getName() + ":" + c.getValue());
			if(c.getName().equals("user")) {
				user = c.getValue();
				break;
			}
		}

		if(user == null) {
			response.getWriter().println("user not login");
		}else {
			response.getWriter().println("user:" + user);
		}
	}

}

