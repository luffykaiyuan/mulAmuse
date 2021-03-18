package com.skyc.demo.util;

import com.skyc.demo.merchants.po.ProductInfo;
import com.skyc.demo.user.po.UserInfo;

import java.util.ArrayList;
import java.util.List;

/*
 * 获取佣金情况
 * @author luffykaiyuan
 * @date 2020/11/22 11:36
 * @return
 */
public class GetCommission {

    public static float[] getProductCommission(UserInfo userInfo, ProductInfo productInfo){
        int myTitle = Integer.parseInt(userInfo.getUserTitle().trim());
        int fatherTitle = Integer.parseInt(userInfo.getFatherTitle().trim());
        int grandTitle = Integer.parseInt(userInfo.getGrandTitle().trim());
        float[] allCommission = getCake(userInfo, productInfo, myTitle, fatherTitle, grandTitle);
        for (int i = 0; i < allCommission.length; i++) {
            System.out.println(allCommission[i]);
        }
        float[] getCommission = new float[3];
        if (myTitle >= fatherTitle){
            for (int i = 0; i < myTitle; i++) {
                getCommission[0] += allCommission[i];
            }
        }else{
            for (int i = 0; i < myTitle; i++) {
                getCommission[0] += allCommission[i];
                allCommission[i] = 0;
            }
            for (int i = 0; i < fatherTitle; i++) {
                getCommission[1] += allCommission[i];
                allCommission[i] = 0;
            }
            for (int i = 0; i < grandTitle; i++) {
                getCommission[2] += allCommission[i];
                allCommission[i] = 0;
            }
        }
        return getCommission;
    }
    public static float[] getCake(UserInfo userInfo, ProductInfo productInfo, int myTitle, int fatherTitle, int grandTitle){
        float[] allCommission = new float[3];
        int max = myTitle >= fatherTitle ? (myTitle >= grandTitle ? myTitle : grandTitle) : (fatherTitle >= grandTitle ? fatherTitle : grandTitle);
        if (max == 1){
            allCommission[0] = productInfo.getCommissionHeigh();
        }else if (max == 2){
            allCommission[0] = productInfo.getCommissionHeigh();
            allCommission[1] = productInfo.getCommissionMiddle();
        }else if (max == 3){
            allCommission[0] = productInfo.getCommissionHeigh();
            allCommission[1] = productInfo.getCommissionMiddle();
            allCommission[2] = productInfo.getCommissionLow();
        }
        return allCommission;
    }
}
