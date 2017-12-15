package com.ggjj.zhzz.vo;

public class LocRequestVo extends CommonRequestVo {
    private Integer loc;

    private String type;

    private String putawayzone;

    private Integer stacklimit;

    private Integer footprint;

    private Integer quantity;

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPutawayzone() {
        return putawayzone;
    }

    public void setPutawayzone(String putawayzone) {
        this.putawayzone = putawayzone == null ? null : putawayzone.trim();
    }

    public Integer getStacklimit() {
        return stacklimit;
    }

    public void setStacklimit(Integer stacklimit) {
        this.stacklimit = stacklimit;
    }

    public Integer getFootprint() {
        return footprint;
    }

    public void setFootprint(Integer footprint) {
        this.footprint = footprint;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}