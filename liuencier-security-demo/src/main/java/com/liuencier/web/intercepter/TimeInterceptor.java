package com.liuencier.web.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class TimeInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("===== Intercepter 执行开始 =====");
        System.out.println("===== Inteceptor preHandle 执行开始 =====");
        System.out.println("===== Interceptor 执行的类为: " + ((HandlerMethod) o).getBean().getClass().getName() + "=====");
        System.out.println("===== Interceptor 执行的方法为: " + ((HandlerMethod) o).getMethod().getName() + "=====");
        System.out.println("===== Inteceptor preHandle 执行结束 =====");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("===== Interceptor postHandle 执行开始 =====");
        System.out.println("===== Interceptor postHandle 执行结束 =====");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("===== Interceptor afterCompletion 执行开始 =====");
        System.out.println("===== Intercepter afterCompletion 执行结束 =====");
    }
}
