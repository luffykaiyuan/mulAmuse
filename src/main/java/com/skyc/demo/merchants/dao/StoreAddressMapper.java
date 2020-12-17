package com.skyc.demo.merchants.dao;

import com.skyc.demo.merchants.po.StoreAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface StoreAddressMapper {

    int insertAddress(StoreAddress storeAddress);

    StoreAddress selectById(String id);

    List<StoreAddress> selectAllByStoreId(String storeId);

    List<StoreAddress> selectAllNormal(String storeId);

    int updateAddress(StoreAddress storeAddress);

    int deleteAddress(String id);

}