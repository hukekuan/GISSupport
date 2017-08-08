package com.c3gis.spatial.entity;/**
 * Created by hukekuan on 17-7-10.
 */

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.Polygon;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * @author hukekuan
 * @Description 单面数据
 * @date 2017-07-10 下午4:23
 */
public class C3Polygon extends Polygon implements IPolygon {
    public C3Polygon(LinearRing shell, LinearRing[] holes, GeometryFactory factory) {
        super(shell, holes, factory);
    }

    @Override
    public CoordinateReferenceSystem GetCRS() {
        return null;
    }
}
