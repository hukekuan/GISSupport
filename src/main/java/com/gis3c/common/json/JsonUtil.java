package com.gis3c.common.json;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.io.OutputStream;

/**
 * Created by hukekuan on 2017/12/19.
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = null;
    private static Log log = LogFactory.getLog(JsonUtil.class);
    static {

        objectMapper = new ObjectMapper();

//        objectMapper.setDateFormat(new SimpleDateFormat(FormatUtil.DATE_FORMAT_LONG));
//        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
//        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
//        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
    }

    public static String Stringify(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String Stringify(Object object, String... properties){
        try {
            return objectMapper
                    .writer(new SimpleFilterProvider().addFilter(
                            AnnotationUtils.getValue(
                                    AnnotationUtils.findAnnotation(object.getClass(), JsonFilter.class)).toString(),
                            SimpleBeanPropertyFilter.filterOutAllExcept(properties)))
                    .writeValueAsString(object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public static void Stringify(OutputStream out, Object objec){
        try {
            objectMapper.writeValue(out, objec);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void Stringify(OutputStream out, Object object, String... properties){
        try {
            objectMapper
                    .writer(new SimpleFilterProvider().addFilter(
                            AnnotationUtils.getValue(
                                    AnnotationUtils.findAnnotation(object.getClass(), JsonFilter.class)).toString(),
                            SimpleBeanPropertyFilter.filterOutAllExcept(properties)))
                    .writeValue(out, object);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public static <T> T Parse(String json, Class<T> clazz){
        if (json == null || json.length() == 0) {
            return null;
        }

        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
