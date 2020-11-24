package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.SupervipInvite;

public interface SupervipInviteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SupervipInvite record);

    int insertSelective(SupervipInvite record);

    SupervipInvite selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SupervipInvite record);

    int updateByPrimaryKey(SupervipInvite record);
}