package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.po.SupervipSet;
import com.skyc.demo.admin.service.SupervipSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipSet")
public class SupervipSetCon {

    @Autowired
    SupervipSetService supervipSetService;

    @RequestMapping("/selectAllSet")
    public List<SupervipSet> selectAllSet(){
        return supervipSetService.selectAllSet();
    }
}
