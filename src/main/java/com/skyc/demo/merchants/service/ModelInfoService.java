package com.skyc.demo.merchants.service;

import com.skyc.demo.merchants.dao.ModelInfoMapper;
import com.skyc.demo.merchants.dao.ProductInfoMapper;
import com.skyc.demo.merchants.po.ModelInfo;
import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelInfoService {

    @Autowired
    ModelInfoMapper modelInfoMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    public int insertModel(ModelInfo modelInfo){
        modelInfo.setId(UUIDUtils.getUUID(16));
        modelInfo.setAddTime(GetNowDate.getStringDate());
        return modelInfoMapper.insertModel(modelInfo);
    }

    public List<ModelInfo> selectModelByProduct(String productId){
        return modelInfoMapper.selectModelByProduct(productId);
    }

    public ModelInfo selectOneModel(String id){
        return modelInfoMapper.selectOneModel(id);
    }

    public int updateModel(ModelInfo modelInfo){
        int flag = modelInfoMapper.updateModel(modelInfo);
        checkStock(modelInfo.getProductId());
        return flag;
    }

    public void checkStock(String productId){
        List<ModelInfo> modelInfoList = modelInfoMapper.selectModelByProduct(productId);
        for (int i = 0; i < modelInfoList.size(); i++) {
            if (modelInfoList.get(i).getModelStock() > 0){
                productInfoMapper.saleIn(productId);
                break;
            }else {
                if (i == modelInfoList.size() - 1){
                    productInfoMapper.saleOut(productId);
                }else {
                    continue;
                }
            }
        }
    }

    public int deleteModel(String id){
        return modelInfoMapper.deleteModel(id);
    }
}
