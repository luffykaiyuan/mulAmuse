package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderInfoMapper {

    int insertOrder(OrderInfo orderInfo);

    OrderInfo selectById(String id);

    List<OrderInfo> selectUserOrder(String userId);

    int updateOrder(OrderInfo orderInfo);

}