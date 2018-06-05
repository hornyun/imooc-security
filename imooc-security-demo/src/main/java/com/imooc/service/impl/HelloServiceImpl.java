package com.imooc.service.impl;

import com.imooc.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        log.info("【{}】",this.getClass()+ " greeting method is executing");
        return "hello " + name;
    }
}
