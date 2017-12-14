package com.gis3c.ol.entity.source;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class TileArcGISRest {
    private String sourceId;
    private String sourceName;
    private String crossOrigin;
    private String projection;
    private String url;
    private Boolean wrapX;
    private String description;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getCrossOrigin() {
        return crossOrigin;
    }

    public void setCrossOrigin(String crossOrigin) {
        this.crossOrigin = crossOrigin;
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getWrapX() {
        return wrapX;
    }

    public void setWrapX(Boolean wrapX) {
        this.wrapX = wrapX;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
