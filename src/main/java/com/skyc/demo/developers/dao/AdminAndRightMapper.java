package com.skyc.demo.developers.dao;

import com.skyc.demo.developers.po.AdminAndRight;

public interface AdminAndRightMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminAndRight record);

    int insertSelective(AdminAndRight record);

    AdminAndRight selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminAndRight record);

    int updateByPrimaryKey(AdminAndRight record);
}