package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoMapper {

    int insertUser(UserInfo userInfo);

    List<UserInfo> selectAllUser();

    List<UserInfo> selectAllNormal();

    List<UserInfo> selectUserSons(String fatherId);

    UserInfo selectById(String id);

    int updateUser(UserInfo userInfo);

    int deleteUser(String id);

    int updateUserTitle(UserInfo userInfo);

}