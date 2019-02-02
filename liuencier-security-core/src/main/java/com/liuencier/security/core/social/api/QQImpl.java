package com.liuencier.security.core.social.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.method.P;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    private ObjectMapper objectMapper = new ObjectMapper();
    // qq 需要传递的参数
    private String openId;
    private String appId;

    public QQImpl(String accessToken, String appId) {
        // QQ 所需要的 token 需要在请求体重，而默认为 header 中
        // 自动为请求添加 token 参数
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        // String.format 替换掉 URL_GET_OPENID %s
        String url = String.format(URL_GET_OPENID, accessToken);
        // 获取用户信息
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        // 读取 openId
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        QQUserInfo userInfo = null;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        }catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }
}
