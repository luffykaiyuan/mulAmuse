package com.skyc.demo.util;

import java.util.Random;

/*
 * 获取随机数字
 * @author luffykaiyuan
 * @date 2020/11/22 11:33
 * @return
 */
public class GetRandom {

    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }
}
