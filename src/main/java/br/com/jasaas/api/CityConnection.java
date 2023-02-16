package br.com.jasaas.api;

import br.com.jasaas.entity.City;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.HttpParamsUtil;
import br.com.jasaas.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.filter.CityFilter;
import br.com.jasaas.entity.meta.MetaCity;

/**
 *
 * @author bosco
 */
public class CityConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(CityConnection.class.getName());
    
    public CityConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }
    
    public List<City> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }
    
    public List<City> getAll(CityFilter cityFilter) throws ConnectionException {
        return getAll(cityFilter, null, null);
    }
    
    public List<City> getAll(CityFilter cityFilter,Integer limit, Integer offset) throws ConnectionException {        
        try {
            if(limit == null) limit = 10;
            if(offset == null) offset = 0;
            String params = HttpParamsUtil.parse(cityFilter);
            String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.CITY.getEndpoint(), params, limit, offset);
            logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
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
        String url = String.format(this.templateGetById, this.ambiente.getEndpoint(), EndpointEnum.CITY.getEndpoint(), id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (City) JsonUtil.parse(lastResponseJson, City.class);
    }
    
}
