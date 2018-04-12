package com.gis3c.spatial.service;

import java.util.Map;
import java.util.Set;

/**
 * Created by hukekuan on 2018/4/12.
 */
public interface RiverService {
    /**
     * 根据站点编号获取分段河流数据
     * @param stationCodes 站点编号
     * @param sufaceStations 站点编号和站点水质的集合
     * @return
     */
    public String findRiversByStationCodes(Set<String> stationCodes,Map<String,String> sufaceStations);

    /**
     * 根据河流编号获取分段河流数据
     * @param riverCodes 河流编号
     * @param sufaceStations 站点编号和站点水质的集合
     * @return
     */
    public String findRiversByRiverCodes(Set<String> riverCodes,Map<String,String> sufaceStations);
}
