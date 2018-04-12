package com.gis3c.spatial.dao;

import com.gis3c.common.persistence.annotation.C3SpatialDao;
import com.gis3c.spatial.entity.SeparatedRiver;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by hukekuan on 2018/4/12.
 */
@C3SpatialDao
public interface RiverDao {
    public List<SeparatedRiver> findRiversByStationCodes(@Param("stationCodes") Set<String> stationCodes);
    public List<SeparatedRiver> findRiversByRiverCodes(@Param("riverCodes") Set<String> riverCodes);
}
