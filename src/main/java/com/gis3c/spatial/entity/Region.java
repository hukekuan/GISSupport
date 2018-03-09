package com.gis3c.spatial.entity;

/**
 * Created by hukekuan on 2018/3/9.
 */
public class Region extends BaseFeature {
    private String reginCode;
    private String regionName;
    private String style;

    public String getReginCode() {
        return reginCode;
    }

    public void setReginCode(String reginCode) {
        this.reginCode = reginCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
