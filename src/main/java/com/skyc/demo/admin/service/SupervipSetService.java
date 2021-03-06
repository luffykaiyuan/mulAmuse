package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.SupervipSetMapper;
import com.skyc.demo.admin.po.SupervipSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervipSetService {

    @Autowired
    SupervipSetMapper supervipSetMapper;

    public List<SupervipSet> selectAllSet(){
        return supervipSetMapper.selectAllSet();
    }
}
