package com.gis3c.ol.service;

import com.gis3c.ol.entity.Map;

import java.util.List;
import java.util.Set;

/**
 * Created by hukekuan on 2017/12/14.
 */
public interface MapService {
    public List<Map> findAllList();
    public List<java.util.Map<String,Object>> findMapsByPage(Integer pageSize,Integer currentPage);

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer insertMap(Map map);

    public Integer deleteMapsById(Set<String> mapIds);
}
