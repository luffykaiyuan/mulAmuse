package com.skyc.demo.admin.service;

import com.skyc.demo.admin.dao.FileInfoMapper;
import com.skyc.demo.admin.po.FileInfo;
import com.skyc.demo.util.GetNowDate;
import com.skyc.demo.util.QRCodeUtil;
import com.skyc.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;

@Service
public class FileInfoService {

    @Autowired
    FileInfoMapper fileInfoMapper;

    @Value("${uploadPath}")
    String getPath;
    @Value("${forePath}")
    String forePath;
    @Value("${foreHost}")
    String foreHost;

    public String createQRCode(String text) throws Exception {
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
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        //        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        //        System.out.println(str);

        File file = new File(destPath);
        FileInfo fileInfo = new FileInfo();
        String id = UUIDUtils.getUUID(16);
        fileInfo.setId(id);
        fileInfo.setFileRealName(fileName);
        fileInfo.setFileStorageName(fileName);
        fileInfo.setFileStoragePath(uploadpath);
        fileInfo.setFileSize(file.length());
        fileInfo.setAddTime(GetNowDate.getStringDate());

        fileInfoMapper.insertFile(fileInfo);

        return id;
    }

    public String copyFile(MultipartHttpServletRequest muiltRequest, HttpSession session) throws IOException {
        // 获取遍历文件名
        Iterator iter = muiltRequest.getFileNames();
        String fileStorageName = "";
        String uploadpath = "";
        FileInfo fileInfo = null;
        String id = UUIDUtils.getUUID(16);

//        FwUserPo fwUserPo = UserSessionUtil.getCurrentUser(currentSession);
        Calendar cale = Calendar.getInstance();

        while (iter.hasNext()) {
            MultipartFile file = muiltRequest.getFile(iter.next().toString());
            System.out.println("-->>>" + file);
            if (!file.isEmpty() || file != null) {
                fileInfo = new FileInfo();
                //获取原始文件名
                String filename = file.getOriginalFilename();

                InputStream is = file.getInputStream(); // 获取输入流,MultipartFile中可以直接得到文件的流
                int pos = filename.lastIndexOf("."); // 取文件的格式
                //唯一标识数字
                UUID uuid = UUID.randomUUID();
                fileStorageName = uuid + filename.substring(pos);
                String rootPath = getPath;
                uploadpath = File.separator + cale.get(Calendar.YEAR) + File.separator + (cale.get(Calendar.MONTH) + 1);
                String realPath = rootPath + uploadpath;
                File uploadPathFile = new File(realPath);
                if (!uploadPathFile.exists()) {
                    uploadPathFile.mkdirs();
                }
                String filenameurl = realPath + File.separator + fileStorageName;
                try {
                    // 获取输出流
                    OutputStream os = new FileOutputStream(filenameurl);
                    // 创建一个缓冲区
                    byte[] buffer = new byte[1024];
                    // 判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    // 循环将输入流读入到缓冲区当中，(len=is.read(buffer))>0就表示is里面还有数据
                    while ((len = is.read(buffer)) > 0) {
                        // 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录当中
                        os.write(buffer, 0, len);
                    }

                    fileInfo.setId(id);

                    //附件原始名
                    fileInfo.setFileRealName(filename);
                    //附件存储名
                    fileInfo.setFileStorageName(fileStorageName);
                    //附件存储路径
                    fileInfo.setFileStoragePath(uploadpath);
                    //附件大小
                    fileInfo.setFileSize(file.getSize());

                    //附件上传时间
                    fileInfo.setAddTime(GetNowDate.getStringDate());

                    fileInfoMapper.insertFile(fileInfo);

                    os.flush();
                    os.close();
                    is.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
    }

    public void selectFile(HttpServletRequest request , HttpServletResponse response, String id) throws IOException{
        FileInfo fileInfo = fileInfoMapper.selectFile(id);
        //读取路径下面的文件
        File file = new File("C:/upload/img/"+fileInfo.getFileStoragePath());
        File picFile = null;
        for(File f : file.listFiles()){
            if(f.getName().contains(fileInfo.getFileStorageName())){
                //根据路径获取文件
                picFile = new File(f.getPath());
                //获取文件后缀名格式
                String ext = picFile.getName().substring(picFile.getName().indexOf("."));
                //判断图片格式,设置相应的输出文件格式
                if(ext.equals("jpg")){
                    response.setContentType("image/jpeg");
                }else if(ext.equals("JPG")){
                    response.setContentType("image/jpeg");
                }else if(ext.equals("png")){
                    response.setContentType("image/png");
                }else if(ext.equals("PNG")){
                    response.setContentType("image/png");
                }
            }
        }
        //读取指定路径下面的文件
        InputStream in = new FileInputStream(picFile);
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        //创建存放文件内容的数组
        byte[] buff =new byte[1024];
        //所读取的内容使用n来接收
        int n;
        //当没有读取完时,继续读取,循环
        while((n=in.read(buff))!=-1){
            //将字节数组的数据全部写入到输出流中
            outputStream.write(buff,0,n);
        }
        //强制将缓存区的数据进行输出
        outputStream.flush();
        //关流
        outputStream.close();
        in.close();
    }
}
