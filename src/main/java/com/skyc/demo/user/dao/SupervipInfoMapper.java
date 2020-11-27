package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.SupervipInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SupervipInfoMapper {

    int insertSuperVIP(SupervipInfo supervipInfo);

    SupervipInfo selectByPrimaryKey(String id);

    int updateSuperVIP(SupervipInfo supervipInfo);

    int addNumber(String userId);

    int subNumber(String userId);

}