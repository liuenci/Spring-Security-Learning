package com.liuencier.security.core.social.config;

import com.liuencier.security.core.properties.SecurityProperties;
import com.liuencier.security.core.social.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

@Configuration
// 此注解是为当 liuencier.social.qq.app-id 下有值的时候才起作用
public class QQAutoConfig extends SocialAutoConfigurerAdapter {


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(securityProperties.getSocial().getQq().getProviderId(), securityProperties.getSocial().getQq().getAppId(), securityProperties.getSocial().getQq().getAppSecret());
    }
}
