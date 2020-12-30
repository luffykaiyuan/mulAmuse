package com.skyc.demo.util.weChat.pay;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/pay")
public class WxPayCon {

    @RequestMapping("/callback")
    public String callBack(HttpServletRequest request, HttpServletResponse response){
        //System.out.println("微信支付成功,微信发送的callback信息,请注意修改订单信息");
        InputStream is = null;
        try {
            is = request.getInputStream();//获取请求的流信息(这里是微信发的xml格式所有只能使用流来读)
            String xml = WXPayUtil.inputStream2String(is, "UTF-8");
            Map<String, String> notifyMap = WXPayUtil.xmlToMap(xml);//将微信发的xml转map

            if(notifyMap.get("return_code").equals("SUCCESS")){
                if(notifyMap.get("result_code").equals("SUCCESS")){
                    String ordersSn = notifyMap.get("out_trade_no");//商户订单号
                    String amountpaid = notifyMap.get("total_fee");//实际支付的订单金额:单位 分
                    BigDecimal amountPay = (new BigDecimal(amountpaid).divide(new BigDecimal("100"))).setScale(2);//将分转换成元-实际支付金额:元
                    //String openid = notifyMap.get("openid");  //如果有需要可以获取
                    //String trade_type = notifyMap.get("trade_type");

                    /*以下是自己的业务处理------仅做参考
                     */
                    System.out.println("------------------------------------------------");
                    System.out.println("------------------支付成功-----------------------");
                    System.out.println("------------------------------------------------");
                }
            }
            //告诉微信服务器收到信息了，不要在调用回调action了========这里很重要回复微信服务器信息用流发送一个xml即可
            response.getWriter().write("<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}