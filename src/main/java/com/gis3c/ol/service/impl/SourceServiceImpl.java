package com.gis3c.ol.service.impl;

import com.gis3c.common.bean.BeanUtil;
import com.gis3c.common.exception.BusinessException;
import com.gis3c.ol.dao.SourceDao;
import com.gis3c.ol.entity.Source;
import com.gis3c.ol.entity.TestStation;
import com.gis3c.ol.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by hukekuan on 2017/12/15.
 */
@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceDao sourceDao;

    @Override
    public List<Source> findAllList() {
        return sourceDao.findAllList();
    }

    @Override
    public List<java.util.Map<String,Object>> findSourcesByPage(Integer pageSize, Integer currentPage) {
        List<java.util.Map<String,Object>> result = new ArrayList<>();
        List<Source> queryList = sourceDao.findSourcesByPage(pageSize,(currentPage -1)*pageSize);
        queryList.forEach(source -> {
            try {
                result.add(BeanUtil.Bean2Map(source, Source.class));
            } catch (IllegalAccessException e) {
                throw new BusinessException(e);
            }
        });
        return result;
    }

    @Override
    public Source findSourceById(String sourceId) {
        return sourceDao.findSourceById(sourceId);
    }

    @Override
    public Source findSourceByName(String sourceName) {
        return sourceDao.findSourceByName(sourceName);
    }

    @Override
    public List<Source> findSourceByType(String[] sourceTypes,String projection) {
        return sourceDao.findSourceByType(sourceTypes,projection);
    }

    @Override
    public Integer findSourceCount() {
        return sourceDao.findSourceCount();
    }

    @Override
    public Integer insertSource(Source source) {
        source.setSourceId(UUID.randomUUID().toString());
        return sourceDao.insertSource(source);
    }

    @Override
    public Integer updateSource(Source source) {
        return sourceDao.updateSource(source);
    }

    @Override
    public Integer deleteSourcesById(Set<String> sourceIds) {
        return sourceDao.deleteSourcesById(sourceIds);
    }

    @Override
    public Integer insertTestStation(TestStation testStation) {
        return sourceDao.insertTestStation(testStation);
    }

    @Override
    public List<TestStation> findTestStationList() {
        return sourceDao.findTestStationList();
    }
}
