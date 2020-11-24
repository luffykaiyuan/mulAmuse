package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.ModelInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ModelInfoMapper {

    int insertModel(ModelInfo modelInfo);

    List<ModelInfo> selectModelByProduct(String productId);

    int updateModel(ModelInfo modelInfo);

    int deleteModel(String id);

}