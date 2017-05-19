package com.gis3c;

import com.gis3c.entity.C3Map;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = JFileDataStoreChooser.showOpenFile("shp",null);
        if(file == null){
            return;
        }

        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        C3Map map = new C3Map();
        map.setTitle("Quickstart");
        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource,style);
        map.addLayer(layer);
//        map.saveImage("D://mapimage//1.jpg",256);

        JMapFrame.showMap(map);
    }
}
