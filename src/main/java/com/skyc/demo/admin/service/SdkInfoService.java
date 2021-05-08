package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.SdkInfoMapper;
import com.skyc.demo.admin.po.SdkInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.SdkUtils;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SdkInfoService {

    @Autowired
    SdkInfoMapper sdkInfoMapper;

    public int insertSdk(){
        for (int i = 0; i < 1000; i++) {
            SdkInfo sdkInfo = new SdkInfo();
            sdkInfo.setId(UUIDUtils.getUUID(16));
            sdkInfo.setSdkNumber(SdkUtils.getSdk(9));
            sdkInfo.setAddTime(GetNowDate.getStringDate());
            sdkInfo.setEndTime("2021-12-30");
            sdkInfoMapper.insertSdk(sdkInfo);
        }
        return 1;
    }

    public List<SdkInfo> selectAll(){
        return sdkInfoMapper.selectAll();
    }

    public SdkInfo selectById(String id){
        return sdkInfoMapper.selectById(id);
    }

    public SdkInfo selectBySdk(String sdkNumber){
        return sdkInfoMapper.selectBySdk(sdkNumber);
    }

    public int updateSdk(SdkInfo sdkInfo){
        return sdkInfoMapper.updateSdk(sdkInfo);
    }
}
