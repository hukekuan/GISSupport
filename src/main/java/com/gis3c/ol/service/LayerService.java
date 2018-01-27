package com.gis3c.ol.service;


import com.gis3c.ol.entity.Layer;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface LayerService {
    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);

    public Integer insertLayer(Layer layer);
}
