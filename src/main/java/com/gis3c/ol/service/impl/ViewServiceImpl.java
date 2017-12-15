package com.gis3c.ol.service.impl;

import com.gis3c.ol.dao.ViewDao;
import com.gis3c.ol.entity.View;
import com.gis3c.ol.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewDao viewDao;

    @Override
    public View findeViewById(String viewId) {
        return viewDao.findeViewById(viewId);
    }

    @Override
    public View findeViewByName(String viewName) {
        return viewDao.findeViewByName(viewName);
    }

    @Override
    public Integer insertView(View view) {
        return viewDao.insertView(view);
    }
}
