package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.ReceiveInfo;
import com.skyc.demo.user.service.ReceiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/receiveInfo")
public class ReceiveInfoCon {

    @Autowired
    ReceiveInfoService receiveInfoService;

    @GetMapping("/selectUserReceive")
    public List<ReceiveInfo> selectUserReceive(@RequestParam("/userId") String userId){
        return receiveInfoService.selectUserReceive(userId);
    }
}
