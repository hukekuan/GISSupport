package com.gis3c.spatial.dao;

import com.gis3c.common.persistence.annotation.C3SpatialDao;
import com.gis3c.spatial.entity.Test;

import java.util.List;

/**
 * Created by hukekuan on 2018/1/16.
 */
@C3SpatialDao
public interface TestDao {
    public List<Test> allList();
}
