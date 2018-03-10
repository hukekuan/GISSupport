package com.gis3c.spatial;

import com.gis3c.common.bean.BeanUtil;
import com.gis3c.ol.entity.*;
import com.gis3c.ol.entity.Map;
import com.gis3c.ol.service.LayerService;
import com.gis3c.ol.service.MapService;
import com.gis3c.ol.service.SourceService;
import com.gis3c.spatial.common.FeatureUtilities;
import com.gis3c.spatial.entity.Region;
import com.gis3c.spatial.entity.RegionType;
import com.gis3c.spatial.service.RegionService;
import com.gis3c.spatial.service.TestService;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class App {
    public static ApplicationContext ApplicationInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static void main(String[] args) throws IllegalAccessException, IOException {
        ApplicationContext context = ApplicationInit();

//        SourceService sourceService = context.getBean(SourceService.class);
//        LayerService layerService = context.getBean(LayerService.class);
//        MapService mapService = context.getBean(MapService.class);
//        TestService testService = context.getBean(TestService.class);
        RegionService regionService = context.getBean(RegionService.class);

        List<Region> regionList = regionService.findRegionsByParentCode("370300");

        regionList.stream().forEach(region -> System.out.println(region.getRegionName() + "-->" + region.getReginCode()));

//        String region = regionService.findRegionCentersByParentCode("370100");
//        System.out.println(regionService.findAroundRegions("370100").size());
//
//        List<SimpleFeature> featureList = FeatureUtilities.JavaBeans2Features(regionList);
//
//        System.out.println(FeatureUtilities.Features2GeoJSON(featureList));
//        RegionType r1  = RegionType.CITY;
//        RegionType r2  = RegionType.CITY;
//
//        System.out.println(r1.ChildType().getName());







//        List<LayerSource> layerSources
//                = layerService.findLayerByIds(new String[]{"aabb842e-239e-491d-9c70-a2cec1f65886"});
//        List<String> layerIdList = new ArrayList<>(Arrays.asList(new String[]{
//                "a2d69fcd-fa4a-4fe5-8696-ae3e30042126",
//                "aabb842e-239e-491d-9c70-a2cec1f65886"
//        }));
//        List<MapLayer> result = layerService.findSimpleLayerList(layerIdList);
//        System.out.println(result.size());
//        System.out.println(result.get(0).getLayer().getLayerId());
//        System.out.println(result.get(1).getLayer().getLayerId());


//        String result = testList.stream().filter(test-> "2".equals(test)).findFirst().orElse(null);
//        System.out.println(result);
//        System.out.println(testList);
//        System.out.println(testList.get(0));
//        testList.remove(0);
//        System.out.println(testList);
//        System.out.println(testList.get(0));


//        List<LayerSource> layerSources = layerService.findLayerList();
//        System.out.println(layerSources.get(0));

//        List<MapLayer> layerList = layerService.findSimpleLayerList("e8819b8e-9397-4609-8b23-9f18c9588d6b");
//        System.out.println(layerList.get(2).getBinded());

//        java.util.Map<String,Object> layerOptions = new HashMap<>();
//        layerOptions.put("a","aaaaaaaa");
//        layerOptions.put("b","bbbbbbbb");
//        layerOptions.put("c","cccccccc");
//        layerService.bindVectorSource(
//                "9e3a9812-5921-45c9-9043-e52d81fff1bb",
//                "4f21a864-3e81-4ee1-97b7-6d18a876b5c1",
//                layerOptions);
//        System.out.println("更新成功");


//        Integer result = layerService.bindSource("aabb842e-239e-491d-9c70-a2cec1f65886","d67de989-d351-4ba2-b3ac-021130ae19d4");
//        System.out.println(result);

//        Layer queryLayer = layerService.findeLayerById("123");
//        System.out.println(queryLayer);

//        List<Source> sourceList = sourceService.findSourceByType(new String[]{"ol.source.WMTS"},"EPSG:4326");
//
//        System.out.println(sourceList);
//        sourceList.forEach(u -> System.out.println(u));

//        String source = Optional
//                .ofNullable(layerService.findeLayerById("d804360f"))
//                .map(layer -> layer.getSource())
//                .orElse("");
//
//        System.out.println("".equals(source));


//        Layer layer = layerService.findeLayerById("d804360f-eb5f-4e29-94ab-fdafbf224e02");
//        System.out.println(layer.getExtent());

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

//        System.out.println(mapService.findMapsByPage(5,1));

//        Set<String> mapIds = new HashSet<>();
//        mapIds.add("e49eed64-433b-4637-832e-b7292a867ba1");
//        mapService.deleteMapsById(mapIds);
//        System.out.println("删除成功");

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
//        map.setLayers(new String[]{
//                "182a8b18-d26f-43da-9b3a-6f90af4825ed",
//                "8c396460-9995-4387-8aa1-bb16c2595bba",
//                "ad433664-3b2c-4b1b-b271-519b7f647a11"
//        });
//        mapService.insertMap(map);
//
//        System.out.println("插入成功");

//        mapService.bindLayer("15a67947-8dc7-46f4-bc06-5c2fc51609d9",new String[]{
//                "e8819b8e-9397-4609-8b23-9f18c9588d6b",
//                "9e3a9812-5921-45c9-9043-e52d81fff1bb",
//                "ea6444b3-710f-4516-af9a-aa8270276883",
//                "aabb842e-239e-491d-9c70-a2cec1f65886"
//        });
//        System.out.println("修改成功");

        //图层接口
//        Layer layer = new Layer();
//        layer.setLayerName("sdkqbigdata");
//        layer.setAliasName("大屏行政区");
//        layer.setType("ol.layer.Tile");
//        layer.setProjection("EPSG:3857");
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
