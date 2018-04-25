package com.gis3c.spatial.entity;

/**
 * Created by hukekuan on 2018/4/25.
 */
public class ModelRiver extends BaseFeature{
    private String riverName;
    private String aliasName;
    private Integer orderNum;

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
