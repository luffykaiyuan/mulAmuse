package com.skyc.demo.merchants.service;

import com.skyc.demo.merchants.dao.StoreInfoMapper;
import com.skyc.demo.merchants.po.StoreInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreInfoService {

    @Autowired
    StoreInfoMapper storeInfoMapper;

    @Value("${insertSuc}")
    String insertSuc;
    @Value("${insertFAL}")
    String insertFAL;
    @Value("${updateSuc}")
    String updateSuc;
    @Value("${updateFal}")
    String updateFal;
    @Value("${checkUsername}")
    String checkUsername;
    @Value("${repeatUsername}")
    String repeatUsername;
    @Value("${checkPass}")
    String checkPass;

    public List<StoreInfo> selectAllNormal() {
        return storeInfoMapper.selectAllNormal();
    }

    public List<StoreInfo> selectAllStore() {
        return storeInfoMapper.selectAllStore();
    }

    public StoreInfo selectByUsername(String storeUsername) {
        return storeInfoMapper.selectByUsername(storeUsername);
    }

    public List<StoreInfo> selectById(String id) {
        return storeInfoMapper.selectById(id);
    }

    public String insertStore(StoreInfo storeInfo){
        StoreInfo storeInfoOld = storeInfoMapper.selectByUsername(storeInfo.getStoreUsername());
        if (storeInfoOld == null) {
            storeInfo.setId(UUIDUtils.getUUID(16));
            storeInfo.setAddTime(GetNowDate.getStringDate());
            storeInfoMapper.insertStore(storeInfo);
            return insertSuc;
        }else {
            return repeatUsername;
        }
    }

    public String updateStore(StoreInfo storeInfo){
        int flag = storeInfoMapper.updateStore(storeInfo);
        if (flag > 0){
            return updateSuc;
        }else {
            return updateFal;
        }
    }

    public int deleteStore(String id){
        return storeInfoMapper.deleteStore(id);
    }

    public String loginStore(StoreInfo storeInfo){
        StoreInfo storeInfoOld = storeInfoMapper.selectByUsername(storeInfo.getStoreUsername());
        if (null == storeInfoOld){
            return checkUsername;
        }else {
            if (storeInfoOld.getStorePassword().equals(storeInfo.getStorePassword())){
                return "store";
            }else {
                return checkPass;
            }
        }
    }

}
