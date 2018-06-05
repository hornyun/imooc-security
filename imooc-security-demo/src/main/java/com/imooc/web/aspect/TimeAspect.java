package com.imooc.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Aspect
@Component
@Slf4j
public class TimeAspect {
    @Pointcut("execution(* com.imooc.web.controller.*Controller.*(..))")
    public void cut() {
    }

    @Around(value = "cut()")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around aspect start");

        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            log.info("arg={}", arg);
        }

        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        log.info("around aspect end,cost time {}", (System.currentTimeMillis() - start));

        return proceed;
    }
}
