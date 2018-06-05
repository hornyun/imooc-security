package com.imooc.web.controller.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener {
    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    @SuppressWarnings("all")
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //spring 容器初始化完毕时间
        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotEmpty(mockQueue.getCompleteOrder())) {
                    String orderNumber = mockQueue.getCompleteOrder();
                    log.info("【返回订单处理结果】" + orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("Place order success");

                    mockQueue.setCompleteOrder(null);

                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
