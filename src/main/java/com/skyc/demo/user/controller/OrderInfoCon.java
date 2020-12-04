package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderInfoCon {

    @Autowired
    OrderInfoService orderInfoService;

    @PostMapping("/insertOrder")
    public String insertOrder(@RequestBody OrderInfo orderInfo) throws Exception{
        return orderInfoService.insertOrder(orderInfo);
    }

    @GetMapping("/selectAllNormal")
    public List<OrderInfo> selectAllNormal(){
        return orderInfoService.selectAllNormal();
    }

    @GetMapping("/selectUserOrder")
    public List<OrderInfo> selectUserOrder(@PathParam("/userId") String userId){
        return orderInfoService.selectUserOrder(userId);
    }

    @GetMapping("/selectStoreOrder")
    public List<OrderInfo> selectStoreOrder(@PathParam("/storeId") String storeId){
        return orderInfoService.selectStoreOrder(storeId);
    }

    @GetMapping("/selectOrderDetail")
    public OrderInfo selectOrderDetail(@PathParam("/id") String id){
        return orderInfoService.selectOrderDetail(id);
    }

    @PostMapping("/sendProduct")
    public String sendProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.sendProduct(orderInfo);
    }

    @PostMapping("/destoryCodeNumber")
    public String destoryCodeNumber(@PathParam("/qrcodeNumber") String qrcodeNumber){
        return orderInfoService.destoryCodeNumber(qrcodeNumber);
    }

    @PostMapping("/getProduct")
    public int getProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.getProduct(orderInfo);
    }

}
