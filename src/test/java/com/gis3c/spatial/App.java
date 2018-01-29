package com.gis3c.spatial;

import com.gis3c.common.bean.BeanUtil;
import com.gis3c.ol.entity.Layer;
import com.gis3c.ol.entity.Map;
import com.gis3c.ol.entity.Source;
import com.gis3c.ol.service.LayerService;
import com.gis3c.ol.service.MapService;
import com.gis3c.ol.service.SourceService;
import com.gis3c.spatial.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class App {
    public static ApplicationContext ApplicationInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static void main(String[] args) throws IllegalAccessException, IOException {
        ApplicationContext context = ApplicationInit();

        SourceService sourceService = context.getBean(SourceService.class);
        LayerService layerService = context.getBean(LayerService.class);
        MapService mapService = context.getBean(MapService.class);
        TestService testService = context.getBean(TestService.class);




//        Source source = sourceService.findSourceByName("cva");
//        System.out.println(source.getOptions());
//
//        Source newSource = new Source();
//        newSource.setSourceName("sdkqbigdata");
//        newSource.setType("ol.source.TileArcGISRest");
//        java.util.Map<String, Object> params = new HashMap<>();
//        params.put("url","http://58.56.98.79:8003/ArcGIS/rest/services/sdkqbigdata1/MapServer");
//
//        newSource.setOptions(params);
//        newSource.setDescription("山东省行政区图");
//
//        sourceService.insertSource(newSource);
//        System.out.println("插入成功");


//        List<Map> mapList = mapService.findMapsByByPage(10,0);
//        Map map = mapService.findMapById("fc813a1f-6a31-4202-9419-8d125ba203c9");
//        System.out.println(map);


//        List<Test> result = testService.allList();
//        Test test = result.get(0);
//        SimpleFeatureType type = test.createFeatureType();
//
//        System.out.println(type);
//        System.out.println(FeatureUtilities.JavaBeans2Json(result));

//        //地图接口
//        Map map = mapService.findMapById("83c734de-c010-4153-bf68-d291d715ac55");
        System.out.println(mapService.findMapsByPage(5,1));



//        Map map = new Map();
//        map.setMapId(UUID.randomUUID().toString());
//        map.setMapName("综合GIS系统");
//
//        java.util.Map<String,Object> view = new HashMap<>();
//        view.put("center",new Double[]{117.089151,36.738693});
//        view.put("projection","EPSG:4326");
//        view.put("minZoom",8);
//        view.put("maxZoom",18);
//        view.put("zoom",9);
//        map.setView(view);
//        map.setLogo(false);
//        map.setLayers(new String[][]{
//            {"TileLayer","182a8b18-d26f-43da-9b3a-6f90af4825ed"},
//            {"TileLayer","8c396460-9995-4387-8aa1-bb16c2595bba"},
//            {"TileLayer","ad433664-3b2c-4b1b-b271-519b7f647a11"}
//        });
//        mapService.insertMap(map);
//
//        System.out.println("插入成功");

        //图层接口
//        Layer layer = new Layer();
//        layer.setLayerName("streetmap");
//        layer.setAliasName("超图行政区图");
//        layer.setSource("d7cb5f6f-ee31-4a6e-b8fd-72603a066c2b");
//        layer.setType("ol.layer.Tile");
//        java.util.Map<String,Object> options = new HashMap<>();
//        options.put("projection","EPSG:4326");
//        layer.setOptions(options);
//        layerService.insertLayer(layer);
//        System.out.println("插入成功");


//资源接口
//        Wmts wmts = new Wmts();
//        wmts.setSourceId(UUID.randomUUID().toString());
//        wmts.setSourceName("山东省行政区图");
//        wmts.setUrl("http://www.sdmap.gov.cn/tileservice/SDPubMap");
//        wmts.setLayer("0");
//        wmts.setFormat("image/png");
//        wmts.setMatrixSet("tianditu2013");
//        wmts.setStyle("default");
//
//        sourceService.insertWmts(wmts);
//        System.out.println("插入成功");

//        Wmts wmts = sourceService.findWmtsById("b2729474-5988-410c-b6a0-8834b19d5832");
//        System.out.println(wmts.getUrl());



// 视图接口
//        View view = viewService.findeViewById("ee2f96a0-097a-4f0a-9767-f52b8dae28e0");
//        System.out.println("["+ ((Double[])view.getCenter())[0] + ", " + ((Double[])view.getCenter())[1] + "]");

//        View view = new View();
//        String id = UUID.randomUUID().toString();
//
//        view.setViewId(id);
//        System.out.println(view.getViewId());
//        view.setViewName("测试视图");
//        view.setCenter(new Double[]{117.089151, 36.738693});
//        view.setProjection("EPSG:4326");
//        view.setMinZoom(8);
//        view.setMaxZoom(18);
//        view.setZoom(9);
//
//        viewService.insertView(view);
//        System.out.println("插入成功");

//        MapService mapService = context.getBean(MapService.class);
//        Map map = mapService.findAllList().get(0);
//        String[][] controls = map.getControls();
//        System.out.println(controls);
    }
}
