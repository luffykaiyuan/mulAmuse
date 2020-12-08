package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.ReceiveInfo;
import com.skyc.demo.user.service.ReceiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/receiveInfo")
public class ReceiveInfoCon {

    @Autowired
    ReceiveInfoService receiveInfoService;

    @PostMapping("/insertReceive")
    public int insertReceive(@RequestBody ReceiveInfo receiveInfo) {
        return receiveInfoService.insertReceive(receiveInfo);
    }

    @GetMapping("/selectById")
    public List<ReceiveInfo> selectById(@PathParam("/id") String id){
        return receiveInfoService.selectById(id);
    }

    @GetMapping("/selectUserReceive")
    public List<ReceiveInfo> selectUserReceive(@PathParam("/userId") String userId){
        return receiveInfoService.selectUserReceive(userId);
    }

    @GetMapping("/selectReceiveList")
    public List<ReceiveInfo> selectReceiveList(@PathParam("/userId") String userId){
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
