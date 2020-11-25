package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/selectStoreOrder")
    public List<OrderInfo> selectStoreOrder(@RequestParam("/storeId") String storeId){
        return orderInfoService.selectStoreOrder(storeId);
    }

    @GetMapping("/selectOrderDetail")
    public OrderInfo selectOrderDetail(@RequestParam("/id") String id){
        return orderInfoService.selectOrderDetail(id);
    }

    @PostMapping("/sendProduct")
    public String sendProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.sendProduct(orderInfo);
    }

    @PostMapping("/destoryCodeNumber")
    public String destoryCodeNumber(@RequestParam("/qrcodeNumber") String qrcodeNumber){
        return orderInfoService.destoryCodeNumber(qrcodeNumber);
    }

    @PostMapping("/getProduct")
    public int getProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.getProduct(orderInfo);
    }

}
