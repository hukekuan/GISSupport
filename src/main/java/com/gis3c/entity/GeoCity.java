package com.gis3c.entity;

import com.gis3c.entity.spatial.BaseFeature;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;

public class GeoCity extends BaseFeature{
    private String code;
    private String name;
    private Geometry geometry;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
