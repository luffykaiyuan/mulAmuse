package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.CommissionLog;
import com.skyc.demo.user.service.CommissionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comLog")
public class CommissionLogCon {

    @Autowired
    CommissionLogService commissionLogService;

    @GetMapping("/selectUserCommissionLog")
    List<CommissionLog> selectUserCommissionLog(@RequestParam("getId") String getId){
        return commissionLogService.selectUserCommissionLog(getId);
    }

}
