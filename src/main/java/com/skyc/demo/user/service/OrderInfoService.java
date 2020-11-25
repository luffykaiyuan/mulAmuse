package com.skyc.demo.user.service;

import com.skyc.demo.user.dao.OrderInfoMapper;
import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.GetRandom;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Value("${sendSuc}")
    String sendSuc;
    @Value("${sendFal}")
    String sendFal;
    @Value("${destorySuc}")
    String destorySuc;
    @Value("${destoryFal}")
    String destoryFal;

    public int insertOrder(OrderInfo orderInfo){
        orderInfo.setId(UUIDUtils.getUUID(16));
        orderInfo.setOrderNumber(GetRandom.getRandomNumber(10));
        orderInfo.setQrcodeNumber(GetRandom.getRandomNumber(8));
        orderInfo.setAddTime(GetNowDate.getStringDate());
        return orderInfoMapper.insertOrder(orderInfo);
    }

    public List<OrderInfo> selectUserOrder(String userId){
        return orderInfoMapper.selectUserOrder(userId);
    }

    public List<OrderInfo> selectStoreOrder(String storeId){
        return orderInfoMapper.selectStoreOrder(storeId);
    }

    public OrderInfo selectOrderDetail(String id){
        return orderInfoMapper.selectOrderDetail(id);
    }

    public String sendProduct(OrderInfo orderInfo){
        int flag = orderInfoMapper.sendProduct(orderInfo);
        if (flag > 0){
            return sendSuc;
        }else {
            return sendFal;
        }
    }

    public String destoryCodeNumber(String qrcodeNumber){
        OrderInfo orderInfo = orderInfoMapper.selectDestoryOrder(qrcodeNumber);
        if ("".equals(orderInfo.getId())){
            return destoryFal;
        } else {
            orderInfoMapper.destoryCodeNumber(orderInfo);
            return destorySuc;
        }
    }

    public int getProduct(OrderInfo orderInfo){
        return orderInfoMapper.getProduct(orderInfo);
    }
}
