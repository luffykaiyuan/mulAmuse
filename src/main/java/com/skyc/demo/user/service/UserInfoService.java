package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.UserInfoMapper;
import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public int insertUser(UserInfo userInfo){
        userInfo.setId(UUIDUtils.getUUID(16));
        userInfo.setAddTime(GetNowDate.getStringDate());
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

    public UserInfo selectById(String id){
        return userInfoMapper.selectById(id);

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
}
