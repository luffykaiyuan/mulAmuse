package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.CommissionLog;

public interface CommissionLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommissionLog record);

    int insertSelective(CommissionLog record);

    CommissionLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CommissionLog record);

    int updateByPrimaryKey(CommissionLog record);
}