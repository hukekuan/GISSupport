package com.gis3c.ol.entity;

import java.util.*;
import java.util.Map;

/**
 * Created by hukekuan on 2018/1/27.
 */
public class Layer {
    private String layerId;
    private String layerName;
    private String aliasName;
    private Double opacity = 1.0;
    private String source;
    private Boolean visible = Boolean.TRUE;
    private Double[] extent;
    private Integer zIndex = 0;
    private Double maxResolution;
    private Double minResolution;
    private String type;
    private java.util.Map<String,Object> options;
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

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Double getOpacity() {
        return opacity;
    }

    public void setOpacity(Double opacity) {
        this.opacity = opacity;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
