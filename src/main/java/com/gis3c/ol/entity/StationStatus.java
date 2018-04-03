package com.gis3c.ol.entity;

import com.gis3c.common.bean.IntEnum;

/**
 * Created by hukekuan on 2018/4/2.
 */
public enum StationStatus implements IntEnum<StationStatus> {
    ZC(0,0), CB(1,1), TC(2,-1), GZ(3,-2);

    private StationStatus(Integer index,Integer statusCode){
        this.index = index;
        this.statusCode = statusCode;
    }
    private Integer index;
    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public Integer getIntValue() {
        return this.index;
    }
}
