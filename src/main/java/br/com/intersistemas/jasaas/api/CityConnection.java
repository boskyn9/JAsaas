package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.filter.CityFilter;
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
                url = (endpoint + "/cities" + params + "&limit=" + limit + "&offset=" + offset);
            }else{
                url = (endpoint + "/cities" + "?limit=" + limit + "&offset=" + offset);
            }
            
            lastResponseJson = adapter.get(url);
            
            MetaCity meta = (MetaCity) JsonUtil.parse(lastResponseJson, MetaCity.class);
            
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            
            City[] contentList = meta.getData();
            List<City> cities = new ArrayList<>();
            for (City content : contentList) {
                cities.add(content);
            }           
            return cities;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CityConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public City getById(Integer id) throws ConnectionException{
        lastResponseJson = adapter.get(endpoint + "/cities/" + id);
        return (City) JsonUtil.parse(lastResponseJson, City.class);
    }
    
}
