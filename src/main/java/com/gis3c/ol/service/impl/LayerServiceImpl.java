package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.LayerDao;
import com.gis3c.ol.entity.layer.TileLayer;
import com.gis3c.ol.entity.layer.VectorLayer;
import com.gis3c.ol.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hukekuan on 2017/12/15.
 */
public class LayerServiceImpl implements LayerService {
    @Autowired
    private LayerDao layerDao;

    @Override
    public TileLayer findeTileLayerById(String layerId) {
        return layerDao.findeTileLayerById(layerId);
    }

    @Override
    public TileLayer findeTileLayerByName(String layerName) {
        return layerDao.findeTileLayerByName(layerName);
    }

    @Override
    public Integer insertTileLayer(TileLayer tileLayer) {
        return layerDao.insertTileLayer(tileLayer);
    }

    @Override
    public VectorLayer findeVectorLayerById(String layerId) {
        return layerDao.findeVectorLayerById(layerId);
    }

    @Override
    public VectorLayer findeVectorLayerByName(String layerName) {
        return layerDao.findeVectorLayerByName(layerName);
    }

    @Override
    public Integer insertVectorLayer(VectorLayer vectorLayer) {
        return layerDao.insertVectorLayer(vectorLayer);
    }
}
