package com.c3gis.spatial.entity;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by hukekuan on 17-7-10.
 */
public interface IFeature {
    /**
     * @author hukekuan
     * @Description 获取所有的Field，前提是要有Geometry属性
     * @date 2017-07-10 下午4:36
     * @return 返回所有的Field
     */
    public List<Field> AllFieldes();
}
