package com.gis3c.spatial.common;


import com.gis3c.spatial.entity.BaseFeature;
import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hukekuan on 2018/1/16.
 */
public class FeatureUtilities {
    /**
     * @Description: 将java bean转换为Simple Feature
     * @param beansList
     * @return
     * @throws IllegalAccessException
     */
    public static List<SimpleFeature> JavaBeans2Features(List<? extends BaseFeature> beansList)
            throws IllegalAccessException {
        if(beansList == null || beansList.size() == 0){
            throw new NullPointerException("参数无效");
        }
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        SimpleFeatureType featureType = beansList.get(0).createFeatureType();
        for(int i = 0,len = beansList.size();i < len;i++){
            simpleFeatureList.add(beansList.get(i).javaBean2SimpleFeature(featureType,Integer.toString(i)));
        }

        return simpleFeatureList;
    }

    /**
     * @Description: 将java bean转换SimpleFeatureCollection
     * @param beansList
     * @return
     * @throws IllegalAccessException
     */
    public static SimpleFeatureCollection JavaBeans2Collections(List<? extends BaseFeature> beansList)
            throws IllegalAccessException {
        List<SimpleFeature> simpleFeatureList = JavaBeans2Features(beansList);
        return Features2Collection(simpleFeatureList);
    }

    /**
     * @Description: 将java bean转换GeoJSON
     * @param beansList
     * @return
     * @throws IllegalAccessException
     * @throws IOException
     */
    public static String JavaBeans2Json(List<? extends BaseFeature> beansList)
            throws IllegalAccessException, IOException {
        List<SimpleFeature> simpleFeatureList = JavaBeans2Features(beansList);
        return Features2GeoJSON(simpleFeatureList);
    }

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
