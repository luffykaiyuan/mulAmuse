package com.skyc.demo.admin.po;

public class SupervipSet {
    private String id;

    private String imgAddress;

    private String supervipName;

    private Float supervipPrice;

    private Integer haveDay;

    private Integer haveNumber;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getSupervipName() {
        return supervipName;
    }

    public void setSupervipName(String supervipName) {
        this.supervipName = supervipName == null ? null : supervipName.trim();
    }

    public Float getSupervipPrice() {
        return supervipPrice;
    }

    public void setSupervipPrice(Float supervipPrice) {
        this.supervipPrice = supervipPrice;
    }

    public Integer getHaveDay() {
        return haveDay;
    }

    public void setHaveDay(Integer haveDay) {
        this.haveDay = haveDay;
    }

    public Integer getHaveNumber() {
        return haveNumber;
    }

    public void setHaveNumber(Integer haveNumber) {
        this.haveNumber = haveNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}