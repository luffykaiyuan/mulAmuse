package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.UserCommission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserCommissionMapper {

    int insertCommission(UserCommission userCommission);

    UserCommission selectById(String id);

    UserCommission selectUserCommission(String userId);

    int updateCommission(UserCommission userCommission);

    void addWaitCommission(Float waitWithdrawal, String userId);

}