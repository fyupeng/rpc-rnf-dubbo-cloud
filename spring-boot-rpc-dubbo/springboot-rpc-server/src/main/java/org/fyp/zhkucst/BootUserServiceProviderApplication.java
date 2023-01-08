package org.fyp.zhkucst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

//@EnableDubbo
//@ImportResource(locations="classpath:provider.xml")
@EnableDubbo(scanBasePackages = "org.fyp.zhkucst")
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }
}
