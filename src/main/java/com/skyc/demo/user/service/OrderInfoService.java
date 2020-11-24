package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.OrderInfoMapper;
import com.skyc.demo.user.po.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    public List<OrderInfo> selectUserOrder(String userId){
        return orderInfoMapper.selectUserOrder(userId);
    }

}
