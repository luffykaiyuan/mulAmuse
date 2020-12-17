package com.skyc.demo.merchants.service;

import com.skyc.demo.merchants.dao.StoreAddressMapper;
import com.skyc.demo.merchants.po.StoreAddress;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreAddressService {

    @Autowired
    StoreAddressMapper storeAddressMapper;

    public int insertAddress(StoreAddress storeAddress){
        storeAddress.setId(UUIDUtils.getUUID(16));
        storeAddress.setAddTime(GetNowDate.getDetailStringDate());
        return storeAddressMapper.insertAddress(storeAddress);
    }

    public StoreAddress selectById(String id){
        return storeAddressMapper.selectById(id);
    }

    public List<StoreAddress> selectAllByStoreId(String storeId){
        return storeAddressMapper.selectAllByStoreId(storeId);
    }

    public List<StoreAddress> selectAllNormal(String storeId){
        return storeAddressMapper.selectAllNormal(storeId);
    }

    public int updateAddress(StoreAddress storeAddress){
        return storeAddressMapper.updateAddress(storeAddress);
    }

    public int deleteAddress(String id){
        return storeAddressMapper.deleteAddress(id);
    }
}
