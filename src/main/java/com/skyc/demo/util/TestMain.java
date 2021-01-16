package com.skyc.demo.util;

import java.io.File;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;

/*
 * 测试类
 * @author luffykaiyuan
 * @date 2020/11/22 11:34
 * @return
 */



/**
 * 把两张图片合并
 * @version 2018-2-27 上午11:12:09
 *
 */
public class TestMain {
    private Graphics2D g = null;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {
        try {
            g = d.createGraphics();
            g.drawImage(b, 88, 420, 100, 100, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return d;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);

//        TestMain testMain = new TestMain();
//
//        BufferedImage d = testMain.loadImageLocal("C:\\upload\\img\\2020\\12\\back1.jpg");
//        BufferedImage b = testMain.loadImageLocal("C:\\upload\\img\\2020\\12\\baidu.jpg");
//
//        testMain.writeImageLocal("C:\\upload\\img\\qrcode\\new10.jpg", testMain.modifyImagetogeter(b, d));
//        //将多张图片合在一起
        System.out.println(result);
    }
}
