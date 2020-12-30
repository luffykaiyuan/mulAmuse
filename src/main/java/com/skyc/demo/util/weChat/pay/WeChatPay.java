package com.skyc.demo.util.weChat.pay;

import com.skyc.demo.util.weChat.AuthUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/wePay")
public class WeChatPay {

    @Value("${backHost}")
    String backHost;
    @Value("${foreHost}")
    String foreHost;

    /**
     * @Description 微信浏览器内微信支付/公众号支付(JSAPI)
     * @param request
     * @return Map
     */
    @RequestMapping(value="/orders", method = RequestMethod.GET)
    public Map orders(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            //拼接统一下单地址参数
            Map<String, String> paraMap = new HashMap<String, String>();
            //获取请求ip地址
            String ip = request.getHeader("x-forwarded-for");
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("Proxy-Client-IP");
            }
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getRemoteAddr();
            }
            if(ip.indexOf(",")!=-1){
                String[] ips = ip.split(",");
                ip = ips[0].trim();
            }

            String openid = (String) session.getAttribute("openid");
            String money = (String) session.getAttribute("orderPrice");

            paraMap.put("appid", AuthUtil.APPID);
            paraMap.put("body", "惠享生活-订单结算");
            paraMap.put("mch_id", AuthUtil.MCHID);
            paraMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paraMap.put("openid", openid);
            paraMap.put("out_trade_no", WXPayUtil.generateNonceStr());//订单号
            paraMap.put("spbill_create_ip", ip);
            paraMap.put("total_fee", money);
            paraMap.put("trade_type", "JSAPI");
            paraMap.put("notify_url", foreHost + "/paySuccess");// 此路径是微信服务器调用支付结果通知路径随意写
            String sign = WXPayUtil.generateSignature(paraMap, AuthUtil.APISECRET);
            paraMap.put("sign", sign);
            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式

            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
            String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

            String xmlStr = HttpRequest.sendPost(unifiedorder_url, xml);//发送post请求"统一下单接口"返回预支付id:prepay_id

            //以下内容是返回前端页面的json数据
            String prepay_id = "";//预支付id
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
                prepay_id = (String) map.get("prepay_id");
            }
            Map<String, String> payMap = new HashMap<String, String>();
            payMap.put("appId", AuthUtil.APPID);
            payMap.put("timeStamp", WXPayUtil.getCurrentTimestamp()+"");
            payMap.put("nonceStr", WXPayUtil.generateNonceStr());
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepay_id);
            String paySign = WXPayUtil.generateSignature(payMap, AuthUtil.APISECRET);
            payMap.put("paySign", paySign);
            return payMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
