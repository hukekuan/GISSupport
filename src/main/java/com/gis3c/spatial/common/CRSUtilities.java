package com.gis3c.spatial.common;/**
 * Created by hukekuan on 17-7-10.
 */

import com.vividsolutions.jts.geom.Geometry;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.Transaction;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.filter.FilterFactory2;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

import java.io.IOException;

/**
 * @author hukekuan
 * @Description 空间坐标系相关方法
 * @date 2017-07-10 下午6:31
 */
public class CRSUtilities {
    private final static FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2(null);

    public static CoordinateReferenceSystem GetCRSFromSRID(String sridNumber)
            throws NoSuchAuthorityCodeException, FactoryException {
        CoordinateReferenceSystem crs = null;
        if(sridNumber == null || "".equals(sridNumber)){
            return DefaultGeographicCRS.WGS84;
        }
        crs = CRS.decode("epsg:" + sridNumber);

        return crs;
    }

    /**
     * 生成坐标系转变对象
     * @param rawSridNumber, 如 "4326"
     * @param goalSridNumber, 如 "4326"
     * @return
     * @throws FactoryException
     */
    public static MathTransform MathTransform(String rawSridNumber, String goalSridNumber)
            throws FactoryException{
        CoordinateReferenceSystem rawCRS = null;
        CoordinateReferenceSystem goalCRS = null;
        if(rawSridNumber == null || "".equals(rawSridNumber)
                || goalSridNumber == null || "".equals(goalSridNumber)){
            throw new IllegalArgumentException("参数输入有误");
        }
        rawCRS = GetCRSFromSRID(rawSridNumber);
        goalCRS = GetCRSFromSRID(goalSridNumber);

        return CRS.findMathTransform(rawCRS, goalCRS, true);
    }

    public static Geometry CRSTransform(Geometry geometry, MathTransform transform)
            throws IOException {
        Geometry resultGeometry = null;
        Transaction transaction = new DefaultTransaction("Project");
        try {
            resultGeometry = JTS.transform(geometry, transform);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }finally{
            transaction.close();
        }
        return resultGeometry;
    }
}
