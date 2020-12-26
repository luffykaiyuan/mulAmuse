package com.skyc.demo.util.weChat;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("/wxLogin")
public class WxLoginCon {

    @RequestMapping("/doLogin")
    public void doLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String backUrl = "http://7d4ar3.natappfree.cc/wxBack/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + AuthUtil.APPID +
                "&redirect_uri=" + backUrl +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        //response.setHeader( "Access-Control-Allow-Origin","*" );
        //response.setHeader( "Cache-Control","no-cache" );
        String toPage =  request.getParameter("toPage");
        session.setAttribute("toPage", toPage);
        response.sendRedirect(url);
    }
}
