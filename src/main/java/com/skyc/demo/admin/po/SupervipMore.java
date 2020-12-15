package com.skyc.demo.admin.po;

public class SupervipMore {
    private String id;

    private String moreName;

    private Integer moreNumber;

    private Float morePrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMoreName() {
        return moreName;
    }

    public void setMoreName(String moreName) {
        this.moreName = moreName == null ? null : moreName.trim();
    }

    public Integer getMoreNumber() {
        return moreNumber;
    }

    public void setMoreNumber(Integer moreNumber) {
        this.moreNumber = moreNumber;
    }

    public Float getMorePrice() {
        return morePrice;
    }

    public void setMorePrice(Float morePrice) {
        this.morePrice = morePrice;
    }
}