package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.MapDao;
import com.gis3c.ol.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2017/12/14.
 */
@Service
public class MapServiceImpl implements MapService {
    @Autowired
    private MapDao mapDao;

    @Override
    public List<Map> findAllList() {
        return mapDao.findAllList();
    }
}
