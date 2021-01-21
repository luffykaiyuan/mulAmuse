package com.skyc.demo.user.controller;

import com.skyc.demo.user.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/share")
public class ShareCon {

    @Autowired
    ShareService shareService;

    @GetMapping("/createQR")
    public String createQR(@PathParam("qrcodeUrl") String qrcodeUrl) throws Exception{
        return shareService.createQR(qrcodeUrl);
    }

    @GetMapping("/createProductQR")
    public String createProductQR(@PathParam("qrcodeUrl") String qrcodeUrl, @PathParam("backgroundId") String backgroundId) throws Exception{
        return shareService.createProductQR(qrcodeUrl, backgroundId);
    }
}
