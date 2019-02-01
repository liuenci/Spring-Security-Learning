package com.liuencier.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

@Component
public class BrowserSecurityBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

}
