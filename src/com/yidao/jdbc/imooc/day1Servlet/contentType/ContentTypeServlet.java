package com.yidao.jdbc.imooc.day1Servlet.contentType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ContentTypeServlet
 *
 * 1、 返回普通文本给客户端，Content-Type="text/plain"
 * 2 、返回HTML代码给客户端 ，Content-Type="text/html"
 * 3 、返回XML代码给客户端 ，Content-Type="text/xml"
 * 4 、返回javascript代码给客户端
 * 5 、返回json串给客户端
 *
 * application/x-msdownload 需要下载的资源
 *
 * image/jpeg   图片资源
 * image/gif
 * image/...
 *
 */
@WebServlet("/ct")
public class ContentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * plain:表示纯文本 Ctrl+F5 表示清除缓存并更新 非常重要
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "<h1><a href='http://www.baidu.com'><span>百度</span></a></h1>";
//		response.setContentType("text/html;charset=utf-8");					//HTML格式
//		response.setContentType("text/plain;charset=utf-8");				//纯文本,将html也变成文本格式
		response.setContentType("application/x-msdownload;charset=utf-8");  //表示下载文件
		response.getWriter().println(output);
	}

}
