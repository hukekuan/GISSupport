package com.gis3c.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static String Stringify(Object object, String... properties){
        return null;
    }

    public static void Stringify(OutputStream out, Object objec){

    }

    public static void Stringify(OutputStream out, Object object, String... properties){

    }

    public static <T> T Parse(String json, Class<T> clazz){
        return null;
    }
}
