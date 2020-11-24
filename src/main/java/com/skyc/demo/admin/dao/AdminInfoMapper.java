package com.skyc.demo.admin.dao;

import com.skyc.demo.admin.po.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminInfoMapper {

    int insertAdmin(AdminInfo adminInfo);

    AdminInfo selectById(String id);

    AdminInfo selectByUsername(String adminUsername);

    List<AdminInfo> selectAllAdmin();

    int updateAdmin(AdminInfo adminInfo);

    int changePassword(AdminInfo adminInfo);

    int deleteAdmin(String id);

}