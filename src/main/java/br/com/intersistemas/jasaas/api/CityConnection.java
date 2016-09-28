package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterInterface;
import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.entity.Content;
import br.com.intersistemas.jasaas.entity.Meta;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;

/**
 *
 * @author bosco
 */
public class CityConnection extends AbstractConnection{

    private AdapterInterface adapter;
    
    public CityConnection(AdapterInterface adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<City> getAll(City cityFilter) {        
        try {
            String params = HttpParamsUtil.parse(cityFilter);            
            
            String url;
            if(params != null){
                url = StringFormatter.concat(endpoint,"/cities",params).getValue();
            }else{
                url = StringFormatter.concat(endpoint,"/cities").getValue();
            }
            String retorno = adapter.get(url);
            Meta meta = (Meta) JsonUtil.parse(retorno, Meta.class);
            Content[] contentList = meta.getData();
            List<City> cities = new ArrayList<>();
            for (Content content : contentList) {
                cities.add(content.getCity());
            }           
            return cities;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CityConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public City getById(Integer id){
        String retorno = adapter.get(StringFormatter.concat(endpoint,"/cities/",id).getValue());
        return (City) JsonUtil.parse(retorno, City.class);
    }
    
}
