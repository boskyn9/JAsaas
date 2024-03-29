package br.com.intersistemas.jasaas.util;

import java.lang.reflect.Field;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author bosco
 */
public class HttpParamsUtil {
    
    public static String parse(Object obj) throws IllegalArgumentException, IllegalAccessException {
        if(obj == null)
            return null;
        
        URIBuilder uriBuilder = new URIBuilder();       
        
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {           
            field.setAccessible(true);
            Object valueObject = field.get(obj);
            if(valueObject != null)
                uriBuilder.addParameter(field.getName(), valueObject.toString());
        }
        
        
        
        
        return uriBuilder.toString();
    }
}
