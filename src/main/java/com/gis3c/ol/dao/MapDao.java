package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.Map;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/14.
 */
@C3olDao
public interface MapDao {
    public List<Map> findAllList();
    public List<Map> findMapsByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);

    public Map findMapById(String mapId);
    public Map findMapByName(String mapName);
    public Integer insertMap(Map map);
}
