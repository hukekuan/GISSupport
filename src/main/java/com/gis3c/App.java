package com.gis3c;

import com.gis3c.ol.entity.View;
import com.gis3c.ol.service.MapService;
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
        View view = new View();
        String id = UUID.randomUUID().toString();

        view.setViewId(id);
        System.out.println(view.getViewId());
        view.setViewName("测试视图");
        view.setCenter(new Double[]{117.089151, 36.738693});
        view.setProjection("EPSG:4326");
        view.setMinZoom(8);
        view.setMaxZoom(18);
        view.setZoom(9);

        viewService.insertView(view);
        System.out.println("插入成功");

//        MapService mapService = context.getBean(MapService.class);
//        Map map = mapService.findAllList().get(0);
//        String[][] controls = map.getControls();
//        System.out.println(controls);
    }
}
