package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.ReceiveInfoMapper;
import com.skyc.demo.user.po.ReceiveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiveInfoService {

    @Autowired
    ReceiveInfoMapper receiveInfoMapper;

    public List<ReceiveInfo> selectUserReceive(String userId){
        return receiveInfoMapper.selectUserReceive(userId);
    }

}
