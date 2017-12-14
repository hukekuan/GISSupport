package com.gis3c.ol.entity.source;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class Wmts {
    private String sourceId;
    private String sourceName;
    private String url;
    private String layer;
    private String style;
    private String format;
    private String matrixSet;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getMatrixSet() {
        return matrixSet;
    }

    public void setMatrixSet(String matrixSet) {
        this.matrixSet = matrixSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
