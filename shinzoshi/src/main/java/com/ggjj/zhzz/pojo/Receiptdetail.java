package com.ggjj.zhzz.pojo;

public class Receiptdetail {
    private Integer receiptdetailId;

    private Integer storerkey;

    private Integer sku;

    private Integer quantity;

    private String name;

    private String category;

    private Double weight;

    private Integer loc;

    public Integer getReceiptdetailId() {
        return receiptdetailId;
    }

    public void setReceiptdetailId(Integer receiptdetailId) {
        this.receiptdetailId = receiptdetailId;
    }

    public Integer getStorerkey() {
        return storerkey;
    }

    public void setStorerkey(Integer storerkey) {
        this.storerkey = storerkey;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }
}