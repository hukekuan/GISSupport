package com.gis3c.ol.service;


import com.gis3c.ol.entity.layer.TileLayer;
import com.gis3c.ol.entity.layer.VectorLayer;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface LayerService {
    public TileLayer findeTileLayerById(String layerId);
    public TileLayer findeTileLayerByName(String layerName);

    public Integer insertTileLayer(TileLayer tileLayer);



    public VectorLayer findeVectorLayerById(String layerId);
    public VectorLayer findeVectorLayerByName(String layerName);

    public Integer insertVectorLayer(VectorLayer vectorLayer);
}
