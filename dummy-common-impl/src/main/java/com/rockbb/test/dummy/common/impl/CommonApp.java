package com.rockbb.test.dummy.common.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * List the packages from which FeignClients need to be injected
 */
@EnableFeignClients(basePackages = {
        "com.rockbb.test.dummy.file.api"
})
@SpringBootApplication
public class CommonApp {

    public static void main(String[] args) {
        SpringApplication.run(CommonApp.class, args);
    }

}
