package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.CommissionLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommissionLogMapper {

    int insertCommissionLog(CommissionLog commissionLog);

    CommissionLog selectById(String id);

    List<CommissionLog> selectUserCommissionLog(String getId);

    int updateCommissionLog(CommissionLog commissionLog);

    int cashoutFinish(String getId);
}