package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.CashoutLogMapper;
import com.skyc.demo.user.po.CashoutLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashoutLogService {

    @Autowired
    CashoutLogMapper cashoutLogMapper;

    public List<CashoutLog> selectUserCashout(String userId){
        return cashoutLogMapper.selectUserCashout(userId);
    }

}
