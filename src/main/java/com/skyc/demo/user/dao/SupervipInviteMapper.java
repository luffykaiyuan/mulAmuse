package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.SupervipInvite;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SupervipInviteMapper {

    int insertSupervipInvite(SupervipInvite supervipInvite);

    SupervipInvite selectInvite(String userId);

    int updateSupervipInvite(SupervipInvite supervipInvite);

}