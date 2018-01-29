package com.gis3c.ol.service;


import com.gis3c.ol.entity.Layer;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface LayerService {
    public List<Layer> findAllList();
    public List<Layer> findLayersByPage(Integer pageSize,Integer currentPage);

    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);

    public Integer insertLayer(Layer layer);
}
