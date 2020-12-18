package com.skyc.demo.developers.dao;

import com.skyc.demo.developers.po.QuartzInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuartzInfoMapper {

    int insertQuartz(QuartzInfo quartzInfo);

    QuartzInfo selectById(String id);

    List<QuartzInfo> selectAll();

    int updateQuartz(QuartzInfo quartzInfo);

    int subTime(String id);

    int overTime(String id);

}