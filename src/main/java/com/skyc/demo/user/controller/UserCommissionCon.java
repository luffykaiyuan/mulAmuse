package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.UserCommission;
import com.skyc.demo.user.service.UserCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/userCom")
public class UserCommissionCon {

    @Autowired
    UserCommissionService userCommissionService;

    @GetMapping("/selectUserCommission")
    public UserCommission selectUserCommission(@PathParam("/userId") String userId){
        return userCommissionService.selectUserCommission(userId);
    }
}
