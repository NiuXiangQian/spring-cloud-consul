package com.oracle.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description: consul会员控制器
 * @Author: admin
 * @CreateDate: 2019/4/30 11:44
 * @UpdateUser: admin
 * @UpdateDate: 2019/4/30 11:44
 * @UpdateRemark:
 * @Version: 1.0
 **/
@RestController
public class ConsulOrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String forObject = restTemplate.getForObject("http://consul-member/getMember", String.class);
        System.out.println("forObject = " + forObject);
        //获取服务器信息
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-member");
        for (ServiceInstance instance : instances) {
            System.out.println("instance.getHost() = " + instance.getHost());
            System.out.println("instance.getScheme() = " + instance.getScheme());
            System.out.println("instance.getUri() = " + instance.getUri());
            System.out.println("instance.getServiceId() = " + instance.getServiceId());
            System.out.println("instance.getPort() = " + instance.getPort());
            System.out.println("instance.getMetadata() = " + instance.getMetadata());
        }

        return forObject;
    }


}
