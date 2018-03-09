package com.gis3c.spatial.service.impl;

import com.gis3c.spatial.entity.Region;
import com.gis3c.spatial.service.RegionService;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
public class RegionServiceImpl implements RegionService {
    @Override
    public Region findRegionByCode(String reginType, String reginCode) {
        return null;
    }

    @Override
    public String findRgionCenterByCode(String reginType, String reginCode) {
        return null;
    }

    @Override
    public List<Region> findAroundRegions(String reginType, String reginCode) {
        return null;
    }

    @Override
    public List<Region> findRegionsByParentCode(String parentCode) {
        return null;
    }

    @Override
    public List<Map<String, String>> findRegionCentersByParentCode(String parentCode) {
        return null;
    }
}
