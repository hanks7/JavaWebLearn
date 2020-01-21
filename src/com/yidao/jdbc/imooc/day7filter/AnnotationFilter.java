package com.yidao.jdbc.imooc.day7filter;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @项目名称 : JavaWebLearn
 * @包名 : com.yidao.jdbc.imooc.day7filter
 * @作者 : hjj QQ:474664736
 * @创建时间 : 2020/1/21 15:07
 * @修改时间 :
 * @描述 : 请填写表述
 */
@WebFilter(filterName = "MyAnnoationFilter", urlPatterns = "/*")
public class AnnotationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Ulog.i("MyAnnoationFilter", "过滤器已生效");
        filterChain.doFilter(servletRequest, servletResponse);//让他继续传递下去
    }

    @Override
    public void destroy() {

    }
}
