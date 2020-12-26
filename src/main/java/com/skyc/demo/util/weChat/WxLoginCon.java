package com.skyc.demo.util.weChat;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("/wxLogin")
public class WxLoginCon {

    @RequestMapping("/doLogin")
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String backUrl = "http://4fa2yc.natappfree.cc/wxBack/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + AuthUtil.APPID +
                "&redirect_uri=" + backUrl +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        response.setHeader( "Access-Control-Allow-Origin","*" );
        response.setHeader( "Cache-Control","no-cache" );
        response.sendRedirect(url);
    }
}
