package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.po.SupervipMore;
import com.skyc.demo.admin.service.SupervipMoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipMore")
public class SupervipMoreCon {

    @Autowired
    SupervipMoreService supervipMoreService;

    @GetMapping("/selectAllMore")
    public List<SupervipMore> selectAllMore(){
        return supervipMoreService.selectAllMore();
    }
}
