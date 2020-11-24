package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.CommissionLogMapper;
import com.skyc.demo.user.po.CommissionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionLogService {

    @Autowired
    CommissionLogMapper commissionLogMapper;

    public List<CommissionLog> selectUserCommissionLog(String getId){
        return commissionLogMapper.selectUserCommissionLog(getId);
    }

}
