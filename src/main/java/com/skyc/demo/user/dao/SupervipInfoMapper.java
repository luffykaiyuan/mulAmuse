package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.SupervipInfo;

public interface SupervipInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupervipInfo record);

    int insertSelective(SupervipInfo record);

    SupervipInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupervipInfo record);

    int updateByPrimaryKey(SupervipInfo record);
}