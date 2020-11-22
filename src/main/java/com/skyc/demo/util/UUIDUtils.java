package com.skyc.demo.util;

import java.util.UUID;

/*
 * UUID获取
 * @author luffykaiyuan
 * @date 2020/11/22 11:34
 * @return
 */
public class UUIDUtils {

    public static  String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     *
     * (获取指定长度uuid)
     *
     * @return
     */
    public static  String getUUID(int len)
    {
        if(0 >= len)
        {
            return null;
        }

        String uuid = getUUID();
        System.out.println(uuid);
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < len; i++)
        {
            str.append(uuid.charAt(i));
        }

        return str.toString();
    }
}