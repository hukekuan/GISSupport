package com.gis3c.ol.entity.style;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class Style {
    private String styleId;
    private String getStyleName;
    private String fill;
    private String image;
    private String stroke;
    private String text;

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getGetStyleName() {
        return getStyleName;
    }

    public void setGetStyleName(String getStyleName) {
        this.getStyleName = getStyleName;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
