package com.liuencier.web.config;

import com.liuencier.web.filter.TimeFilter;
import com.liuencier.web.intercepter.TimeIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TimeIntercepter timeIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeIntercepter);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();

        registrationBean.setFilter(timeFilter);

        // 通过路径进行拦截
        List<String> urls = new ArrayList<>();
        urls.add("/*");

        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}