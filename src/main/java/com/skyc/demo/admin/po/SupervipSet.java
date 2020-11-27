package com.skyc.demo.admin.po;

public class SupervipSet {
    private String id;

    private Float supervipMoney;

    private Integer dicountNumber;

    private Integer payHaveNumber;

    private Integer inviteNumber;

    private Integer inviteHaveNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Float getSupervipMoney() {
        return supervipMoney;
    }

    public void setSupervipMoney(Float supervipMoney) {
        this.supervipMoney = supervipMoney;
    }

    public Integer getDicountNumber() {
        return dicountNumber;
    }

    public void setDicountNumber(Integer dicountNumber) {
        this.dicountNumber = dicountNumber;
    }

    public Integer getPayHaveNumber() {
        return payHaveNumber;
    }

    public void setPayHaveNumber(Integer payHaveNumber) {
        this.payHaveNumber = payHaveNumber;
    }

    public Integer getInviteNumber() {
        return inviteNumber;
    }

    public void setInviteNumber(Integer inviteNumber) {
        this.inviteNumber = inviteNumber;
    }

    public void setInviteHaveNumber(Integer inviteHaveNumber) {
        this.inviteHaveNumber = inviteHaveNumber;
    }

    public Integer getInviteHaveNumber() {
        return inviteHaveNumber;
    }
}