package com.imooc.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/11
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        log.info("{} send a message = {}", mobile, code);
    }
}
