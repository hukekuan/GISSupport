package com.gis3c.ol.service;

import com.gis3c.ol.entity.Source;
import java.util.List;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface SourceService {
    public List<Source> findAllList();
    public List<Source> findSourcesByPage(Integer pageSize,Integer currentPage);
    public Source findSourceById(String sourceId);
    public Source findSourceByName(String sourceName);
    public Integer insertSource(Source source);
}
