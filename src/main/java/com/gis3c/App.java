package com.gis3c;

import com.gis3c.service.HelloService;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;

public class App {
    public static ApplicationContext ContextInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context =ContextInit();
//        HelloService obj = (HelloService) context.getBean("helloService");
//        System.out.println(obj.SayHello());
        // display a data store file chooser dialog for shapefiles
        File file = JFileDataStoreChooser.showOpenFile("shp", null);
        if (file == null) {
            return;
        }

        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);

        // Now display the map
        JMapFrame.showMap(map);
    }
}