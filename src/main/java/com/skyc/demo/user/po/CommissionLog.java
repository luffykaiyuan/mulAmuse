package com.skyc.demo.user.po;

public class CommissionLog {
    private String id;

    private String orderNumber;

    private String provideId;

    private String provideName;

    private String getId;

    private String getName;

    private float getMoney;

    private String addTime;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getProvideId() {
        return provideId;
    }

    public void setProvideId(String provideId) {
        this.provideId = provideId == null ? null : provideId.trim();
    }

    public String getProvideName() {
        return provideName;
    }

    public void setProvideName(String provideName) {
        this.provideName = provideName == null ? null : provideName.trim();
    }

    public String getGetId() {
        return getId;
    }

    public void setGetId(String getId) {
        this.getId = getId == null ? null : getId.trim();
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName == null ? null : getName.trim();
    }

    public void setGetMoney(float getMoney) {
        this.getMoney = getMoney;
    }

    public float getGetMoney() {
        return getMoney;
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