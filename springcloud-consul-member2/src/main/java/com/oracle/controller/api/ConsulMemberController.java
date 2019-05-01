package com.oracle.controller.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class ConsulMemberController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getMember")
    public String getMember() {
        return "掉啦....:" + port;
    }


}
