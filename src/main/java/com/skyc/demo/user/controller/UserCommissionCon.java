package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.UserCommission;
import com.skyc.demo.user.service.UserCommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userCom")
public class UserCommissionCon {

    @Autowired
    UserCommissionService userCommissionService;

    @GetMapping("/selectUserCommission")
    public UserCommission selectUserCommission(@RequestParam("/userId") String userId){
        return userCommissionService.selectUserCommission(userId);
    }
}
