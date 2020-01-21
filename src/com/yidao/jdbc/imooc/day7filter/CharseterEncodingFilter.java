package com.yidao.jdbc.imooc.day7filter;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @项目名称 : JavaWebLearn
 * @包名 : com.yidao.jdbc.imooc.day7filter
 * @作者 : hjj QQ:474664736
 * @创建时间 : 2020/1/21 15:26
 * @修改时间 :
 * @描述 : 请填写表述
 */
@WebFilter(filterName = "CharseterEncodingFilter", urlPatterns = "/*",initParams={
        @WebInitParam(name = "encoding", value = "GBK") ,
        @WebInitParam(name = "param1", value = "参数1") ,
        @WebInitParam(name = "param2", value = "参数2")
})
public class CharseterEncodingFilter implements Filter {
    String strEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        strEncoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Ulog.i("strEncoding",strEncoding);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding(strEncoding);

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset="+strEncoding);

        filterChain.doFilter(request, response);//让他继续传递下去
    }

    @Override
    public void destroy() {

    }
}
