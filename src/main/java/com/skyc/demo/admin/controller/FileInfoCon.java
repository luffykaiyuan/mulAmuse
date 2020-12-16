package com.skyc.demo.admin.controller;

import com.skyc.demo.admin.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
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
    public void createQRCode(@PathParam("url") String url) throws Exception {
        fileInfoService.createQRCode(url);
    }

    @RequestMapping("/selectFile")
    public void getFile(HttpServletRequest request , HttpServletResponse response, @RequestParam("id") String id) throws IOException {
        fileInfoService.selectFile(request,response,id);
    }
}
