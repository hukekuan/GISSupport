package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3BatisDao;
import com.gis3c.ol.entity.Map;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/14.
 */
@C3BatisDao
public interface MapDao {
    public List<Map> findAllList();
}
