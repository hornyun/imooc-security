package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/11
 * @copyright: 上海英和
 * @QQ: 583760722
 */
public interface ValidateCodeGenerator {
    /**
     * 生产图片的接口
     *
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
