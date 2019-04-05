package br.com.intersistemas.jasaas.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/**
 * @author bosco
 */
public class JsonUtil {

    private static Gson gson = null;
    
    public static Object parse(String json, Class clazz) {
        return parse(json, clazz, false);
    }
    
    public static Object parse(String json, Class clazz, Boolean showLog) {
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd").create();
        try {
            return gson.fromJson(json, clazz);
        } catch(Exception e) {
            if (showLog) {
                System.out.println("Error parse gson.fromJson\n" + json);
                e.printStackTrace();
            }
            return null;
        }
    }
    
    public static Object parse(String json, Type type) {
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd").create();
        return gson.fromJson(json, type);
    }

    public static String toJSON(Object obj) {
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(obj);
    }

}
