package com.skyc.demo.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 路由控制类
 * @author luffykaiyuan
 * @date 2020/11/22 11:34
 * @return
 */
@Controller
public class RouteCon {

    @RequestMapping("/uploadTest")
    public String entryTest(){
        return "test/uploadTest";
    }

    @RequestMapping("/commissionTest")
    public String entryCommissionTest(){
        return "test/commissionTest";
    }

    @RequestMapping("/wxLoginTest")
    public String entryWxLoginTest(){
        return "test/wxLoginTest";
    }

    @RequestMapping("/wxBack")
    public String entryWxBack(){
        return "test/wxBack";
    }

}
