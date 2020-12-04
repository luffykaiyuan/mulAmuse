package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.SupervipInvite;
import com.skyc.demo.user.service.SupervipInviteService;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/supervipInvite")
public class SupervipInviteCon {

    @Autowired
    SupervipInviteService supervipInviteService;

    @GetMapping("/selectInvite")
    public SupervipInvite selectInvite(@PathParam("/userId") String userId){
        return supervipInviteService.selectInvite(userId);
    }

    @PostMapping("/insertSupervipInvite")
    public int insertSupervipInvite(@RequestBody SupervipInvite supervipInvite){
        supervipInvite.setId(UUIDUtils.getUUID(16));
        return supervipInviteService.insertSupervipInvite(supervipInvite);
    }

    @PostMapping("/updateSupervipInvite")
    public int updateSupervipInvite(@RequestBody SupervipInvite supervipInvite){
        return supervipInviteService.updateSupervipInvite(supervipInvite);
    }

    @PostMapping("/becomeVip")
    public void becomeVip(@RequestBody SupervipInvite supervipInvite) {
        supervipInviteService.becomeVip(supervipInvite);
    }

}
