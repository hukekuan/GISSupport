package com.gis3c.ol.entity;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class View {
    private String viewId;
    private String viewName;
    private Double[] center;
    private Double[] extent;
    private Double maxResolution;
    private Double minResolution;
    private Integer maxZoom;
    private Integer minZoom;
    private Integer zoom;
    private String projection;
    private Double resolution;
    private Double resolutions;
    private Double rotation;
    private String description;

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Double[] getCenter() {
        return center;
    }

    public void setCenter(Double[] center) {
        this.center = center;
    }

    public Double[] getExtent() {
        return extent;
    }

    public void setExtent(Double[] extent) {
        this.extent = extent;
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

    public Integer getMaxZoom() {
        return maxZoom;
    }

    public void setMaxZoom(Integer maxZoom) {
        this.maxZoom = maxZoom;
    }

    public Integer getMinZoom() {
        return minZoom;
    }

    public void setMinZoom(Integer minZoom) {
        this.minZoom = minZoom;
    }

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public Double getResolution() {
        return resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public Double getResolutions() {
        return resolutions;
    }

    public void setResolutions(Double resolutions) {
        this.resolutions = resolutions;
    }

    public Double getRotation() {
        return rotation;
    }

    public void setRotation(Double rotation) {
        this.rotation = rotation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
