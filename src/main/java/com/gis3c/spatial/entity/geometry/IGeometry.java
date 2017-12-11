package com.gis3c.spatial.entity.geometry;

import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * Created by hukekuan on 17-7-10.
 */
public interface IGeometry {
    public CoordinateReferenceSystem GetCRS();
}
