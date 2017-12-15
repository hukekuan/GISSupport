package com.gis3c;

import com.gis3c.ol.service.MapService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gis3c.ol.entity.Map;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class App {
    public static ApplicationContext ApplicationInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static void main(String[] args) {
        ApplicationContext context = ApplicationInit();
        MapService mapService = context.getBean(MapService.class);
        Map map = mapService.findAllList().get(0);
        String[][] controls = map.getControls();
        System.out.println(controls);
    }
}
