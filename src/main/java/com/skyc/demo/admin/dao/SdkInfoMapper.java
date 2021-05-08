package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.SdkInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SdkInfoMapper {

    int insertSdk(SdkInfo skdList);

    List<SdkInfo> selectAll();

    SdkInfo selectById(String id);

    SdkInfo selectBySdk(String sdkNumber);

    int updateSdk(SdkInfo sdkInfo);

}