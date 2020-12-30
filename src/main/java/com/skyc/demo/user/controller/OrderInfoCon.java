package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @PostMapping("/insertFreeOrder")
    public String insertFreeOrder(@RequestBody OrderInfo orderInfo) throws Exception{
        return orderInfoService.insertFreeOrder(orderInfo);
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

    @GetMapping("/selectStoreNetOrder")
    public List<OrderInfo> selectStoreNetOrder(@PathParam("/storeId") String storeId){
        return orderInfoService.selectStoreNetOrder(storeId);
    }

    @GetMapping("/selectStoreRealOrder")
    public List<OrderInfo> selectStoreRealOrder(@PathParam("/storeId") String storeId){
        return orderInfoService.selectStoreRealOrder(storeId);
    }

    @GetMapping("/selectStoreAppointOrder")
    public List<OrderInfo> selectStoreAppointOrder(@PathParam("/storeId") String storeId){
        return orderInfoService.selectStoreAppointOrder(storeId);
    }

    @GetMapping("/selectOrderByNum")
    public List<OrderInfo> selectOrderByNum(@PathParam("/orderNumber") String orderNumber){
        return orderInfoService.selectOrderByNum(orderNumber);
    }

    @GetMapping("/selectOrderDetail")
    public OrderInfo selectOrderDetail(@PathParam("/id") String id){
        return orderInfoService.selectOrderDetail(id);
    }

    @PostMapping("/sendProduct")
    public String sendProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.sendProduct(orderInfo);
    }

    @GetMapping("/destoryCodeNumber")
    public String destoryCodeNumber(@PathParam("/qrcodeNumber") String qrcodeNumber){
        return orderInfoService.destoryCodeNumber(qrcodeNumber);
    }

    @PostMapping("/checkTime")
    public int checkTime(@RequestBody OrderInfo orderInfo){
        return orderInfoService.checkTime(orderInfo);
    }

    @PostMapping("/getProduct")
    public int getProduct(@RequestBody OrderInfo orderInfo){
        return orderInfoService.getProduct(orderInfo);
    }

    @PostMapping("/checkOrder")
    public int checkOrder(@RequestBody OrderInfo orderInfo, HttpServletRequest request){
        HttpSession session = request.getSession();
        String orderPrice = String.valueOf( (int) (orderInfo.getOrderPrice() * 100));
        session.setAttribute("orderPrice", orderPrice);
        session.setAttribute("openid", orderInfo.getOpenid());
        return 1;
    }

}
