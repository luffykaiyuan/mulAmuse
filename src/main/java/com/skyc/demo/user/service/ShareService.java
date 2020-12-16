package com.skyc.demo.user.service;

import com.skyc.demo.admin.dao.FileInfoMapper;
import com.skyc.demo.admin.po.FileInfo;
import com.skyc.demo.admin.service.FileInfoService;
import com.skyc.demo.util.CreateQrcode;
import com.skyc.demo.util.QRCodeUtil;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Calendar;

@Service
public class ShareService {

    @Value("${uploadPath}")
    String getPath;
    @Value("${background}")
    String background;

    @Autowired
    FileInfoMapper fileInfoMapper;

    public String createQR(String qrcodeUrl) throws Exception {
        // 嵌入二维码的图片路径
        String imgPath = null;
        // 生成的二维码的路径及名称
        Calendar cale = Calendar.getInstance();
        String uploadpath = File.separator + cale.get(Calendar.YEAR) + File.separator + (cale.get(Calendar.MONTH) + 1);
        String realPath = getPath + uploadpath;
        File uploadPathFile = new File(realPath);
        if (!uploadPathFile.exists()) {
            uploadPathFile.mkdirs();
        }
        String uuid = UUIDUtils.getUUID(32);
        String fileName = uuid + ".jpg";
        String destPath = realPath + "\\" + fileName;
        //生成二维码
        QRCodeUtil.encode(qrcodeUrl, imgPath, destPath, true);

        CreateQrcode createQrcode = new CreateQrcode();
        FileInfo fileInfo = createQrcode.create(getPath, background, destPath);
        fileInfoMapper.insertFile(fileInfo);
        return fileInfo.getId();
    }
}
