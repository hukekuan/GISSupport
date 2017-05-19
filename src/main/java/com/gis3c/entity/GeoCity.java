package com.gis3c.entity;

import com.vividsolutions.jts.geom.Polygon;

public class GeoCity {
    private String code;
    private String name;
    private Polygon geom;

    public boolean isDefaut(){
        boolean defaulted = false;
        if(this.code.contains("370")){
            defaulted = true;
        }
        return defaulted;
    }

    public boolean isZB(){
        boolean zb = false;
        if("370300".equals(this.getCode())){
            zb = true;
        }
        return zb;
    }

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

    public Polygon getGeom() {
        return geom;
    }

    public void setGeom(Polygon geom) {
        this.geom = geom;
    }
}
