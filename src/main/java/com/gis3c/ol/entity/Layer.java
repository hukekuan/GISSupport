package com.gis3c.ol.entity;

import java.math.BigDecimal;
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
    private BigDecimal[] extent;
    private Integer zIndex = 0;
    private BigDecimal maxResolution;
    private BigDecimal minResolution;
    private String projection;
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

    public BigDecimal[] getExtent() {
        return extent;
    }

    public void setExtent(BigDecimal[] extent) {
        this.extent = extent;
    }

    public Integer getzIndex() {
        return zIndex;
    }

    public void setzIndex(Integer zIndex) {
        this.zIndex = zIndex;
    }

    public BigDecimal getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(BigDecimal maxResolution) {
        this.maxResolution = maxResolution;
    }

    public BigDecimal getMinResolution() {
        return minResolution;
    }

    public void setMinResolution(BigDecimal minResolution) {
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

    public String[] PossibleSourceType(){
        String[] sourceTypeArray = null;
        switch (this.getType()){
            case "ol.layer.Tile":
                sourceTypeArray = new String[]{
                    "ol.source.TileSuperMapRest",
                    "ol.source.WMTS",
                    "ol.source.TileArcGISRest"
                };
                break;
            case "ol.layer.Image":
                sourceTypeArray = new String[]{"ol.source.Image"};
                break;
            case "ol.layer.Vector":
            case "ol.layer.Heatmap":
                sourceTypeArray = new String[]{
                    "ol.source.Vector",
                    "ol.supermap.FeatureService",
                    "arcgis.FeatureService"
                };
                break;
            case "ol.layer.VectorTile":
                sourceTypeArray = new String[]{"ol.source.VectorTile"};
                break;
            default:
                sourceTypeArray = new String[]{};
                break;
        }

        return sourceTypeArray;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }
}
