package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.SupervipSet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SupervipSetMapper {

    SupervipSet selectSupervipSet(String id);

    int updateSupervipSet(SupervipSet supervipSet);

}