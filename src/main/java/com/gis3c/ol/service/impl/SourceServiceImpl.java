package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.SourceDao;
import com.gis3c.ol.entity.Source;
import com.gis3c.ol.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public List<Source> findSourcesByPage(Integer pageSize, Integer currentPage) {
        return sourceDao.findSourcesByPage(pageSize,(currentPage -1)*pageSize);
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
    public Integer insertSource(Source source) {
        source.setSourceId(UUID.randomUUID().toString());
        return sourceDao.insertSource(source);
    }
}
