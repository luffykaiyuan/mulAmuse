package com.skyc.demo.util.ali;

/**
 * @Author tanghh
 * @Date 2019/12/30 18:24
 */
public class AliyunMessageVo {
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 用户信息
     */
//    private BosUserModel userModel;
    /**
     * 阿里云发送的手机验证码
     */
    private String nodeNumber;
    /**
     * 用户输入的验证码
     */
    private String verifyNumber;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public String getVerifyNumber() {
        return verifyNumber;
    }

    public void setVerifyNumber(String verifyNumber) {
        this.verifyNumber = verifyNumber;
    }
}
