package com.oracle.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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


    @RequestMapping("/getOrder")
    public String getOrder() {
        String forObject = restTemplate.getForObject("http://consul-member/getMember", String.class);
        System.out.println("forObject = " + forObject);

        return forObject;
    }


}
