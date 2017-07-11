package com.gis3c;

import com.gis3c.entity.C3Map;
import com.gis3c.entity.GeoCity;
import com.gis3c.service.PostGISService;
import no.ecc.vectortile.VectorTileDecoder;
import no.ecc.vectortile.VectorTileEncoder;
import org.apache.commons.collections.map.HashedMap;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.styling.SLD;
import org.geotools.styling.SLDParser;
import org.geotools.styling.Style;
import org.geotools.styling.StyleFactory;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static ApplicationContext ContextInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static StyleFactory styleFactory = CommonFactoryFinder.getStyleFactory();
//    public static Style createStyle(File file, FeatureSource featureSource) {
//        File sld = toSLDFile(file);
//        if (sld != null) {
//            return createFromSLD(sld);
//        }
//
//        SimpleFeatureType schema = (SimpleFeatureType)featureSource.getSchema();
//        return JSimpleStyleDialog.showDialog(null, schema);
//    }
//    public static File toSLDFile(File file)  {
//        String path = file.getAbsolutePath();
//        String base = path.substring(0,path.length()-4);
//        String newPath = base + ".sld";
//        File sld = new File( newPath );
//        if( sld.exists() ){
//            return sld;
//        }
//        newPath = base + ".SLD";
//        sld = new File( newPath );
//        if( sld.exists() ){
//            return sld;
//        }
//        return null;
//    }
//    public static Style createFromSLD(File sld) {
//        try {
//            SLDParser stylereader = new SLDParser(styleFactory, sld.toURI().toURL());
//            Style[] style = stylereader.readXML();
//            return style[0];
//
//        } catch (Exception e) {
//            JExceptionReporter.showDialog(e, "Problem creating style");
//        }
//        return null;
//    }
    public static void StyleTest()throws IOException{
        File file = JFileDataStoreChooser.showOpenFile("shp",null);
        if(file == null){
            return;
        }
        File sldFile = new File("D:\\f\\shp\\shijie.sld");
        SLDParser styleReader = new SLDParser(styleFactory,sldFile.toURI().toURL());
        Style[] styles = styleReader.readXML();
        Style style1 = styles[0];

        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        ((ShapefileDataStore)store).setCharset(Charset.forName("GBK"));
        SimpleFeatureSource featureSource = store.getFeatureSource();

        C3Map map = new C3Map();
        map.setTitle("Quickstart");
        Style style = SLD.createSimpleStyle(featureSource.getSchema());

        Layer layer = new FeatureLayer(featureSource,style1);
        map.addLayer(layer);
        map.saveImage("D://mapimage//1.jpg",256);
        System.out.println("image has saved");
    }
    public static void copy(Reader in,Writer out) throws IOException {
        int c = -1;
        while((c = in.read()) != -1) {
            out.write(c);
        }
    }
    public static void VectorTilesTest()throws IOException{
        ApplicationContext context =ContextInit();
        PostGISService postGISService = (PostGISService) context.getBean("postGISService");
        List<GeoCity> geoCities = postGISService.AllCities();

        VectorTileEncoder encoder = new VectorTileEncoder();
        VectorTileDecoder d = new VectorTileDecoder();
        byte[] encoded;
        geoCities.forEach(city -> {
            Map<String,String> cityAttr = new HashMap<>();
            cityAttr.put("name",city.getName());
            cityAttr.put("code",city.getCode());
//            encoder.addFeature("city",cityAttr,city.getGeom());
        });
        encoded = encoder.encode();

        System.out.println(new String(encoded, "utf8"));
        try(FileOutputStream fos = new FileOutputStream("/home/hukekuan/0.vector.pbf",true)){
            fos.write(encoded);
            fos.flush();
        }
    }
    public static void main(String[] args) throws IOException {
        VectorTilesTest();
    }


}
