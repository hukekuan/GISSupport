package com.gis3c.demo.impl;
import com.gis3c.demo.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello")
public class HelloImpl implements Hello{
    private String name;

    @Override
    public String SayHello(){
        return getName();
    }

    public String getName() {
        return name;
    }

    @Autowired
    public void setName(
//            @Value(value = "#{configProperties['gis.name']}")
            @Value(value = "HUKEKUAN") String name) {
        this.name = name;
    }
}
