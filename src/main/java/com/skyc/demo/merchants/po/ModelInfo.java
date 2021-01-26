package com.skyc.demo.merchants.po;

public class ModelInfo {
    private String id;

    private String productId;

    private String modelName;

    private String modelDetail;

    private Integer modelStock;

    private Float modelPrice;

    private String addTime;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public String getModelDetail() {
        return modelDetail;
    }

    public void setModelDetail(String modelDetail) {
        this.modelDetail = modelDetail;
    }

    public Integer getModelStock() {
        return modelStock;
    }

    public void setModelStock(Integer modelStock) {
        this.modelStock = modelStock;
    }

    public Float getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(Float modelPrice) {
        this.modelPrice = modelPrice;
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