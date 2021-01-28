package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.po.SupervipInfo;
import com.skyc.demo.user.service.SupervipInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipInfo")
public class SupervipInfoCon {

    @Autowired
    SupervipInfoService supervipInfoService;

    @PostMapping("/insertSuperVIP")
    int insertSuperVIP(@RequestBody SupervipInfo supervipInfo) throws Exception {
        return supervipInfoService.insertSuperVIP(supervipInfo);
    }

    @PostMapping("/checkOrder")
    public boolean checkOrder(@RequestBody OrderInfo orderInfo, HttpServletRequest request){
        return supervipInfoService.checkOrder(orderInfo, request);
    }

    @PostMapping("/updateSuperVIP")
    int updateSuperVIP(@RequestBody SupervipInfo supervipInfo){
        return supervipInfoService.updateSuperVIP(supervipInfo);
    }

    @GetMapping("/selectByUserId")
    public SupervipInfo selectByUserId(@PathParam("/userId") String userId){
        return supervipInfoService.selectByUserId(userId);
    }

    @GetMapping("/overVip")
    public int overVip(@PathParam("/userId") String userId){
        return supervipInfoService.overVip(userId);
    }
}
