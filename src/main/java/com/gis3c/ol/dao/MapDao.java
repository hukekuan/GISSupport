package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.Map;
import java.util.List;

/**
 * Created by hukekuan on 2017/12/14.
 */
@C3olDao
public interface MapDao {
    public List<Map> findAllList();

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer insertMap(Map map);
}
