package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.MapDao;
import com.gis3c.ol.entity.Map;
import com.gis3c.ol.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Map> findMapsByByPage(Integer pageSize,Integer currentPage) {
        return mapDao.findMapsByByPage(pageSize,currentPage);
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
    public Integer insertMap(Map map) {
        return mapDao.insertMap(map);
    }
}
