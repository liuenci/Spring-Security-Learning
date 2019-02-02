package com.liuencier.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

// 读取所有以 liuencier.security 开头的配置
@ConfigurationProperties(prefix = "liuencier.security")
public class SecurityProperties {

    // 读取 liuencier.security.browser
    private BrowserProperties browser = new BrowserProperties();
    private SocialProperties social = new SocialProperties();
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
