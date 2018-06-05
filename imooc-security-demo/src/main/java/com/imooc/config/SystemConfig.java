package com.imooc.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Configuration
public class SystemConfig extends WebMvcConfigurerAdapter {

    //    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        bean.setFilter(timeFilter);

        ArrayList<String> urls = new ArrayList<>();
        urls.add("/*");
        bean.setUrlPatterns(urls);
        return bean;
    }

    //    @Autowired
    private TimeInterceptor timeInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(timeInterceptor);
//    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(5);
        // 设置最大线程数
        executor.setMaxPoolSize(10);
        // 设置队列容量
        executor.setQueueCapacity(20);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("hello-");
        // 设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
//        configurer.registerDeferredResultInterceptors(); 异步拦截器
//        configurer.registerCallableInterceptors(); 异步拦截器

//        configurer.setDefaultTimeout(1000); 异步超时时间

    }
}
