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
        System.out.println("===== Filter 执行开始 =====");
        // 执行过滤
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("===== Filter 执行结束 =====");
    }

    @Override
    public void destroy() {

    }
}
