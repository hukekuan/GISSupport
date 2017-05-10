package com.gis3c.dao;

import java.util.Map;

public interface PostGISDao {
    public void CommonCreateTable(Map<String,Object> tableStructure);
    public void CreateSpatialIndex(Map<String,Object> params);
}
