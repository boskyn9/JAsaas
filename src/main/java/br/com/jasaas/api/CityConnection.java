package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.City;
import br.com.jasaas.entity.filter.CityFilter;
import br.com.jasaas.entity.meta.MetaCity;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;

/**
 *
 * @author bosco
 */
public class CityConnection extends AsaasConnection<City, CityFilter> {

    public CityConnection(AdapterConnection httpClient, EnvironmentAsaas environmentAsaas) {
        super(environmentAsaas, httpClient, EndpointEnum.CITY);
        this.metaGenericClass = MetaCity.class;
    }

}
