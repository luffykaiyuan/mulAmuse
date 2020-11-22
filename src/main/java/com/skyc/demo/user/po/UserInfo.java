package com.skyc.demo.user.po;

public class UserInfo {
    private String id;

    private String userName;

    private String password;

    private String wechatNumber;

    private String headImg;

    private String nickName;

    private String userPhone;

    private String userRank;

    private String userTitle;

    private Float userCount;

    private String userInvite;

    private Integer inviteNumber;

    private String fatherId;

    private String fatherTitle;

    private Float fatherSupport;

    private String grandId;

    private String grandTitle;

    private Float grandSupport;

    private String addTime;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber == null ? null : wechatNumber.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserRank() {
        return userRank;
    }

    public void setUserRank(String userRank) {
        this.userRank = userRank == null ? null : userRank.trim();
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle == null ? null : userTitle.trim();
    }

    public Float getUserCount() {
        return userCount;
    }

    public void setUserCount(Float userCount) {
        this.userCount = userCount;
    }

    public String getUserInvite() {
        return userInvite;
    }

    public void setUserInvite(String userInvite) {
        this.userInvite = userInvite == null ? null : userInvite.trim();
    }

    public Integer getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(Integer inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId == null ? null : fatherId.trim();
    }

    public String getFatherTitle() {
        return fatherTitle;
    }

    public void setFatherTitle(String fatherTitle) {
        this.fatherTitle = fatherTitle == null ? null : fatherTitle.trim();
    }

    public Float getFatherSupport() {
        return fatherSupport;
    }

    public void setFatherSupport(Float fatherSupport) {
        this.fatherSupport = fatherSupport;
    }

    public String getGrandId() {
        return grandId;
    }

    public void setGrandId(String grandId) {
        this.grandId = grandId == null ? null : grandId.trim();
    }

    public String getGrandTitle() {
        return grandTitle;
    }

    public void setGrandTitle(String grandTitle) {
        this.grandTitle = grandTitle == null ? null : grandTitle.trim();
    }

    public Float getGrandSupport() {
        return grandSupport;
    }

    public void setGrandSupport(Float grandSupport) {
        this.grandSupport = grandSupport;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}