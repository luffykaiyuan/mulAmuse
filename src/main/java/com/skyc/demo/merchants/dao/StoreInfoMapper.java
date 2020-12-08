package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StoreInfoMapper {

    List<StoreInfo> selectAllNormal();

    List<StoreInfo> selectAllStore();

    StoreInfo selectByUsername(String storeUsername);

    List<StoreInfo> selectById(String id);

    int insertStore(StoreInfo storeInfo);

    int updateStore(StoreInfo storeInfo);

    int deleteStore(String id);

}