package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.Source;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by hukekuan on 2017/12/15.
 */
@C3olDao
public interface SourceDao {
    public List<Source> findAllList();
    public List<Source> findSourcesByPage(
            @Param("pageSize") Integer pageSize,
            @Param("currentPage") Integer currentPage);
    public Source findSourceById(String sourceId);
    public Source findSourceByName(String sourceName);
    public List<Source> findSourceByType(
            @Param("sourceTypes") String[] sourceTypes,
            @Param("projection") String projection);
    public Integer findSourceCount();
    public Integer insertSource(Source source);

    public Integer deleteSourcesById(Set<String> sourceIds);
}
