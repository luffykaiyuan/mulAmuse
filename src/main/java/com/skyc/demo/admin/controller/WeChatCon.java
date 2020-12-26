package com.skyc.demo.admin.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/weChat")
public class WeChatCon {

    @Value("${APPID}")
    String APPID;
    @Value("${APPSECRETP}")
    String APPSECRETP;

    @RequestMapping("/wxLogin")
    public String wxLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String appId = APPID;
        String redirect_url = "192.168.101.105:685/wxBack";
        String scope = "snsapi_userinfo";
        String getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=" + appId + "&redirect_ui=" + redirect_url + "&response_type=code"
                + "&scope=" + scope + "&status=STATE#wechat_redirect";

//        response.sendRedirect(getCodeUrl);
        return getCodeUrl;
    }

    @RequestMapping("/getOpenId")
    public String getOpenId() throws IOException {
        String appId = APPID;
        String appsecretp = APPSECRETP;
        String aturl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId + "&secret=" + appsecretp
                + "&grant_type=client_credential";
//        DefaultHttpClient client = new DefaultHttpClient();
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(aturl);
            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String strResult = EntityUtils.toString(response.getEntity());
                System.out.println(strResult);
                return strResult;
            } else {
                return "查询失败，请重试！！";
            }
        }catch (IOException e){
            e.printStackTrace();;
            return "查询异常，请联系开发人员！！！！";
        }
    }
}
