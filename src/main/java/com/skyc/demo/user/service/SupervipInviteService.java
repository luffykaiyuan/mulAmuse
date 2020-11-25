package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.SupervipInviteMapper;
import com.skyc.demo.user.po.SupervipInvite;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervipInviteService {

    @Autowired
    SupervipInviteMapper supervipInviteMapper;

    public SupervipInvite selectInvite(String userId){
        return supervipInviteMapper.selectInvite(userId);
    }

    public int insertSupervipInvite(SupervipInvite supervipInvite){
        supervipInvite.setId(UUIDUtils.getUUID(16));
        return supervipInviteMapper.insertSupervipInvite(supervipInvite);
    }

    public int updateSupervipInvite(SupervipInvite supervipInvite){
        return supervipInviteMapper.updateSupervipInvite(supervipInvite);
    }

}
