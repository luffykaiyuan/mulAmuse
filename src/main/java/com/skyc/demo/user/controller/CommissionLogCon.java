package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.CommissionLog;
import com.skyc.demo.user.service.CommissionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/comLog")
public class CommissionLogCon {

    @Autowired
    CommissionLogService commissionLogService;

    @GetMapping("/selectUserCommissionLog")
    List<CommissionLog> selectUserCommissionLog(@PathParam("getId") String getId){
        return commissionLogService.selectUserCommissionLog(getId);
    }

}
