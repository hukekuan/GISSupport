package com.gis3c.ol.service.impl;

import com.gis3c.common.bean.BeanUtil;
import com.gis3c.common.exception.BusinessException;
import com.gis3c.ol.dao.LayerDao;
import com.gis3c.ol.entity.Layer;
import com.gis3c.ol.entity.Source;
import com.gis3c.ol.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    public List<java.util.Map<String,Object>> findLayersByPage(Integer pageSize, Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Layer> queryList = layerDao.findLayersByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(layer -> {
            try {
                result.add(BeanUtil.Bean2Map(layer, Layer.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
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

    @Override
    public Integer bindSource(String layerId, String sourceId) {
        return layerDao.bindSource(layerId,sourceId);
    }

    @Override
    public Integer deleteLayersById(Set<String> layerIds) {
        return layerDao.deleteLayersById(layerIds);
    }
}
