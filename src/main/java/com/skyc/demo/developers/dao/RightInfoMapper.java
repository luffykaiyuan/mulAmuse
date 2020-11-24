package com.skyc.demo.developers.dao;

import com.skyc.demo.developers.po.RightInfo;

public interface RightInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(RightInfo record);

    int insertSelective(RightInfo record);

    RightInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RightInfo record);

    int updateByPrimaryKey(RightInfo record);
}