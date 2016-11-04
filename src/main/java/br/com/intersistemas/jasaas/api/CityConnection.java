package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.entity.meta.ContentPayment;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.filter.CityFilter;
import br.com.intersistemas.jasaas.entity.meta.ContentCity;
import br.com.intersistemas.jasaas.entity.meta.MetaCity;

/**
 *
 * @author bosco
 */
public class CityConnection extends AbstractConnection{

    private final AdapterConnection adapter;
    
    public CityConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }
    
    public List<City> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }
    
    public List<City> getAll(CityFilter cityFilter) throws ConnectionException {
        return getAll(cityFilter, null, null);
    }
    
    public List<City> getAll(CityFilter cityFilter,Integer limit, Integer offset) throws ConnectionException {        
        try {
            String url;
            
            if(limit == null) limit = 10;
            if(offset == null) offset = 0;
            
            String params = HttpParamsUtil.parse(cityFilter);            
            if(params != null){
                url = StringFormatter.concat(endpoint,"/cities",params,"&limit=",limit,"&offset=",offset).getValue();
            }else{
                url = StringFormatter.concat(endpoint,"/cities","?limit=",limit,"&offset=",offset).getValue();
            }
            
            lastResponseJson = adapter.get(url);
            
            MetaCity meta = (MetaCity) JsonUtil.parse(lastResponseJson, MetaCity.class);
            
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            
            ContentCity[] contentList = meta.getData();
            List<City> cities = new ArrayList<>();
            for (ContentCity content : contentList) {
                cities.add(content.getCity());
            }           
            return cities;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CityConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public City getById(Integer id) throws ConnectionException{
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint,"/cities/",id).getValue());
        return (City) JsonUtil.parse(lastResponseJson, City.class);
    }
    
}
