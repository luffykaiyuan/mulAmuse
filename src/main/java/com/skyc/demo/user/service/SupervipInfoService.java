package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.SupervipInfoMapper;
import com.skyc.demo.user.po.SupervipInfo;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervipInfoService {

    @Autowired
    SupervipInfoMapper supervipInfoMapper;

    public int insertSuperVIP(SupervipInfo supervipInfo){
        supervipInfo.setId(UUIDUtils.getUUID(16));
        return supervipInfoMapper.insertSuperVIP(supervipInfo);
    }

    public int updateSuperVIP(SupervipInfo supervipInfo){
        return supervipInfoMapper.updateSuperVIP(supervipInfo);
    }

}
