package com.gis3c.ol.entity;

/**
 * Created by hukekuan on 2018/4/2.
 */
public class TestStation {
    private Integer stationId;
    private String stationName;
    private StationStatus stationStatus;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public StationStatus getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(StationStatus stationStatus) {
        this.stationStatus = stationStatus;
    }
}
