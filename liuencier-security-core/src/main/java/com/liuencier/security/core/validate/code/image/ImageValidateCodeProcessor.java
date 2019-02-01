package com.liuencier.security.core.validate.code.image;

import com.liuencier.security.core.validate.code.ValidateCode;
import com.liuencier.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.stereotype.Component;

/**
 * 图形验证码处理器
 */
@Component("imageValidateCodeProcessor")
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {


}
