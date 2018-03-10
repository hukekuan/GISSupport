package com.gis3c.spatial.dao;

import com.gis3c.common.persistence.annotation.C3SpatialDao;
import com.gis3c.spatial.entity.Region;
import com.gis3c.spatial.entity.RegionCenter;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
@C3SpatialDao
public interface RegionDao {
    public Region findRegionByCode(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public String findRgionCenterByCode(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public List<Region> findAroundRegions(
            @Param("reginTable") String reginTable,
            @Param("reginCode") String reginCode
    );

    public List<Region> findRegionsByParentCode(
            @Param("reginTable") String reginTable,
            @Param("parentCode") String parentCode
    );

    public List<RegionCenter> findRegionCentersByParentCode(
            @Param("reginTable") String reginTable,
            @Param("parentCode") String parentCode
    );
}
