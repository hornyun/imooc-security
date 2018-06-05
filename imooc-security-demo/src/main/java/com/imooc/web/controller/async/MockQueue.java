package com.imooc.web.controller.async;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Slf4j
@Component
public class MockQueue implements Serializable {
    private String placeOrder;

    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    @SuppressWarnings("all")
    @Async
    public void setPlaceOrder(String placeOrder) throws InterruptedException {

        new Thread(() -> {
            log.info("accept a message of order:{}", placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            log.info("order have been done:{}", placeOrder);

        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }

}
