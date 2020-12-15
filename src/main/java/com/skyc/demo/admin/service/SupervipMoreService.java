package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.SupervipMoreMapper;
import com.skyc.demo.admin.po.SupervipMore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervipMoreService {

    @Autowired
    SupervipMoreMapper supervipMoreMapper;

    public List<SupervipMore> selectAllMore(){
        return supervipMoreMapper.selectAllMore();
    }
}
