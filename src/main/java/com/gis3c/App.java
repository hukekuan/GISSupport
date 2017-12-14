package com.gis3c;

import com.gis3c.ol.service.MapService;
import com.gis3c.ol.service.impl.MapServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hukekuan on 2017/12/14.
 */
public class App {
    public static ApplicationContext ApplicationInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }
    public static void main(String[] args) {
        ApplicationContext context = ApplicationInit();
        MapService mapService = (MapService) context.getBean(MapService.class);
        System.out.println(mapService.findAllList());
    }
}
