package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.ModelInfo;

public interface ModelInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(ModelInfo record);

    int insertSelective(ModelInfo record);

    ModelInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ModelInfo record);

    int updateByPrimaryKey(ModelInfo record);
}