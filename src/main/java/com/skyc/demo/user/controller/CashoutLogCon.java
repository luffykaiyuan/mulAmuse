package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.CashoutLog;
import com.skyc.demo.user.service.CashoutLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/cashoutLog")
public class CashoutLogCon {

    @Autowired
    CashoutLogService cashoutLogService;

    @GetMapping("/selectUserCashout")
    public List<CashoutLog> selectUserCashout(@PathParam("/userId") String userId){
        return cashoutLogService.selectUserCashout(userId);
    }

    @PostMapping("/insertCashoutLog")
    public int insertCashoutLog(@RequestBody CashoutLog cashoutLog){
        return cashoutLogService.insertCashoutLog(cashoutLog);
    }

}
