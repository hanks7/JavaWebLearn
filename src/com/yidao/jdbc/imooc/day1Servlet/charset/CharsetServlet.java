package com.yidao.jdbc.imooc.day1Servlet.charset;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/charset/process")
public class CharsetServlet extends HttpServlet {

    /**
     * 非常值得注意的是 Tomcat8以下的版本需要修改 tomcate根目录/conf/server.xml
     * 修改 <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443"  />
     * 为
     * <Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIENcoding="UTF-8" />
     * <p>
     * 否则还是要适配的 request.setCharacterEncoding("UTF-8");这句话的
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //对于Tomcat8.x的版本，默认get请求发送中文就是UTF-8的格式，因此无需转换
//        request.setCharacterEncoding("UTF-8");

        String ename = request.getParameter("ename");
        String address = request.getParameter("address");

        Ulog.i(ename + ":" + address);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(ename + ":" + address);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post请求发送中文是iso-8859-1的格式，因此需要转换
        request.setCharacterEncoding("UTF-8");

        String ename = request.getParameter("ename");
        String address = request.getParameter("address");

        Ulog.i(ename + ":" + address);

        //也可以通过String的api进行转换
        //String utf8Ename = new String(ename.getBytes("iso-8859-1") , "utf-8");
        //String utf8Address = new String(address.getBytes("iso-8859-1") , "utf-8");

        //Ulog.i(utf8Ename + ":" + utf8Address);

    }

}
