package com.gis3c.ol.dao;

import com.gis3c.common.persistence.annotation.C3olDao;
import com.gis3c.ol.entity.View;

/**
 * Created by hukekuan on 2017/12/15.
 */
@C3olDao
public interface ViewDao {
    public View findeViewById(String viewId);
    public View findeViewByName(String viewName);

    public Integer insertView(View view);
}
