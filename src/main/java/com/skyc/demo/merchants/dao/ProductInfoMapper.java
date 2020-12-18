package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.user.po.FreeLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductInfoMapper {

    int insertProduct(ProductInfo productInfo);

    List<ProductInfo> selectProductByStore(String storeId);

    List<ProductInfo> selectIndexProductByStore(String storeId);

    List<ProductInfo> selectSuperProductByStore(String storeId);

    ProductInfo selectProductById(String id);

    List<ProductInfo> selectIndexProduct();

    List<ProductInfo> selectSuperProduct(List<FreeLog> list);

    int updateProduct(ProductInfo productInfo);

    int deleteProduct(String id);

    int saleIn(String id);

    int saleOut(String id);
}