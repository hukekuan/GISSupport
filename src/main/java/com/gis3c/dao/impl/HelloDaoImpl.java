package com.gis3c.dao.impl;

import com.gis3c.dao.HelloDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by hukekuan on 2016/12/28.
 */

@Repository
public class HelloDaoImpl extends SqlSessionDaoSupport implements HelloDao {
    @Resource(name="sqlSessionFactory_GIS") private SqlSessionFactory sqlSessionFactory;

    @Override
    public String SayHello(){
        return "hello wold";
    }

    @PostConstruct
    public void injectSessionFactory(){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
