package com.gis3c.ol.entity;

/**
 * Created by hukekuan on 2018/2/24.
 */
public class MapLayer {
    private Layer layer;
    private Boolean isBinded = Boolean.FALSE;

    public MapLayer(){}
    public MapLayer(Layer layer,Boolean isBinded){
        this.layer = layer;
        this.isBinded = isBinded;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public Boolean getBinded() {
        return isBinded;
    }

    public void setBinded(Boolean binded) {
        isBinded = binded;
    }
}
