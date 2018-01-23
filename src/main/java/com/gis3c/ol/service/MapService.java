package com.gis3c.ol.service;

import com.gis3c.ol.entity.Map;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/14.
 */
public interface MapService {
    public List<Map> findAllList();
    public List<Map> findMapsByByPage(Integer pageSize,Integer currentPage);

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer insertMap(Map map);
}
