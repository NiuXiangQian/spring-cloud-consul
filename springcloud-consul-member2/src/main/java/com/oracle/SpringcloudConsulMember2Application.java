package com.oracle
        ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudConsulMember2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsulMember2Application.class, args);
    }

}
