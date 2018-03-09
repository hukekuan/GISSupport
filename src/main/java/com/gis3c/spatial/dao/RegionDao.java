package com.gis3c.spatial.dao;

import com.gis3c.common.persistence.annotation.C3SpatialDao;
import com.gis3c.spatial.entity.Region;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
@C3SpatialDao
public interface RegionDao {
    public Region findRegionByCode(String reginTable, String reginCode);
    public String findRgionCenterByCode(String reginTable, String reginCode);
    public List<Region> findAroundRegions(String reginTable, String reginCode);
    public List<Region> findRegionsByParentCode(String reginTable, String parentCode);
    public List<Map<String,String>> findRegionCentersByParentCode(String reginTable, String parentCode);
}
