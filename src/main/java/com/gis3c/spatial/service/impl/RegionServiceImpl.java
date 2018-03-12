package com.gis3c.spatial.service.impl;

import com.gis3c.common.exception.BusinessException;
import com.gis3c.spatial.common.FeatureUtilities;
import com.gis3c.spatial.dao.RegionDao;
import com.gis3c.spatial.entity.Region;
import com.gis3c.spatial.entity.RegionCenter;
import com.gis3c.spatial.entity.RegionType;
import com.gis3c.spatial.service.RegionService;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by hukekuan on 2018/3/9.
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDao;

    @Override
    public String findRegionByCode(String reginCode) {
        String regionJson = null;
        Region queryRegion = regionDao.findRegionByCode(
                regionTableByCode(reginCode).getName(),
                reginCode
        );
        try {
            regionJson = FeatureUtilities.JavaBean2Json(queryRegion,"1");
        } catch (IOException e) {
            throw new BusinessException("Region实体转GeoJSON出错");
        }
        return regionJson;
    }

    @Override
    public String findRgionCenterByCode(String reginCode) {
        return regionDao.findRgionCenterByCode(
                regionTableByCode(reginCode).getName(),
                reginCode
        );
    }

    @Override
    public String findAroundRegions(String reginCode) {
        String result = null;
        List<Region> regionLsit = regionDao.findAroundRegions(
                regionTableByCode(reginCode).getName(),
                reginCode
        );
        try {
            result = FeatureUtilities.JavaBeans2Json(regionLsit);
        } catch (IllegalAccessException | IOException e) {
            throw new BusinessException("Region实体转GeoJSON出错");
        }
        return result;
    }

    @Override
    public String findRegionsByParentCode(String parentCode) {
        String result = null;

        RegionType parentType = regionTableByCode(parentCode);
        RegionType regionType = parentType.ChildType();
        if (regionType == null) {
            throw new BusinessException("新政区编号输入错误");
        }

        List<Region> regionLsit = regionDao.findRegionsByParentCode(
                regionType.getName(),
                getlikeCode(parentCode)
        );

        try {
            result = FeatureUtilities.JavaBeans2Json(regionLsit);
        } catch (IllegalAccessException | IOException e) {
            throw new BusinessException("Region实体转GeoJSON出错");
        }
        return result;
    }

    @Override
    public List<RegionCenter> findRegionCentersByParentCode(String parentCode) {
        RegionType parentType = regionTableByCode(parentCode);
        RegionType regionType = parentType.ChildType();
        if (regionType == null) {
            throw new IllegalArgumentException("新政区编号输入错误");
        }

        return regionDao.findRegionCentersByParentCode(
                regionType.getName(),
                getlikeCode(parentCode)
        );
    }

    /**
     * 根据行政区编号信息获取对应的新政区类型
     *
     * @param regionCode
     * @return
     */
    private RegionType regionTableByCode(String regionCode) {
        if (regionCode == null || (regionCode.length() != 6 && regionCode.length() != 12)) {
            throw new IllegalArgumentException("行政区编号格式错误");
        }
        RegionType regionTable = null;
        int codeLength = regionCode.length();
        String checkedCode = regionCode.substring(codeLength - 3, codeLength);
        if ("000".equals(checkedCode)) {
            regionTable = codeLength == 6 ? RegionType.PROVINCE : RegionType.TOWN;
        } else if (checkedCode.endsWith("00")) {
            regionTable = RegionType.CITY;
        } else {
            regionTable = RegionType.COUNTRY;
        }
        return regionTable;
    }

    /**
     * 获取用于查询子行政区的行政区编号
     *
     * @param regionCode
     * @return
     */
    private String getlikeCode(String regionCode) {
        String liekCode = null;
        if (regionCode.endsWith("0000")) {
            liekCode = regionCode.substring(0, 2);
        } else if (regionCode.endsWith("00")) {
            liekCode = regionCode.substring(0, 4);
        } else {
            liekCode = regionCode;
        }
        return liekCode;
    }
}
