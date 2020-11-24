package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.ReceiveInfo;

public interface ReceiveInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReceiveInfo record);

    int insertSelective(ReceiveInfo record);

    ReceiveInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReceiveInfo record);

    int updateByPrimaryKey(ReceiveInfo record);
}