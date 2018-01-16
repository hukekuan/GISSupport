package com.gis3c.spatial.service.impl;

import com.gis3c.spatial.dao.TestDao;
import com.gis3c.spatial.entity.Test;
import com.gis3c.spatial.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hukekuan on 2018/1/16.
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired private TestDao testDao;

    @Override
    public List<Test> allList() {
        return testDao.allList();
    }
}
