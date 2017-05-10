package com.gis3c.service.impl;

import com.gis3c.dao.PostGISDao;
import com.gis3c.service.PostGISService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("postGISService")
public class PostGISServiceImpl implements PostGISService {
    @Resource private PostGISDao postGISDao;

    public void CommonCreateTable(
            String tableName,String geometryColumn,List<Map<String,Object>> columns){
        Map<String,Object> tableStructure = new HashMap<>();
        tableStructure.put("tableName",tableName);
        tableStructure.put("columnList",columns);

        Map<String,Object> SpatialIndexParam = new HashMap<>();
        SpatialIndexParam.put("spatialIndexName","sidx_" + tableName + "_" + geometryColumn);
        SpatialIndexParam.put("tableName",tableName);
        SpatialIndexParam.put("geometryColumn",geometryColumn);

        postGISDao.CommonCreateTable(tableStructure);
        postGISDao.CreateSpatialIndex(SpatialIndexParam);
    }
}
