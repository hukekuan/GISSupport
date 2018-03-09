package com.gis3c.ol.service.impl;

import com.gis3c.common.bean.BeanUtil;
import com.gis3c.common.exception.BusinessException;
import com.gis3c.ol.dao.MapDao;
import com.gis3c.ol.entity.Map;
import com.gis3c.ol.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hukekuan on 2017/12/14.
 */
@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapDao mapDao;

    @Override
    public List<Map> findAllList() {
        return mapDao.findAllList();
    }

    @Override
    public List<java.util.Map<String,Object>> findMapsByPage(Integer pageSize,Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Map> queryList = mapDao.findMapsByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(map -> {
            try {
                result.add(BeanUtil.Bean2Map(map, Map.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
    }

    @Override
    public Map findMapById(String mapId) {
        return mapDao.findMapById(mapId);
    }

    @Override
    public Map findMapByName(String mapName) {
        return mapDao.findMapByName(mapName);
    }

    @Override
    public Integer findMapCount() {
        return mapDao.findMapCount();
    }

    @Override
    public Integer insertMap(Map map) {
        map.setMapId(UUID.randomUUID().toString());
        return mapDao.insertMap(map);
    }

    @Override
    public Integer deleteMapsById(Set<String> mapIds) {
        return mapDao.deleteMapsById(mapIds);
    }

    @Override
    public Integer bindLayer(String mapId, String[] layerIds) {
        return mapDao.bindLayer(mapId,layerIds);
    }
}
