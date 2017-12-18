package com.gis3c;

import com.gis3c.ol.entity.View;
import com.gis3c.ol.entity.layer.TileLayer;
import com.gis3c.ol.entity.source.Wmts;
import com.gis3c.ol.service.LayerService;
import com.gis3c.ol.service.MapService;
import com.gis3c.ol.service.SourceService;
import com.gis3c.ol.service.ViewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gis3c.ol.entity.Map;

import java.util.UUID;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class App {
    public static ApplicationContext ApplicationInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static void main(String[] args) {
        ApplicationContext context = ApplicationInit();
        ViewService viewService = context.getBean(ViewService.class);
        SourceService sourceService = context.getBean(SourceService.class);
        LayerService layerService = context.getBean(LayerService.class);
        MapService mapService = context.getBean(MapService.class);



        //图层接口
//        TileLayer wmtsLayer = new TileLayer();
//        wmtsLayer.setLayerId(UUID.randomUUID().toString());
//        wmtsLayer.setLayerName("全国行政区图层");
//        wmtsLayer.setSource(new String[]{"Wmts","b2729474-5988-410c-b6a0-8834b19d5832"});
//        layerService.insertTileLayer(wmtsLayer);
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
