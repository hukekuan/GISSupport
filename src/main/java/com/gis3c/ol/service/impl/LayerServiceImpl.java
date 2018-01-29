package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.LayerDao;
import com.gis3c.ol.entity.Layer;
import com.gis3c.ol.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by hukekuan on 2017/12/15.
 */
@Service
public class LayerServiceImpl implements LayerService {
    @Autowired
    private LayerDao layerDao;

    @Override
    public List<Layer> findAllList() {
        return layerDao.findAllList();
    }

    @Override
    public List<Layer> findLayersByPage(Integer pageSize, Integer currentPage) {
        return layerDao.findLayersByPage(pageSize,(currentPage -1)*pageSize);
    }

    @Override
    public Layer findeLayerById(String layerId) {
        return layerDao.findeLayerById(layerId);
    }

    @Override
    public Layer findeLayerByName(String layerName) {
        return layerDao.findeLayerByName(layerName);
    }

    @Override
    public Integer insertLayer(Layer layer) {
        layer.setLayerId(UUID.randomUUID().toString());
        return layerDao.insertLayer(layer);
    }
}
