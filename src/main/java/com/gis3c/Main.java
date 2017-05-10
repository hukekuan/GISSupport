package com.gis3c;

import com.gis3c.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hukekuan on 2016/12/28.
 */
public class Main {
    @Autowired private HelloService helloService;

    public void Test(){
        System.out.println(helloService.SayHello());
    }
}
