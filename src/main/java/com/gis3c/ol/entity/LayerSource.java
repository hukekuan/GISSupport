package com.gis3c.ol.entity;

/**
 * Created by hukekuan on 2018/2/24.
 */
public class LayerSource {
    private Layer layer;
    private Source source;

    public LayerSource(){}

    public LayerSource(Layer layer,Source source){
        this.layer = layer;
        this.source = source;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
