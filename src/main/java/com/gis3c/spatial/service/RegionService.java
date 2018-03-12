package com.gis3c.spatial.service;

import com.gis3c.spatial.entity.Region;
import com.gis3c.spatial.entity.RegionCenter;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
public interface RegionService {
    /**
     * 获取区域实体
     * @param reginCode
     */
    public String findRegionByCode(String reginCode);

    /**
     * 获取区域中心点
     * @param reginCode
     * @return 中心点wkt字符串
     */
    public String findRgionCenterByCode(String reginCode);

    /**
     * 获取区域周边区域
     * @param reginCode
     * @return
     */
    public String findAroundRegions(String reginCode);

    /**
     * 获取区域内部的所有子区域
     * @param parentCode
     * @return
     */
    public String findRegionsByParentCode(String parentCode);

    /**
     * 获取子区域内部的所有子区域的中心点
     * @param parentCode
     * @return
     */
    public List<RegionCenter> findRegionCentersByParentCode(String parentCode);
}
