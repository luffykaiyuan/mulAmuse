package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderInfoCon {

    @Autowired
    OrderInfoService orderInfoService;

    @GetMapping("/selectUserOrder")
    public List<OrderInfo> selectUserOrder(@RequestParam("/userId") String userId){
        return orderInfoService.selectUserOrder(userId);
    }

}
