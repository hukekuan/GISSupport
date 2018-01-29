package com.gis3c.common.bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hukekuan on 2018/1/29.
 */
public class BeanUtil {
    public static Map<String,Object> Bean2Map(Object instance,Class cls) throws IllegalAccessException {
        Map<String,Object> result = new HashMap<>();
        Field[] fields = cls.getDeclaredFields();
        Object value;
        Map<String,Object> mapValue;
        for(Field field:fields){
            field.setAccessible(true);
            value = field.get(instance);
            if(value instanceof HashMap){
                mapValue = (HashMap<String, Object>) value;
                for(Map.Entry<String,Object> entry:mapValue.entrySet()){
                    result.put(entry.getKey(),entry.getValue());
                }
            }else{
                result.put(field.getName(),value);
            }
        }
        return result;
    }
}
