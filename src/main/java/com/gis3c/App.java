package com.gis3c;

import com.gis3c.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static ApplicationContext ContextInit(){
        return new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    }

    public static void main(String[] args){
        ApplicationContext context =ContextInit();

        HelloService obj = (HelloService) context.getBean("helloService");

        System.out.println(obj.SayHello());
    }
}