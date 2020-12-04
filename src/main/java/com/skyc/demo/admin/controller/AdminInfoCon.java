package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.po.AdminInfo;
import com.skyc.demo.admin.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminInfoCon {

    @Autowired
    AdminInfoService adminInfoService;

    @PostMapping("/insertAdmin")
    public String insertAdmin(@RequestBody AdminInfo adminInfo){
        return adminInfoService.insertAdmin(adminInfo);
    }

    @GetMapping("/selectAllAdmin")
    public List<AdminInfo> selectAllAdmin(){
        return adminInfoService.selectAllAdmin();
    }

    @PostMapping("/updateAdmin")
    public int updateAdmin(@RequestBody AdminInfo adminInfo){
        return adminInfoService.updateAdmin(adminInfo);
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestBody AdminInfo adminInfo){
        return adminInfoService.changePassword(adminInfo);
    }

    @GetMapping("/deleteAdmin")
    public int deleteAdmin(@PathParam("/id") String id){
        return adminInfoService.deleteAdmin(id);
    }

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestBody AdminInfo adminInfo){
        return adminInfoService.loginAdmin(adminInfo);
    }


    @GetMapping("/selectByUsername")
    public AdminInfo selectByUsername(@PathParam("/adminUsername") String adminUsername){
        return adminInfoService.selectByUsername(adminUsername);
    }

    //备用方法，通过id查询管理员信息
    @GetMapping("/selectById")
    public AdminInfo selectById(@PathParam("/id") String id){
        return adminInfoService.selectById(id);
    }
}
