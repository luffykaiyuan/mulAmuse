package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.po.SupervipSet;
import com.skyc.demo.admin.service.SupervipSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipSet")
public class SupervipSetCon {

    @Autowired
    SupervipSetService supervipSetService;

    @GetMapping("/selectSupervipSet")
    public List<SupervipSet> selectSupervipSet(@PathParam("/id") String id){
        return supervipSetService.selectSupervipSet(id);
    }

    @PostMapping("/updateSupervipSet")
    public int updateSupervipSet(@RequestBody SupervipSet supervipSet){
        return supervipSetService.updateSupervipSet(supervipSet);
    }
}
