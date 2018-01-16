package com.gis3c.spatial.common;

import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by hukekuan on 2018/1/16.
 */
public class FeatureUtilities {

    /**
     * @author hukekuan
     * @Description 对象列表转 SimpleFeatureCollection
     * @param simpleFeatureList
     * @return SimpleFeatureCollection
     * @date 2017-07-11 上午9:46
     */
    public static SimpleFeatureCollection Features2Collection(List<SimpleFeature> simpleFeatureList){
        SimpleFeatureCollection simpleFeatureCollection = null;
        if(simpleFeatureList != null && simpleFeatureList.size() > 0){
            simpleFeatureCollection = DataUtilities.collection(simpleFeatureList);
        }
        return simpleFeatureCollection;
    }

    /**
     * @author hukekuan
     * @Description 对象列表转 GeoJSON
     * @param simpleFeatureList
     * @return GeoJSON字符串
     * @throws IOException
     */
    public static String Features2GeoJSON(List<SimpleFeature> simpleFeatureList)
            throws IOException {
        String result = null;
        SimpleFeatureCollection simpleFeatureCollection = null;

        if(simpleFeatureList != null && simpleFeatureList.size() > 0){
            FeatureJSON fjson = new FeatureJSON();
            StringWriter writer = new StringWriter();
            simpleFeatureCollection = Features2Collection(simpleFeatureList);
            fjson.writeFeatureCollection(simpleFeatureCollection, writer);
            result = writer.toString();
        }

        return result;
    }

    /**
     * @author hukekuan
     * @Description SimpleFeatureCollection转 GeoJSON
     * @param featureCollection
     * @return GeoJSON字符串
     * @throws IOException
     */
    public static String FeatureCollection2GeoJson(SimpleFeatureCollection featureCollection)
            throws IOException{
        String result = null;
        FeatureJSON fjson;
        StringWriter writer;
        if(featureCollection != null && featureCollection.size() > 0){
            fjson = new FeatureJSON();
            writer = new StringWriter();
            fjson.writeFeatureCollection(featureCollection, writer);
            result = writer.toString();
        }
        return result;
    }

    /**
     * @author hukekuan
     * @Description GeoJSON转SimpleFeatureCollection
     * @param geojsonStr geojson字符串
     * @return SimpleFeatureCollection
     * @throws IOException
     */
    public static SimpleFeatureCollection GeoJson2FeatureCollection(String geojsonStr)
            throws IOException{
        SimpleFeatureCollection result = null;
        FeatureJSON fjson = new FeatureJSON();

        result = (SimpleFeatureCollection) fjson.readFeatureCollection(new ByteArrayInputStream(geojsonStr.getBytes()));

        return result;
    }
}
