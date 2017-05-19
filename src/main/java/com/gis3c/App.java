package com.gis3c;

import com.gis3c.entity.GeoCity;
import com.gis3c.service.HelloService;
import com.gis3c.service.PostGISService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static ApplicationContext ContextInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context =ContextInit();
        HelloService obj = (HelloService) context.getBean("helloService");
        PostGISService postGISService = (PostGISService) context.getBean("postGISService");

//        List<Map<String,Object>> columns = new ArrayList<>();
//        Map<String,Object> column = new HashMap<>();
//        column.put("columnName","fid");
//        column.put("typeCode",1);
//        columns.add(column);
//
//        column = new HashMap<>();
//        column.put("columnName","name");
//        column.put("typeCode",3);
//        columns.add(column);
//
//        column = new HashMap<>();
//        column.put("columnName","geom");
//        column.put("typeCode",91);
//        columns.add(column);
//
//        postGISService.CommonCreateTable("test","geom",columns);
//
//        System.out.println(obj.SayHello());

        Optional<GeoCity> result = postGISService.AllCities().stream()
                .filter(GeoCity::isDefaut)
                .skip(3)
//                .map(GeoCity::getName)
//                .anyMatch(GeoCity::isZB)
//                .findAny();
                  .findFirst();
//                .collect(Collectors.toList());

//        result.forEach(item->{
//            System.out.println(item.getName());
//        });
        result.ifPresent(item ->System.out.println(item.getName()));
    }
}