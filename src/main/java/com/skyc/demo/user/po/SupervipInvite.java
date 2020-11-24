package com.skyc.demo.user.po;

public class SupervipInvite {
    private String id;

    private String userId;

    private Integer haveInvite;

    private String status;

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

    public Integer getHaveInvite() {
        return haveInvite;
    }

    public void setHaveInvite(Integer haveInvite) {
        this.haveInvite = haveInvite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}