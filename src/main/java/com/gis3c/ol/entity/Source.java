package com.gis3c.ol.entity;

import java.util.*;
import java.util.Map;

/**
 * Created by hukekuan on 2018/1/23.
 */
public class Source {
    private String sourceId;
    private String sourceName;
    private java.util.Map<String,Object> params;
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

    public java.util.Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
