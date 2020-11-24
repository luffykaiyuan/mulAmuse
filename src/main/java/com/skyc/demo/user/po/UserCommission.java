package com.skyc.demo.user.po;

public class UserCommission {
    private String id;

    private String userId;

    private Float waitWithdrawal;

    private Float finishWithdrawal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Float getWaitWithdrawal() {
        return waitWithdrawal;
    }

    public void setWaitWithdrawal(Float waitWithdrawal) {
        this.waitWithdrawal = waitWithdrawal;
    }

    public Float getFinishWithdrawal() {
        return finishWithdrawal;
    }

    public void setFinishWithdrawal(Float finishWithdrawal) {
        this.finishWithdrawal = finishWithdrawal;
    }
}