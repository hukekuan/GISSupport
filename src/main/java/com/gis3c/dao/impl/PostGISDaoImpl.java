package com.gis3c.dao.impl;

import com.gis3c.dao.PostGISDao;
import com.gis3c.entity.GeoCity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostGISDaoImpl extends SqlSessionDaoSupport implements PostGISDao {
    @Resource(name="sqlSessionFactory_GIS")
    private SqlSessionFactory sqlSessionFactory;
    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public void CommonCreateTable(Map<String,Object> tableStructure){
        System.out.println(tableStructure);
        getSqlSession().update("PostGISSql.commonCreateTable",tableStructure);
    }
    @Override
    public void CreateSpatialIndex(String tableName,String geometryColumn){
        Map<String,Object> param = new HashMap<>();
        param.put("tableName",tableName);
        param.put("geometryColumn",geometryColumn);
        param.put("spatialIndexName","sidx_" + tableName +"_" + geometryColumn);
        getSqlSession().update("PostGISSql.createSpatialIndex",param);
    }

    @Override
    public List<GeoCity> AllCities(){
        return getSqlSession().selectList("PostGISSql.allCity");
    }
}
