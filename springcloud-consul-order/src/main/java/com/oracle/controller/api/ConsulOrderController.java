package com.oracle.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

    private AtomicInteger requestCount = new AtomicInteger(1);

    @RequestMapping("/getOrder")
    public String getOrder() {
        //String forObject = restTemplate.getForObject("http://consul-member/getMember", String.class);
        String url = getUrl("consul-member") + "/getMember";
        System.out.println("url = " + url);
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

    /**
     * @Description: 获取请求的url
     * @Author: admin
     * @Param: []
     * @Return java.lang.String
     **/
    public String getUrl(String serverId) {

        List<ServiceInstance> instances = discoveryClient.getInstances(serverId);
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        //本地负载均衡算法  请求总数取模服务器数量
        int index = requestCount.incrementAndGet() % instances.size();

        return instances.get(index).getUri().toString();

    }


}
