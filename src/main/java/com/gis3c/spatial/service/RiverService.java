package com.gis3c.spatial.service;

import com.gis3c.spatial.entity.ModelRiver;

import java.util.List;
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

    /**
     * 获取500米分段河流河流名称和别名
     * @return
     */
    public List<ModelRiver> findModelRiverInfo();

    /**
     * 根据河流名称获取500米分段河流GeoJSON数据
     * @param riverName
     * @return
     */
    public String findModelRiverByName(String riverName);
}
