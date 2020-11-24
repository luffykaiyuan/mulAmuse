package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.SupervipSetMapper;
import com.skyc.demo.admin.po.SupervipSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervipSetService {

    @Autowired
    SupervipSetMapper supervipSetMapper;

    public SupervipSet selectSupervipSet(String id){
        return supervipSetMapper.selectSupervipSet(id);
    }

    public int updateSupervipSet(SupervipSet supervipSet){
        return supervipSetMapper.updateSupervipSet(supervipSet);
    }
}
