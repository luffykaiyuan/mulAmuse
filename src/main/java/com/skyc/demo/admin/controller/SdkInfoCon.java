package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.po.SdkInfo;
import com.skyc.demo.admin.service.SdkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/sdkInfo")
public class SdkInfoCon {

    @Autowired
    SdkInfoService sdkInfoService;

    @GetMapping("/insertSdk")
    public int insertSdk(){
        return sdkInfoService.insertSdk();
    }

    @GetMapping("/selectAll")
    public List<SdkInfo> selectAll(){
        return sdkInfoService.selectAll();
    }

    @GetMapping("/selectById")
    public SdkInfo selectById(@PathParam("/id") String id){
        return sdkInfoService.selectById(id);
    }

    @GetMapping("/selectBySdk")
    public SdkInfo selectBySdk(@PathParam("/sdkNumber") String sdkNumber){
        return sdkInfoService.selectBySdk(sdkNumber);
    }

    @PostMapping("/updateSdk")
    public int updateSdk(@RequestBody SdkInfo sdkInfo){
        return sdkInfoService.updateSdk(sdkInfo);
    }
}
