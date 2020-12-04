package com.skyc.demo.merchants.service;

import com.skyc.demo.merchants.dao.ProductInfoMapper;
import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoService {

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Value("${insertSuc}")
    String insertSuc;
    @Value("${insertFAL}")
    String insertFAL;

    public List<ProductInfo> selectProductByStore(String storeId){
        return productInfoMapper.selectProductByStore(storeId);
    }

    public ProductInfo selectProductById(String id){
        return productInfoMapper.selectProductById(id);
    }

    public String insertProduct(ProductInfo productInfo){
        productInfo.setId(UUIDUtils.getUUID(16));
        productInfo.setAddTime(GetNowDate.getStringDate());
        int flag = productInfoMapper.insertProduct(productInfo);
        if (flag > 0){
            return insertSuc;
        }else {
            return insertFAL;
        }
    }

    public int updateProduct(ProductInfo productInfo){
        return productInfoMapper.updateProduct(productInfo);
    }

    public int deleteProduct(String id){
        return productInfoMapper.deleteProduct(id);
    }
}
