package com.gis3c.ol.entity.layer;

/**
 * Created by hukekuan on 2017/12/14.
 */
public abstract class BaseLayer {
    private String layerId;
    private String layerName;
    private Double opacity;
    private Boolean visible = Boolean.TRUE;
    private Double[] extent;
    private Integer zIndex;
    private Double maxResolution;
    private Double minResolution;
    private String description;

    public String getLayerId() {
        return layerId;
    }

    public void setLayerId(String layerId) {
        this.layerId = layerId;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Double[] getExtent() {
        return extent;
    }

    public void setExtent(Double[] extent) {
        this.extent = extent;
    }

    public Integer getzIndex() {
        return zIndex;
    }

    public void setzIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }

    public Double getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(Double maxResolution) {
        this.maxResolution = maxResolution;
    }

    public Double getMinResolution() {
        return minResolution;
    }

    public void setMinResolution(Double minResolution) {
        this.minResolution = minResolution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
