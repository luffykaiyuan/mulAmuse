package com.skyc.demo.util.ali;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/aliMessage")
public class SendMessageCon {

    @Autowired
    AliYunMessageService aliYunMessageService;

    /**
     * 使用阿里云发送手机验证码功能
     */
    @PostMapping(value = "/sendMessage")
    public String sendMessageToIphone(@RequestBody AliyunMessageVo vo, HttpSession session) throws Exception {
        //1.准备好请求参数：phoneNumber、TemplateParam
        String phoneNumber = vo.getPhone();
        //随机生成手机验证码
        String code = CheckSumBuilder.getCheckSum();
        //2.调用接口，发短信
        SendSmsResponse response = aliYunMessageService.sendSms(phoneNumber, code);
        Thread.sleep(3000L);
        //查询发送消息接口记录
        if (response.getCode() != null && response.getCode().equals("OK")) {
            QuerySendDetailsResponse querySendDetailsResponse = aliYunMessageService.querySendDetails(response.getBizId(), phoneNumber);
            //对返回结果true 或者false进行一个全局判断
            String responseCode = querySendDetailsResponse.getCode();
            String responseMessage = querySendDetailsResponse.getMessage();
            //OK代表信息发送成功
            if ("OK".equals(responseCode) && "OK".equals(responseMessage)) {
                //将code 保存到session中，并且返回给前端,方便前端用来判断
                session.setAttribute("codeNumber", code);
                return code;
            }
        }
        return "发送失败";
    }

    @GetMapping(value = "/blindPhone")
    public boolean blindPhone(@PathParam("verifyNumber")String verifyNumber, HttpSession session){
        String code = (String) session.getAttribute("codeNumber");
        if (verifyNumber.equals(code)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 根据手机号码绑定用户信息
     *
     * @return
     */
//    @PostMapping(value = "/boundUserByPhone")
//    public ResultData boundUserByPhone(@RequestBody AliyunMessageVo vo, HttpSession session) {
//        BosUserModel userModel = (BosUserModel) session.getAttribute("user");
//        vo.setUserModel(userModel);
//        //阿里云发送的手机验证码
//        String codeNumber = (String) session.getAttribute("codeNumber");
//        vo.setNodeNumber(codeNumber);
//        return userService.modifyUserModelByPhone(vo);
//    }
}
