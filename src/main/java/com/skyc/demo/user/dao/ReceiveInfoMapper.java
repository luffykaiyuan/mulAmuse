package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.ReceiveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReceiveInfoMapper {

    int insertReceive(ReceiveInfo receiveInfo);

    List<ReceiveInfo> selectById(String id);

    List<ReceiveInfo> selectOtherReceive(String userId);

    List<ReceiveInfo> selectDefaultReceive(String userId);

    List<ReceiveInfo> selectUserReceive(String userId);

    int updateReceive(ReceiveInfo receiveInfo);

    int updateDefaultReceive(List<ReceiveInfo> receiveInfo);

}