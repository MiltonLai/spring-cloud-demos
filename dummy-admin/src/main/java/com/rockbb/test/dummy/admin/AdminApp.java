package com.rockbb.test.dummy.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * Attach to discovery service without registering itself
 * @EnableDiscoveryClient is unnecessary if it needs to be registered
*/
@EnableDiscoveryClient(autoRegister=false)
/*
 * List the packages from which FeignClients need to be injected
 */
@EnableFeignClients(basePackages = {
        "com.rockbb.test.dummy.common.api",
        "com.rockbb.test.dummy.file.api"
})
@SpringBootApplication
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

}