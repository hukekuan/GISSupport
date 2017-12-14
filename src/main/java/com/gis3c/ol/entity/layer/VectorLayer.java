package com.gis3c.ol.entity.layer;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class VectorLayer extends BaseLayer {
    private String source;
    private String styleType;
    private String styleValue;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }

    public String getStyleValue() {
        return styleValue;
    }

    public void setStyleValue(String styleValue) {
        this.styleValue = styleValue;
    }
}
