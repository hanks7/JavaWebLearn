package com.yidao.jdbc.imooc.day7filter;

import com.yidao.jdbc.uitls.Ulog;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @全称 :  com.yidao.jdbc.imooc.day7filter.MyFilter
 * @作者 :  hanks7 QQ:474664736
 * @创建时间 :  2020/1/21 13:49
 * @修改时间 :
 * @描述 :
 *          1.过滤器是j2EE Servlet 模块下的组件
 *          2.Filter的作用是对Url进行统一的拦截处理
 *          3.过滤器不仅会对请求做出拦截，也会对响应做出拦截
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Ulog.i("MyFilter","过滤器已生效");

        chain.doFilter(request, response);//让他继续传递下去
    }

    @Override
    public void destroy() {

    }
}
