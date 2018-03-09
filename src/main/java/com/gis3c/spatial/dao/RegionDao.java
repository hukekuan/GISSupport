package com.gis3c.spatial.dao;

import com.gis3c.spatial.entity.Region;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
public interface RegionDao {
    public Region findRegionByCode(String reginType, String reginCode);
    public String findRgionCenterByCode(String reginType, String reginCode);
    public List<Region> findAroundRegions(String reginType, String reginCode);
    public List<Region> findRegionsByParentCode(String parentCode);
    public List<Map<String,String>> findRegionCentersByParentCode(String parentCode);
}
