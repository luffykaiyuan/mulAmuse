package com.skyc.demo.user.dao;

import com.skyc.demo.user.po.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderInfoMapper {

    int insertOrder(OrderInfo orderInfo);

    OrderInfo selectOrderDetail(String id);

    OrderInfo selectDestoryOrder(String qrcodeNumber);

    List<OrderInfo> selectAllNormal();

    List<OrderInfo> selectUserOrder(String userId);

    List<OrderInfo> selectStoreOrder(String storeId);

    List<OrderInfo> selectStoreNetOrder(String storeId);

    List<OrderInfo> selectStoreRealOrder(String storeId);

    List<OrderInfo> selectOrderByNum(String orderNumber);

    OrderInfo selectOneOrder(String orderNumber);

    List<OrderInfo> selectStoreAppointOrder(String storeId);

    int updateOrder(OrderInfo orderInfo);

    int sendProduct(OrderInfo orderInfo);

    int destoryCodeNumber(OrderInfo orderInfo);

    int checkTime(OrderInfo orderInfo);

    int getProduct(OrderInfo orderInfo);

}