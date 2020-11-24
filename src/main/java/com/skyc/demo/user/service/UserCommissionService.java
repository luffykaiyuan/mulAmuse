package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.UserCommissionMapper;
import com.skyc.demo.user.po.UserCommission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommissionService {

    @Autowired
    UserCommissionMapper userCommissionMapper;

    public UserCommission selectUserCommission(String userId){
        return userCommissionMapper.selectUserCommission(userId);
    }

}
