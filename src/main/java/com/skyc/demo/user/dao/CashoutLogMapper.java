package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.CashoutLog;

public interface CashoutLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(CashoutLog record);

    int insertSelective(CashoutLog record);

    CashoutLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CashoutLog record);

    int updateByPrimaryKey(CashoutLog record);
}