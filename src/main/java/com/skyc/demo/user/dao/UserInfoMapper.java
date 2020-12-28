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

    UserInfo selectUerDetail(String id);

    List<UserInfo> selectUerByUsername(String userName);

    UserInfo selectOneUser(String userName);

    UserInfo selectUserById(String id);

    UserInfo selectByOpenId(String openid);

    int updateUser(UserInfo userInfo);

    int deleteUser(String id);

    int updateUserTitle(UserInfo userInfo);

    int becomeTalent(UserInfo userInfo);

    int addSupport(UserInfo userInfo);

}