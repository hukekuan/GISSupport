package com.gis3c.service;

import java.util.List;
import java.util.Map;

public interface PostGISService {
    public void CommonCreateTable(String tableName,String geometryColumn,List<Map<String,Object>> columns);
}
