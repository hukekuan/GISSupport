package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.Layer;

/**
 * Created by hukekuan on 2017/12/15.
 */
@C3olDao
public interface LayerDao {
    public Layer findeLayerById(String layerId);
    public Layer findeLayerByName(String layerName);

    public Integer insertLayer(Layer layer);
}
