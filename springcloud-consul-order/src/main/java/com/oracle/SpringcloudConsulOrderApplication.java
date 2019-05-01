package com.oracle
        ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudConsulOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsulOrderApplication.class, args);
    }

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
