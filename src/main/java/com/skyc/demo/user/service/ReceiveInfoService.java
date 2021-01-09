package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.ReceiveInfoMapper;
import com.skyc.demo.user.po.ReceiveInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveInfoService {

    @Autowired
    ReceiveInfoMapper receiveInfoMapper;

    public String insertReceive(ReceiveInfo receiveInfo){
        String id = UUIDUtils.getUUID(16);
        receiveInfo.setId(id);
        receiveInfo.setAddTime(GetNowDate.getStringDate());
        receiveInfoMapper.insertReceive(receiveInfo);
        return id;
    }

    public List<ReceiveInfo> selectById(String id){
        return receiveInfoMapper.selectById(id);
    }

    public List<ReceiveInfo> selectUserReceive(String userId){
        return receiveInfoMapper.selectUserReceive(userId);
    }

    public List<ReceiveInfo> selectReceiveList(String userId){
        List<ReceiveInfo> defaultList = receiveInfoMapper.selectDefaultReceive(userId);
        List<ReceiveInfo> otherList = receiveInfoMapper.selectOtherReceive(userId);
        defaultList.addAll(otherList);
        return defaultList;
    }

    public int updateReceive(ReceiveInfo receiveInfo){
        return receiveInfoMapper.updateReceive(receiveInfo);
    }

    public int updateDefaultReceive(List<ReceiveInfo> receiveInfo){
        return receiveInfoMapper.updateDefaultReceive(receiveInfo);
    }
}
