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
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("dd/MM/yyyy").create();               
        return gson.fromJson(json, clazz);
    }
    
    public static Object parse(String json, Type type) {
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("dd/MM/yyyy").create();
        return gson.fromJson(json, type);
    }

    public static String toJSON(Object obj) {
        if(gson == null)
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("dd/MM/yyyy").create();
        return gson.toJson(obj);
    }

}
