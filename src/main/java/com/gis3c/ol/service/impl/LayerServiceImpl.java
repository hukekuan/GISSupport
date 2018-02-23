package com.gis3c.ol.service.impl;
import com.gis3c.common.bean.BeanUtil;
import com.gis3c.common.exception.BusinessException;
import com.gis3c.ol.dao.LayerDao;
import com.gis3c.ol.dao.SourceDao;
import com.gis3c.ol.entity.Layer;
import com.gis3c.ol.service.LayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hukekuan on 2017/12/15.
 */
@Service
public class LayerServiceImpl implements LayerService {
    @Autowired
    private LayerDao layerDao;

    @Autowired
    private SourceDao sourceDao;

    @Override
    public List<Map<String, Object>> findLayerList() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> layerMap;
        String sourceId;
        List<Layer> layerList = layerDao.findLayerList();
        for(int i = 0,len = layerList.size();i < len;i++){
            layerMap = new HashMap<>();
            layerMap.put("layer",layerList.get(i));
            sourceId = layerList.get(i).getSource();
            if(sourceId != null && !"".equals(sourceId)){
                layerMap.put("source",sourceDao.findSourceById(sourceId));
            }
            result.add(layerMap);
        }
        return result;
    }

    @Override
    public List<Layer> findSimpleLayerList() {
        return layerDao.findLayerList();
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
    public Integer bindSource(String layerId, String sourceId, Map<String, Object> options) {
        return layerDao.bindSource(layerId,sourceId,options);
    }

    @Override
    public Integer deleteLayersById(Set<String> layerIds) {
        return layerDao.deleteLayersById(layerIds);
    }
}
