package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.SupervipInfo;
import com.skyc.demo.user.service.SupervipInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipInfo")
public class SupervipInfoCon {

    @Autowired
    SupervipInfoService supervipInfoService;

    @PostMapping("/insertSuperVIP")
    int insertSuperVIP(@RequestBody SupervipInfo supervipInfo){
        return supervipInfoService.insertSuperVIP(supervipInfo);
    }

    @PostMapping("/updateSuperVIP")
    int updateSuperVIP(@RequestBody SupervipInfo supervipInfo){
        return supervipInfoService.updateSuperVIP(supervipInfo);
    }

}
