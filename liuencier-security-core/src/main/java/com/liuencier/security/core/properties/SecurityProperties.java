package com.liuencier.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

// 读取所有以 liuencier.security 开头的配置
@ConfigurationProperties(prefix = "liuencier.security")
public class SecurityProperties {

    // 读取 liuencier.security.browser
    private BrowserProperties browser = new BrowserProperties();
    private SocialProperties social = new Soc

}
