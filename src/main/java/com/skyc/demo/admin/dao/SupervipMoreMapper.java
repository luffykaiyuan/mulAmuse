package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.SupervipMore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SupervipMoreMapper {

    int insertSelective(SupervipMore record);

    SupervipMore selectByPrimaryKey(String id);

    List<SupervipMore> selectAllMore();

    int updateByPrimaryKeySelective(SupervipMore record);

}