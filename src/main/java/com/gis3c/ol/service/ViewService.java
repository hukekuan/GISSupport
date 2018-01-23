package com.gis3c.ol.service;

import com.gis3c.ol.entity.View;

import java.util.List;

/**
 * Created by hukekuan on 2017/12/14.
 */
public interface ViewService {
    public List<View> findViewsByByPage(Integer pageSize,Integer currentPage);

    public View findeViewById(String viewId);
    public View findeViewByName(String viewName);

    public Integer insertView(View view);
}
