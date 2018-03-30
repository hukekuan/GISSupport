package com.gis3c.spatial.common;


import com.gis3c.spatial.entity.BaseFeature;
import com.vividsolutions.jts.geom.Geometry;
import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.filter.text.cql2.CQL;
import org.geotools.filter.text.cql2.CQLException;
import org.geotools.geojson.feature.FeatureJSON;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterFactory2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * Created by hukekuan on 2018/1/16.
 */
public class FeatureUtilities {
    /**
     * SimpleFeature转GeoJSON字符串
     * @param simpleFeature
     * @return
     */
    public static String Feature2Json(SimpleFeature simpleFeature) throws IOException {
        String result = null;
        FeatureJSON fjson = new FeatureJSON();
        StringWriter writer = new StringWriter();
        fjson.writeFeature(simpleFeature,writer);
        result = writer.toString();
        return result;
    }

    /**
     *
     * @param t 继承于BaseFeature的实体类转换成GeoJSON字符串
     * @param featureIndex
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends BaseFeature> String JavaBean2Json(T t,String featureIndex)
            throws IOException {
        SimpleFeature simpleFeature =t.javaBean2SimpleFeature(featureIndex);
        return Feature2Json(simpleFeature);
    }

    /**
     * @Description: 将java bean转换为Simple Feature
     * @param beansList
     * @return
     * @throws IllegalAccessException
     */
    public static List<SimpleFeature> JavaBeans2Features(List<? extends BaseFeature> beansList) {
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        if(beansList != null || beansList.size() != 0){
            for(int i = 0,len = beansList.size();i < len;i++){
                simpleFeatureList.add(beansList.get(i).javaBean2SimpleFeature(Integer.toString(i)));
            }
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
        }else {
            result="{\"type\": \"FeatureCollection\", \"features\": []}";
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
        }else {
            result = "{'type': 'FeatureCollection', 'features': []}";
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

    public static SimpleFeatureCollection FeatureCollectionFilter(
            SimpleFeatureCollection featureCollection, Geometry geometry,String whereClause) throws CQLException {
        SimpleFeatureCollection resultCollection = null;
        if(featureCollection == null || featureCollection.size() == 0){
            return featureCollection;
        }
        if(geometry == null && (whereClause == null || "".equals(whereClause))){
            throw new IllegalArgumentException("参数输入有误");
        }

        FilterFactory2 filterFactory = CommonFactoryFinder.getFilterFactory2();
        List<Filter> filterList = new ArrayList<>();
        if(geometry != null){
            if(geometry.getSRID() == 0){
                geometry.setSRID(4326);
            }
            String geometryPropertyName = featureCollection.getSchema().getGeometryDescriptor().getLocalName();
            filterList.add(filterFactory.intersects(filterFactory.property(geometryPropertyName), filterFactory.literal(geometry)));
        }
        if(whereClause != null && !"".equals(whereClause)){
            filterList.add(CQL.toFilter(whereClause));
        }
        if(filterList.size() == 1){
            resultCollection = featureCollection.subCollection(filterList.get(0));
        }else if(filterList.size() == 2){
            resultCollection = featureCollection.subCollection(filterFactory.and(filterList.get(0),filterList.get(1)));
        }
        return resultCollection;
    }
}
