package com.skyc.demo.util.weChat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/9/18.
 */
@Controller
@RequestMapping("/wxt")
public class WeixinInterfaceController extends HttpServlet {
    /**
     * 配置微信公众号基本url，使其获取到token
     * */
    @ResponseBody
    @RequestMapping("/xc")
    public void weixininter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //微信获取解析信息
        String str = WX_Util.check_Url(request);
        PrintWriter out = response.getWriter();
        //输出
        out.print(str);
        //刷新
        out.flush();
        //关闭流
        out.close();
    }
}

