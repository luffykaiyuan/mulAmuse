package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.CashoutLog;
import com.skyc.demo.user.service.CashoutLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashoutLog")
public class CashoutLogCon {

    @Autowired
    CashoutLogService cashoutLogService;

    @GetMapping("/selectUserCashout")
    public List<CashoutLog> selectUserCashout(@RequestParam("/userId") String userId){
        return cashoutLogService.selectUserCashout(userId);
    }

    @PostMapping("/insertCashoutLog")
    public int insertCashoutLog(@RequestBody CashoutLog cashoutLog){
        return cashoutLogService.insertCashoutLog(cashoutLog);
    }

}
