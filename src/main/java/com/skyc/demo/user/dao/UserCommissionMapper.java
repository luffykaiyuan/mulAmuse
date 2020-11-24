package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.UserCommission;

public interface UserCommissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserCommission record);

    int insertSelective(UserCommission record);

    UserCommission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserCommission record);

    int updateByPrimaryKey(UserCommission record);
}