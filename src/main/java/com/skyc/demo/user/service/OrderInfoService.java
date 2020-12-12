package com.skyc.demo.user.service;

import com.skyc.demo.admin.service.FileInfoService;
import com.skyc.demo.merchants.dao.ModelInfoMapper;
import com.skyc.demo.merchants.dao.ProductInfoMapper;
import com.skyc.demo.merchants.po.ModelInfo;
import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.merchants.service.ModelInfoService;
import com.skyc.demo.user.dao.CommissionLogMapper;
import com.skyc.demo.user.dao.OrderInfoMapper;
import com.skyc.demo.user.dao.UserCommissionMapper;
import com.skyc.demo.user.dao.UserInfoMapper;
import com.skyc.demo.user.po.CommissionLog;
import com.skyc.demo.user.po.OrderInfo;
import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.util.GetCommission;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.GetRandom;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    FileInfoService fileInfoService;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    ProductInfoMapper productInfoMapper;

    @Autowired
    UserCommissionMapper userCommissionMapper;

    @Autowired
    CommissionLogMapper commissionLogMapper;

    @Autowired
    ModelInfoMapper modelInfoMapper;

    @Autowired
    ModelInfoService modelInfoService;

    @Value("${sendSuc}")
    String sendSuc;
    @Value("${sendFal}")
    String sendFal;
    @Value("${destorySuc}")
    String destorySuc;
    @Value("${destoryFal}")
    String destoryFal;

    @Value("${forePath}")
    String forePath;

    public String insertOrder(OrderInfo orderInfo) throws Exception{
        orderInfo.setId(UUIDUtils.getUUID(16));
        String orderNumber = GetRandom.getRandomNumber(10);
        orderInfo.setOrderNumber(orderNumber);
        orderInfo.setAddTime(GetNowDate.getDetailStringDate());
        if ("0".equals(orderInfo.getProductType())){
            //虚拟产品
            String qrcodeNumber = GetRandom.getRandomNumber(8);
            String qrcodeId = fileInfoService.createQRCode(forePath + qrcodeNumber + "\\");
            orderInfo.setQrcodeImg(qrcodeId);
            orderInfo.setQrcodeNumber(qrcodeNumber);
        } else if ("1".equals(orderInfo.getProductType())){
            //实体产品

        }else if ("2".equals(orderInfo.getProductType())){
            //预约产品

        }else{
            //类型未找到
            return "订单提交失败!";
        }
        orderInfoMapper.insertOrder(orderInfo);
        UserInfo userInfo = userInfoMapper.selectUerDetail(orderInfo.getUserId());
        ProductInfo productInfo = productInfoMapper.selectProductById(orderInfo.getProductId());
        float[] allCommission = GetCommission.getProductCommission(userInfo, productInfo);
        userCommissionMapper.addWaitCommission(allCommission[0], userInfo.getId());
        CommissionLog myLog = new CommissionLog();
        myLog.setId(UUIDUtils.getUUID(16));
        myLog.setOrderNumber(orderNumber);
        myLog.setProvideId(userInfo.getId());
        myLog.setProvideName(userInfo.getUserName());
        myLog.setGetId(userInfo.getId());
        myLog.setGetName(userInfo.getUserName());
        myLog.setGetMoney(allCommission[0]);
        myLog.setAddTime(GetNowDate.getStringDate());
        commissionLogMapper.insertCommissionLog(myLog);
        if (!StringUtils.isEmpty(userInfo.getFatherId())){
            //下单后更新佣金
            userCommissionMapper.addWaitCommission(allCommission[1], userInfo.getFatherId());
            //更新日志表
            CommissionLog fatherLog = new CommissionLog();
            fatherLog.setId(UUIDUtils.getUUID(16));
            fatherLog.setOrderNumber(orderNumber);
            fatherLog.setProvideId(userInfo.getId());
            fatherLog.setProvideName(userInfo.getUserName());
            fatherLog.setGetId(userInfo.getFatherId());
            fatherLog.setGetMoney(allCommission[1]);
            fatherLog.setAddTime(GetNowDate.getStringDate());
            commissionLogMapper.insertCommissionLog(fatherLog);
            //更新用户信息表
            userInfo.setFatherSupport(userInfo.getFatherSupport() + allCommission[1]);
        }
        if (!StringUtils.isEmpty(userInfo.getGrandId())){
            //下单后更新佣金
            userCommissionMapper.addWaitCommission(allCommission[2], userInfo.getGrandId());
            //更新日志表
            CommissionLog grandLog = new CommissionLog();
            grandLog.setId(UUIDUtils.getUUID(16));
            grandLog.setOrderNumber(orderNumber);
            grandLog.setProvideId(userInfo.getId());
            grandLog.setProvideName(userInfo.getUserName());
            grandLog.setGetId(userInfo.getGrandId());
            grandLog.setGetMoney(allCommission[2]);
            grandLog.setAddTime(GetNowDate.getStringDate());
            commissionLogMapper.insertCommissionLog(grandLog);
            //更新用户信息表
            userInfo.setGrandSupport(userInfo.getGrandSupport() + allCommission[2]);
        }
        userInfoMapper.addSupport(userInfo);
//        //减少库存
        ModelInfo modelInfo = modelInfoMapper.selectOneModel(orderInfo.getModelId());
        modelInfo.setModelStock(modelInfo.getModelStock() - orderInfo.getOrderCount());
        modelInfoMapper.subStock(modelInfo);
        modelInfoService.checkStock(orderInfo.getProductId());
        return "下单成功！！！";
    }

    public List<OrderInfo> selectAllNormal(){
        return orderInfoMapper.selectAllNormal();
    }

    public List<OrderInfo> selectUserOrder(String userId){
        return orderInfoMapper.selectUserOrder(userId);
    }

    public List<OrderInfo> selectStoreOrder(String storeId){
        return orderInfoMapper.selectStoreOrder(storeId);
    }

    public List<OrderInfo> selectStoreNetOrder(String storeId){
        return orderInfoMapper.selectStoreNetOrder(storeId);
    }

    public List<OrderInfo> selectStoreRealOrder(String storeId){
        return orderInfoMapper.selectStoreRealOrder(storeId);
    }

    public List<OrderInfo> selectStoreAppointOrder(String storeId){
        return orderInfoMapper.selectStoreAppointOrder(storeId);
    }

    public List<OrderInfo> selectOrderByNum(String orderNumber){
        return orderInfoMapper.selectOrderByNum(orderNumber);
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

    public int checkTime(OrderInfo orderInfo){
        return orderInfoMapper.checkTime(orderInfo);
    }


    public int getProduct(OrderInfo orderInfo){
        return orderInfoMapper.getProduct(orderInfo);
    }

}
