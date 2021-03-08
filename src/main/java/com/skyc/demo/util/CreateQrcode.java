package com.skyc.demo.util;

import com.skyc.demo.admin.dao.FileInfoMapper;
import com.skyc.demo.admin.po.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * 把两张图片合并
 * @version 2018-2-27 上午11:12:09
 *
 */
public class CreateQrcode {

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
            g.drawImage(b, 690, 1450, 140, 140, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return d;
    }

    /**
     * 生成新图片到本地
     */
    public FileInfo writeImageLocal(String glPath, String uploadpath, String fileName, BufferedImage img) {
        String id = UUIDUtils.getUUID(16);
        String newImage = glPath + uploadpath + fileName;
        FileInfo fileInfo = new FileInfo();
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);

                File file = new File(newImage);
                fileInfo.setId(id);
                fileInfo.setFileRealName(fileName);
                fileInfo.setFileStorageName(fileName);
                fileInfo.setFileStoragePath(uploadpath);
                fileInfo.setFileSize(file.length());
                fileInfo.setAddTime(GetNowDate.getStringDate());

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return fileInfo;
    }

    public FileInfo create(String glPath, String background, String qrcodePath) {

        CreateQrcode createQrcode = new CreateQrcode();

        BufferedImage d = createQrcode.loadImageLocal(background);
        BufferedImage b = createQrcode.loadImageLocal(qrcodePath);

        String uuid = UUIDUtils.getUUID(32);
        String fileName = uuid + ".jpg";

        return createQrcode.writeImageLocal(glPath, "/qrcode/", fileName, createQrcode.modifyImagetogeter(b, d));
    }
}
