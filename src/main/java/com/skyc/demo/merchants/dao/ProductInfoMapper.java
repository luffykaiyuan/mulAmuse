package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductInfoMapper {

    int insertProduct(ProductInfo productInfo);

    List<ProductInfo> selectProductByStore(String storeId);

    ProductInfo selectProductById(String id);

    int updateProduct(ProductInfo productInfo);

    int deleteProduct(String id);
}