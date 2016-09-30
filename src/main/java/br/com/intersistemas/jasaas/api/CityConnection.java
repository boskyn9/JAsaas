package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.City;
import br.com.intersistemas.jasaas.entity.Content;
import br.com.intersistemas.jasaas.entity.Meta;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;

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
    
    public List<City> getAll(City cityFilter) throws ConnectionException {
        return getAll(cityFilter, null, null);
    }
    
    public List<City> getAll(City cityFilter,Integer limit, Integer offset) throws ConnectionException {        
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
            
            String retorno = adapter.get(url);
            
            Meta meta = (Meta) JsonUtil.parse(retorno, Meta.class);
            
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            
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
    
    public City getById(Integer id) throws ConnectionException{
        String retorno = adapter.get(StringFormatter.concat(endpoint,"/cities/",id).getValue());
        return (City) JsonUtil.parse(retorno, City.class);
    }
    
}
