package com.gis3c;

import com.gis3c.entity.C3Map;
import org.geotools.data.FeatureSource;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.styling.SLD;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.geotools.swing.dialog.JExceptionReporter;
import org.geotools.swing.styling.JSimpleStyleDialog;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.File;
import java.io.IOException;

public class Main {
    public static StyleFactory styleFactory = CommonFactoryFinder.getStyleFactory();
    public static Style createStyle(File file, FeatureSource featureSource) {
        File sld = toSLDFile(file);
        if (sld != null) {
            return createFromSLD(sld);
        }

        SimpleFeatureType schema = (SimpleFeatureType)featureSource.getSchema();
        return JSimpleStyleDialog.showDialog(null, schema);
    }
    public static File toSLDFile(File file)  {
        String path = file.getAbsolutePath();
        String base = path.substring(0,path.length()-4);
        String newPath = base + ".sld";
        File sld = new File( newPath );
        if( sld.exists() ){
            return sld;
        }
        newPath = base + ".SLD";
        sld = new File( newPath );
        if( sld.exists() ){
            return sld;
        }
        return null;
    }
    public static Style createFromSLD(File sld) {
        try {
            SLDParser stylereader = new SLDParser(styleFactory, sld.toURI().toURL());
            Style[] style = stylereader.readXML();
            return style[0];

        } catch (Exception e) {
            JExceptionReporter.showDialog(e, "Problem creating style");
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        File file = JFileDataStoreChooser.showOpenFile("shp",null);
        if(file == null){
            return;
        }
        File sldFile = new File("D:\\f\\shp\\shijie.sld");


        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        C3Map map = new C3Map();
        map.setTitle("Quickstart");
//        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Style style = createStyle(file, featureSource);

        Layer layer = new FeatureLayer(featureSource,style);
        map.addLayer(layer);
//        map.saveImage("D://mapimage//1.jpg",256);

        JMapFrame.showMap(map);
    }


}
