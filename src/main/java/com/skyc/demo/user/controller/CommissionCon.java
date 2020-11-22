package com.skyc.demo.user.controller;

import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.util.GetCommission;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commission")
public class CommissionCon {

    @PostMapping("/getCommission")
    public float[] getCommission(@RequestBody UserInfo userInfo){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCommissionLow((float) 2);
        productInfo.setCommissionMiddle((float) 3);
        productInfo.setCommissionHeigh((float) 5);
        return GetCommission.getProductCommission(userInfo, productInfo);
    }
}
