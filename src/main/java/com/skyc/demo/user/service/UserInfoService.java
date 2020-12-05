package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.SupervipInviteMapper;
import com.skyc.demo.user.dao.UserCommissionMapper;
import com.skyc.demo.user.dao.UserInfoMapper;
import com.skyc.demo.user.po.SupervipInvite;
import com.skyc.demo.user.po.UserCommission;
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

    @Autowired
    UserCommissionMapper userCommissionMapper;

    @Autowired
    SupervipInviteMapper supervipInviteMapper;

    public int insertUser(UserInfo userInfo){
        String userId = UUIDUtils.getUUID(16);
        userInfo.setId(userId);
        userInfo.setAddTime(GetNowDate.getStringDate());
        userInfo.setUserInvite(GetRandom.getRandomNumber(8));
        //佣金信息表的数据添加
        UserCommission userCommission = new UserCommission();
        userCommission.setId(UUIDUtils.getUUID(16));
        userCommission.setUserId(userId);
        userCommissionMapper.insertCommission(userCommission);
        //超级VIP邀请表添加数据
        SupervipInvite supervipInvite = new SupervipInvite();
        supervipInvite.setId(UUIDUtils.getUUID(16));
        supervipInvite.setUserId(userId);
        supervipInviteMapper.insertSupervipInvite(supervipInvite);
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

    public List<UserInfo> selectUerByUsername(String userName){
        return userInfoMapper.selectUerByUsername(userName);
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
