package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileInfoMapper {

    int insertFile(FileInfo fileInfo);

    FileInfo selectFile(String id);

    int updateFile(FileInfo fileInfo);
}