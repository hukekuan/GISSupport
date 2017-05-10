package com.gis3c.service.impl;

import com.gis3c.dao.HelloDao;
import com.gis3c.demo.Hello;
import com.gis3c.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hukekuan on 2016/12/28.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService {
    @Resource private HelloDao helloDao;

    @Override
    public String SayHello(){
        return helloDao.SayHello();
    }
}
