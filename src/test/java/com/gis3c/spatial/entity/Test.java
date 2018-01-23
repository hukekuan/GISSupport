package com.gis3c.spatial.entity;

import com.gis3c.spatial.entity.feature.BaseFeature;

/**
 * Created by hukekuan on 2018/1/16.
 */
public class Test extends BaseFeature {
    private Integer id;
    private String name;
    private String direction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
