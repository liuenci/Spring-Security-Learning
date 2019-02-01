package com.liuencier.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 */
public interface ValidateCodeProcessor {
    // 验证码放入 session 时的前缀
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 检验校验码
     */
    void validate(ServletWebRequest servletWebRequest) throws ValidateCodeException;
}
