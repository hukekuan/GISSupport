package com.gis3c.spatial.service.impl;

import com.gis3c.common.exception.BusinessException;
import com.gis3c.spatial.common.FeatureUtilities;
import com.gis3c.spatial.dao.RiverDao;
import com.gis3c.spatial.entity.SeparatedRiver;
import com.gis3c.spatial.service.RiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by hukekuan on 2018/4/12.
 */
@Service
public class RiverServiceImpl implements RiverService {
    @Autowired
    private RiverDao riverDao;

    @Override
    public String findRiversByStationCodes(Set<String> stationCodes) {
        String riverJson = null;
        List<SeparatedRiver> riverList
                = riverDao.findRiversByStationCodes(stationCodes);
        try {
            riverJson = FeatureUtilities.JavaBeans2Json(riverList);
        } catch (IllegalAccessException | IOException e) {
            throw new BusinessException("River实体转GeoJSON出错");
        }
        return riverJson;
    }

    @Override
    public String findRiversByRiverCodes(Set<String> riverCodes) {
        String riverJson = null;
        List<SeparatedRiver> riverList
                = riverDao.findRiversByRiverCodes(riverCodes);
        try {
            riverJson = FeatureUtilities.JavaBeans2Json(riverList);
        } catch (IllegalAccessException | IOException e) {
            throw new BusinessException("River实体转GeoJSON出错");
        }
        return riverJson;
    }
}
