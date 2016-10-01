package br.com.intersistemas.jasaas.util;

import java.lang.reflect.Field;
import java.util.StringJoiner;

/**
 *
 * @author bosco
 */
public class HttpParamsUtil {
    
    public static String parse(Object obj) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        if(obj == null)
            return null;
        StringJoiner params = new StringJoiner("&", "?", "");
        
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {           
            field.setAccessible(true);
            Object valueObject = field.get(obj);
            if(valueObject != null)
                params.add(field.getName()+"="+valueObject.toString());
        }
        return params.toString();
    }
}
