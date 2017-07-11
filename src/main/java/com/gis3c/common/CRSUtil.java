package com.gis3c.common;/**
 * Created by hukekuan on 17-7-10.
 */

import org.geotools.factory.CommonFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.filter.FilterFactory2;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * @author hukekuan
 * @Description 空间坐标系相关方法
 * @date 2017-07-10 下午6:31
 */
public class CRSUtil {
    private final static FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2(null);

    public static CoordinateReferenceSystem GetCRSFromSRID(String sridNumber)
            throws NoSuchAuthorityCodeException, FactoryException {
        CoordinateReferenceSystem crs = null;
        if(sridNumber == null || "".equals(sridNumber)){
            return DefaultGeographicCRS.WGS84;
        }
        crs = CRS.decode("EPSG:" + sridNumber);

        return crs;
    }
}
