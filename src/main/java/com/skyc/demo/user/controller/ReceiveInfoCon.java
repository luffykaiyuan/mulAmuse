package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.ReceiveInfo;
import com.skyc.demo.user.service.ReceiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receiveInfo")
public class ReceiveInfoCon {

    @Autowired
    ReceiveInfoService receiveInfoService;

    @PostMapping("/insertReceive")
    public int insertReceive(@RequestBody ReceiveInfo receiveInfo) {
        return receiveInfoService.insertReceive(receiveInfo);
    }

        @GetMapping("/selectUserReceive")
    public List<ReceiveInfo> selectUserReceive(@RequestParam("/userId") String userId){
        return receiveInfoService.selectUserReceive(userId);
    }

    @GetMapping("/selectReceiveList")
    public List<ReceiveInfo> selectReceiveList(@RequestParam("/userId") String userId){
        return receiveInfoService.selectReceiveList(userId);
    }

    @PostMapping("/updateReceive")
    public int updateReceive(@RequestBody ReceiveInfo receiveInfo){
        return receiveInfoService.updateReceive(receiveInfo);
    }

    @PostMapping("/updateDefaultReceive")
    public int updateDefaultReceive(@RequestBody List<ReceiveInfo> receiveInfo){
        return receiveInfoService.updateDefaultReceive(receiveInfo);
    }
}
