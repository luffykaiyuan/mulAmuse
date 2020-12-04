package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.SupervipSet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SupervipSetMapper {

    List<SupervipSet> selectSupervipSet(String id);

    int updateSupervipSet(SupervipSet supervipSet);

}