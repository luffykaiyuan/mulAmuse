package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.CashoutLogMapper;
import com.skyc.demo.user.dao.CommissionLogMapper;
import com.skyc.demo.user.po.CashoutLog;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashoutLogService {

    @Autowired
    CashoutLogMapper cashoutLogMapper;

    @Autowired
    CommissionLogMapper commissionLogMapper;

    public List<CashoutLog> selectUserCashout(String userId){
        return cashoutLogMapper.selectUserCashout(userId);
    }

    public int insertCashoutLog(CashoutLog cashoutLog){
        cashoutLog.setId(UUIDUtils.getUUID(16));
        cashoutLog.setAddTime(GetNowDate.getStringDate());
        commissionLogMapper.cashoutFinish(cashoutLog.getUserId());
        return cashoutLogMapper.insertCashoutLog(cashoutLog);
    }
}
