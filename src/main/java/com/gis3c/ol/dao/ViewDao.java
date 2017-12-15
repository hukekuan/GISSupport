package com.gis3c.ol.dao;

import com.gis3c.ol.entity.View;

/**
 * Created by hukekuan on 2017/12/15.
 */
public interface ViewDao {
    public View findeViewById(String viewId);
    public View findeViewByName(String viewName);

    public Integer insertView(View view);
}
