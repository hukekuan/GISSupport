package com.gis3c.spatial.entity.geometry;/**
 * Created by hukekuan on 17-7-10.
 */

import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * @author hukekuan
 * @Description 折线数据
 * @date 2017-07-10 下午4:21
 */
public class C3LineString extends LineString implements ILineString {
    public C3LineString(CoordinateSequence points, GeometryFactory factory) {
        super(points, factory);
    }

    @Override
    public CoordinateReferenceSystem GetCRS() {
        return null;
    }
}
