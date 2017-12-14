package com.gis3c.ol.entity.source;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class Vector {
    private String sourceId;
    private String sourceName;
    private Boolean logo;
    private String url;
    private  Boolean useSpatialIndex;
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

    public Boolean getLogo() {
        return logo;
    }

    public void setLogo(Boolean logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getUseSpatialIndex() {
        return useSpatialIndex;
    }

    public void setUseSpatialIndex(Boolean useSpatialIndex) {
        this.useSpatialIndex = useSpatialIndex;
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
