package com.skyc.demo.user.controller;

import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoCon {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/insertUser")
    public int insertUser(@RequestBody UserInfo userInfo){
        return userInfoService.insertUser(userInfo);
    }

    @GetMapping("/selectAllUser")
    public List<UserInfo> selectAllUser(){
        return userInfoService.selectAllUser();
    }

    @GetMapping("/selectAllNormal")
    public List<UserInfo> selectAllNormal(){
        return userInfoService.selectAllNormal();
    }

    @GetMapping("/selectUserSons")
    public List<UserInfo> selectUserSons(@RequestParam("/fatherId") String fatherId){
        return userInfoService.selectUserSons(fatherId);
    }

    @GetMapping("/selectById")
    public UserInfo selectUerDetail(@RequestParam("/id") String id){
        return userInfoService.selectUerDetail(id);

    }

    @PostMapping("/updateUser")
    public int updateUser(@RequestBody UserInfo userInfo){
        return userInfoService.updateUser(userInfo);

    }

    @PostMapping("/updateUserTitle")
    public int updateUserTitle(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserTitle(userInfo);
    }

    @PostMapping("/becomeTalent")
    public int becomeTalent(@RequestBody UserInfo userInfo){
        return userInfoService.becomeTalent(userInfo);
    }

    //备用方法，通过id删除用户信息
    public int deleteUser(@RequestParam("/id") String id){
        return userInfoService.deleteUser(id);
    }
}
