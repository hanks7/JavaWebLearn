package com.yidao.jdbc.imooc.day1Servlet.session;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * **
 *  * JSP中九大内置对象为：
 *  * request            请求对象　                类型 javax.servlet.ServletRequest      作用域    Request
 *  * response           响应对象                   类型 javax.servlet.SrvletResponse     作用域    Page
 *  * pageContext        页面上下文对象       类型 javax.servlet.jsp.PageContext          作用域    Page
 *  * session            会话对象                   类型 javax.servlet.http.HttpSession   作用域    Session
 *  * application        应用程序对象          类型 javax.servlet.ServletContext          作用域    Application
 *  * out                输出对象                   类型 javax.servlet.jsp.JspWriter      作用域    Page
 *  * config             配置对象                  类型 javax.servlet.ServletConfig       作用域    Page
 *  * page               页面对象                  类型 javax.lang.Object                 作用域    Page
 *  * exception          例外对象                 类型 javax.lang.Throwable               作用域    page
 *
 */
@WebServlet("/session/login")
public class SetSessionServlet extends HttpServlet {
    /**
     * 与cookie不同的是cookie_id是存在浏览器上的
     * 而session_id是存储在tomcat内存上的
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取到用户会话Session对象
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        Ulog.i("SetSessionServlet", sessionId);
        session.setAttribute("name", "张三");
        request.getRequestDispatcher("/session/index").forward(request, response);

    }

}

