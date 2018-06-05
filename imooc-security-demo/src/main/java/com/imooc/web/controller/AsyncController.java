package com.imooc.web.controller;

import com.imooc.web.controller.async.DeferredResultHolder;
import com.imooc.web.controller.async.MockQueue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@RestController
@Slf4j
public class AsyncController {

    @GetMapping("/order")
    public Callable<String> order() {
        log.info("main thread start .......");
        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("second thread start");
                Thread.sleep(1000);
                log.info("second thread end");
                return "success";
            }
        };

        log.info("main thread end .......");

        return result;
    }

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/order/type")
    public DeferredResult<String> orderSpace() throws InterruptedException {
        log.info("main thread start");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        log.info("main thread end");

        return result;
    }
}
