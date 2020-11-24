package com.skyc.demo.merchants.service;

import com.skyc.demo.merchants.dao.ModelInfoMapper;
import com.skyc.demo.merchants.po.ModelInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelInfoService {

    @Autowired
    ModelInfoMapper modelInfoMapper;

    public int insertModel(ModelInfo modelInfo){
        modelInfo.setId(UUIDUtils.getUUID(16));
        modelInfo.setAddTime(GetNowDate.getStringDate());
        return modelInfoMapper.insertModel(modelInfo);
    }

    public List<ModelInfo> selectModelByProduct(String productId){
        return modelInfoMapper.selectModelByProduct(productId);
    }

    public int updateModel(ModelInfo modelInfo){
        return modelInfoMapper.updateModel(modelInfo);
    }

    public int deleteModel(String id){
        return modelInfoMapper.deleteModel(id);
    }
}
