package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.SupervipInfoMapper;
import com.skyc.demo.user.dao.SupervipInviteMapper;
import com.skyc.demo.user.po.SupervipInfo;
import com.skyc.demo.user.po.SupervipInvite;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervipInviteService {

    @Autowired
    SupervipInviteMapper supervipInviteMapper;

    @Autowired
    SupervipInfoMapper supervipInfoMapper;

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

    public void becomeVip(SupervipInvite supervipInvite){
//        List<SupervipSet> supervipSet = supervipSetMapper.selectSupervipSet("259");
//        supervipInviteMapper.updateSupervipInvite(supervipInvite);
//        SupervipInfo supervipInfo = new SupervipInfo();
//        supervipInfo.setId(UUIDUtils.getUUID(16));
//        supervipInfo.setUserId(supervipInvite.getUserId());
//        supervipInfo.setHaveNumber(supervipSet.get(0).getInviteHaveNumber());
//        supervipInfoMapper.insertSuperVIP(supervipInfo);
    }
}
