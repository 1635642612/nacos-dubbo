package com.hx.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.hx.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(check = false, group = "group-provider", version = "${demo.service.version}")
    private DemoService demoService;

    @NacosValue(value = "${nacos.test.propertie}", autoRefreshed = true)
    private String testProperties;

    @GetMapping(value = "/service1")
    private String service1() {
        return demoService.service1();
    }

    @GetMapping("/test")
    public String test(){
        return testProperties;
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }

}