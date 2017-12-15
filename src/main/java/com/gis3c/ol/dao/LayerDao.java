package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3BatisDao;
import com.gis3c.ol.entity.layer.TileLayer;
import com.gis3c.ol.entity.layer.VectorLayer;

/**
 * Created by hukekuan on 2017/12/15.
 */
@C3BatisDao
public interface LayerDao {
    public TileLayer findeTileLayerById(String layerId);
    public TileLayer findeTileLayerByName(String layerName);

    public int insertTileLayer(TileLayer tileLayer);



    public VectorLayer findeVectorLayerById(String layerId);
    public VectorLayer findeVectorLayerByName(String layerName);

    public int insertVectorLayer(VectorLayer vectorLayer);
}
