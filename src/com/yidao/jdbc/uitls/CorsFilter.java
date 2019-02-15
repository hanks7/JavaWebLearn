package com.yidao.jdbc.uitls;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.yidao.jdbc.uitls.CorsFilter
 * @author xsx
 */
public class CorsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //TODO Auto-generated method stub

        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("Access-Control-Allow-Origin", "*");//允许所有的访问

        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");//允许的请求方式

        res.setHeader("Access-Control-Max-Age", "0");

        res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

        res.setHeader("Access-Control-Allow-Credentials", "true");

        res.setHeader("XDomainRequestAllowed","1");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
