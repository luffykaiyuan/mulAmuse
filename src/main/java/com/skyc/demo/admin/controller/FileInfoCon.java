package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/file")
public class FileInfoCon {

    @Autowired
    FileInfoService fileInfoService;

    @PostMapping(value = "/fileUpload")
    @ResponseBody
    public String fileUpload(MultipartHttpServletRequest muiltRequest, HttpSession session) throws IOException {
        return fileInfoService.copyFile(muiltRequest, session);
    }

    @RequestMapping("/createQRCode")
    public void createQRCode() throws Exception {
        fileInfoService.createQRCode("https://blog.csdn.net/jam_fanatic/article/details/82818857");
    }

    @RequestMapping("/selectFile")
    public void getFile(HttpServletRequest request , HttpServletResponse response, @RequestParam("id") String id) throws IOException {
        fileInfoService.selectFile(request,response,id);
    }
}
