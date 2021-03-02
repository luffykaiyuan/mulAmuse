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

    List<ProductInfo> selectIndexOneBig();

    List<ProductInfo> selectIndexOneBigShow();

    List<ProductInfo> selectIndexOne();

    List<ProductInfo> selectIndexOneShow();

    List<ProductInfo> selectIndexTwo();

    List<ProductInfo> selectIndexTwoShow();

    List<ProductInfo> selectVipOneShow();

    List<ProductInfo> selectVipTwoShow();

    int updateProduct(ProductInfo productInfo);

    int updateBig(ProductInfo productInfo);

    int updateOne(List<ProductInfo> productInfo);

    int deleteProduct(String id);

    int saleIn(String id);

    int saleOut(String id);

    int addVolume(ProductInfo productInfo);

    int deleteAllProduct(String storeId);
}