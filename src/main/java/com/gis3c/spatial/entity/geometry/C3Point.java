package com.gis3c.spatial.entity.geometry;/**
 * Created by hukekuan on 17-7-10.
 */

import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * @author hukekuan
 * @Description 自定义点数据
 * @date 2017-07-10 下午4:19
 */
public class C3Point extends Point implements IPoint {
    public C3Point(CoordinateSequence coordinates, GeometryFactory factory) {
        super(coordinates, factory);
    }

    @Override
    public CoordinateReferenceSystem GetCRS() {
        return null;
    }
}
