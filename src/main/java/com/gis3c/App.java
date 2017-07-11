package com.gis3c;

import com.gis3c.entity.GeoCity;
import com.gis3c.service.HelloService;
import com.gis3c.service.PostGISService;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static ApplicationContext ContextInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        ApplicationContext context =ContextInit();
        PostGISService postGISService = (PostGISService) context.getBean("postGISService");
        List<GeoCity> geoCities = postGISService.AllCities();
        List<SimpleFeature> simpleFeatureList = new ArrayList<>();
        SimpleFeatureType simpleFeatureType = geoCities.get(0).createFeatureType();
        for(int i = 0,len = geoCities.size();i < len;i++){
            simpleFeatureList.add(geoCities.get(i).attribute2Feature(simpleFeatureType,Integer.toString(i)));
        }
        System.out.println(GeoCity.Attributes2GeoJSON(simpleFeatureList));
    }
}