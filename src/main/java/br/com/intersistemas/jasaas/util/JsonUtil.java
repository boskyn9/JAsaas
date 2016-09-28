/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;

/**
 *
 * @author bosco
 */
public class JsonUtil {

    public static Object parse(String json, Class clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
    
    public static Object parse(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static String toJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
