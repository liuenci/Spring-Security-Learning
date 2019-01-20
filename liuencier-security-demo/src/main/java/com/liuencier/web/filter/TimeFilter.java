package com.liuencier.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter Start");
        long startTime = new Date().getTime();
        // 执行过滤
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = new Date().getTime();
        System.out.println("Filter end");
        System.out.println("执行时间:" + (endTime - startTime));
    }

    @Override
    public void destroy() {

    }
}
