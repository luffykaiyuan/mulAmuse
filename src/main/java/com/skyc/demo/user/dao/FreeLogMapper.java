package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.FreeLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FreeLogMapper {

    int insertFreeLog(FreeLog freeLog);

    FreeLog selectById(String id);

    List<FreeLog> selectByUserId(String userId);

    int updateFreeLog(FreeLog freeLog);

}