package com.provider.service;

import com.hx.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Service注解为dubbo的注解与spring的区分开来。group和version使用一个就可以了，group为duboo注册服务到nacos的服务名，
 * 可以在nacos管理界面查看。名字根据properties的dubbo.application.name决定。version则可以自己在properties自定义，
 * 注意生产者和消费者的version一定要一致才可以调用服务。group也是同样。
 */
@Service(group = "group-provider", version = "${demo.service.version}")
public class DefaultDemoService implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @Override
    public String service1() {
        return "调用了provider的service1";
    }
}