package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.SupervipSet;

public interface SupervipSetMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupervipSet record);

    int insertSelective(SupervipSet record);

    SupervipSet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupervipSet record);

    int updateByPrimaryKey(SupervipSet record);
}