package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.UserInfoMapper;
import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.GetRandom;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public int insertUser(UserInfo userInfo){
        userInfo.setId(UUIDUtils.getUUID(16));
        userInfo.setAddTime(GetNowDate.getStringDate());
        userInfo.setUserInvite(GetRandom.getRandomNumber(8));
        return userInfoMapper.insertUser(userInfo);
    }

    public List<UserInfo> selectAllUser(){
        return userInfoMapper.selectAllUser();
    }

    public List<UserInfo> selectAllNormal(){
        return userInfoMapper.selectAllNormal();
    }

    public List<UserInfo> selectUserSons(String fatherId){
        return userInfoMapper.selectUserSons(fatherId);
    }

    public UserInfo selectUerDetail(String id){
        return userInfoMapper.selectUerDetail(id);

    }

    public int updateUser(UserInfo userInfo){
        return userInfoMapper.updateUser(userInfo);
    }

    public int deleteUser(String id){
        return userInfoMapper.deleteUser(id);
    }

    public int updateUserTitle(UserInfo userInfo){
        return userInfoMapper.updateUserTitle(userInfo);
    }

    public int becomeTalent(UserInfo userInfo){
        return userInfoMapper.becomeTalent(userInfo);
    }

}
