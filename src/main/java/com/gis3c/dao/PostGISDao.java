package com.gis3c.dao;

import com.gis3c.entity.GeoCity;

import java.util.List;
import java.util.Map;

public interface PostGISDao {
    public void CommonCreateTable(Map<String,Object> tableStructure);
    public void CreateSpatialIndex(String tableName,String geometryColumn);

    public List<GeoCity> AllCities();
}
