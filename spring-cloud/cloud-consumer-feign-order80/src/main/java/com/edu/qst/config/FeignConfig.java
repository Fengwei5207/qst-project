package com.edu.qst.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

//    Feign重试策略
    @Bean
    public Retryer myRetryer() {
        return Retryer.NEVER_RETRY; //Feign默认配置是不走重试策略的
        //最大请求次数为3(1+2)，初始间s隔时间为100ms，重试间最大间隔时间为1s
//        return new Retryer.Default(100, 1, 3);
    }

//    Feign日志打印
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
