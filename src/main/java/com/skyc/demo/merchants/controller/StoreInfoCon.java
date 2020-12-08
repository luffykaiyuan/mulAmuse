package com.skyc.demo.merchants.controller;

import com.skyc.demo.merchants.po.StoreInfo;
import com.skyc.demo.merchants.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/store")
public class StoreInfoCon {

    @Autowired
    StoreInfoService storeInfoService;

    @GetMapping("/selectAllNormal")
    public List<StoreInfo> selectAllNormal() {
        return storeInfoService.selectAllNormal();
    }

    @GetMapping("/selectAllStore")
    public List<StoreInfo> selectAllStore() {
        return storeInfoService.selectAllStore();
    }

    @GetMapping("/selectByUsername")
    public StoreInfo selectByUsername(@PathParam("/storeUsername") String storeUsername) {
        return storeInfoService.selectByUsername(storeUsername);
    }

    @GetMapping("/selectById")
    public List<StoreInfo> selectById(@PathParam("/id") String id) {
        return storeInfoService.selectById(id);
    }

    @PostMapping("/insertStore")
    public String insertStore(@RequestBody StoreInfo storeInfo){
        return storeInfoService.insertStore(storeInfo);
    }

    @PostMapping("/updateStore")
    public String updateStore(@RequestBody StoreInfo storeInfo){
        return storeInfoService.updateStore(storeInfo);
    }

    @GetMapping("/deleteStore")
    public int deleteStore(@PathParam("/id") String id){
        return storeInfoService.deleteStore(id);
    }

    @PostMapping("/loginStore")
    public String loginStore(@RequestBody StoreInfo storeInfo){
        return storeInfoService.loginStore(storeInfo);
    }

}
