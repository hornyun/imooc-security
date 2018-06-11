package com.imooc.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/11
 * @copyright: 上海英和
 * @QQ: 583760722
 */
//@Component(value = "imageCodeGenerator")
@Slf4j
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(HttpServletRequest request) {
        log.info("更高级的图形验证码的图形验证码生成器");
        return null;
    }
}
