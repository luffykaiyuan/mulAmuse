package com.skyc.demo.util.weChat;

import com.skyc.demo.user.dao.UserInfoMapper;
import com.skyc.demo.user.po.UserInfo;
import com.skyc.demo.user.service.UserInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/wxBack")
public class CallBackCon {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Value("${foreHost}")
    String foreHost;

    @RequestMapping("/callBack")
    public void callBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        boolean existFlag = callWx(request, response, session);
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if (existFlag){
            UserInfo userInfoNew = userInfoService.insertUser(userInfo);
        }

        String toPage = (String) session.getAttribute("toPage");
        String url = foreHost + "/jumpRouter?toPage=" + toPage + "&userId=" + userInfo.getId() + "&openId=" + userInfo.getOpenid();
        response.sendRedirect(url);
    }

    @RequestMapping("/callShareBack")
    public void callShareBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        boolean existFlag = callWx(request, response, session);
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if (existFlag){
            String fatherId = (String) session.getAttribute("fatherId");
            UserInfo fatherInfo = userInfoMapper.selectUserById(fatherId);
            userInfo.setFatherId(fatherId);
            userInfo.setFatherTitle(fatherInfo.getUserTitle());
            if (!StringUtils.isEmpty(fatherInfo.getFatherId())){
                userInfo.setGrandId(fatherInfo.getFatherId());
                userInfo.setGrandTitle(fatherInfo.getFatherTitle());
            }
            UserInfo userInfoNew = userInfoService.insertUser(userInfo);
        }
        String toPage = (String) session.getAttribute("toPage");
        String url = foreHost + "/jumpRouter?toPage=" + toPage + "&userId=" + userInfo.getId() + "&openId=" + userInfo.getOpenid();
        response.sendRedirect(url);
    }

    public boolean callWx(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + AuthUtil.APPID +
                "&secret=" + AuthUtil.APPSECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtil.doGetJson(url);
        String openid = jsonObject.getString("openid");
        String token = jsonObject.getString("access_token");

        session.setAttribute("openid", openid);

        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + token +
                "&openid=" + openid +
                "&lang=zh_CN";
        JSONObject wxInfo = AuthUtil.doGetJson(infoUrl);
        System.out.println(wxInfo);

        UserInfo userInfo = userInfoMapper.selectByOpenId(openid);
        if (null == userInfo) {
            UserInfo userInfoNew = new UserInfo();
            String headimgurl = wxInfo.getString("headimgurl");
            String nickname = wxInfo.getString("nickname");
            userInfoNew.setOpenid(openid);
            userInfoNew.setHeadimgurl(headimgurl);
            userInfoNew.setNickName(nickname);
            session.setAttribute("userInfo", userInfoNew);
            return true;
        }else {
            session.setAttribute("userInfo", userInfo);
            return false;
        }
    }
}
