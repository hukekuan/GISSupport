package com.gis3c.spatial.service;

import java.util.Set;

/**
 * Created by hukekuan on 2018/4/12.
 */
public interface RiverService {
    public String findRiversByStationCodes(Set<String> stationCodes);
    public String findRiversByRiverCodes(Set<String> riverCodes);
}
