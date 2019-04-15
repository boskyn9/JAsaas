package br.com.intersistemas.jasaas.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bosco
 */
public class JsonUtil {

    private static Gson gson = null;

    public static Object parse(String json, Class clazz) {
        return parse(json, clazz, false);
    }

    public static Object parse(String json, Class clazz, Boolean showLog) {
        String dateFormat = "";
        if (isDateBR(json)) {
            dateFormat = "dd/MM/yyyy";
        } else {
            dateFormat = "yyyy-MM-dd";
        }
        if (gson == null) {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat(dateFormat).create();
        }
        try {
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            if (showLog) {
                System.out.println("Error parse gson.fromJson\n" + json);
                e.printStackTrace();
            }
            return null;
        }
    }

    public static Object parse(String json, Type type) {
        if (gson == null) {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd").create();
        }
        return gson.fromJson(json, type);
    }

    public static String toJSON(Object obj) {
        if (gson == null) {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd").create();
        }
        return gson.toJson(obj);
    }

    private static Boolean isDateBR(String json) {
        Pattern pattern = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
        Matcher matcher = pattern.matcher(json);
        return matcher.matches();
//        String dateUS = "2018-01-01";
//        pattern = Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$");
    }
}
