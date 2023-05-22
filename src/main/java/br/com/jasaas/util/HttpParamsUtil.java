package br.com.jasaas.util;

import org.apache.http.client.utils.URIBuilder;

import java.lang.reflect.Field;

/**
 *
 * @author bosco
 */
public class HttpParamsUtil {
    
    public static String parse(Object obj) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        if(obj == null)
            return "?";
        URIBuilder uriBuilder = new URIBuilder();
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {           
            field.setAccessible(true);
            Object valueObject = field.get(obj);
            if(valueObject != null)
                uriBuilder.addParameter(field.getName(), valueObject.toString());
        }
        return uriBuilder.toString().concat("&");
    }
}
