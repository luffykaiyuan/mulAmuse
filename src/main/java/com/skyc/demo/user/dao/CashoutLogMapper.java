package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.CashoutLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CashoutLogMapper {

    int insertCashoutLog(CashoutLog cashoutLog);

    CashoutLog selectById(String id);

    List<CashoutLog> selectUserCashout(String userId);

    int updateCashoutLog(CashoutLog cashoutLog);

}