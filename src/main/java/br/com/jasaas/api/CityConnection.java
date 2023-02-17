package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.City;
import br.com.jasaas.entity.filter.CityFilter;
import br.com.jasaas.entity.meta.MetaCity;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;

/**
 *
 * @author bosco
 */
public class CityConnection extends AsaasConnection<City, CityFilter> {

    public CityConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente, httpClient, EndpointEnum.CITY);
        this.metaGenericClass = MetaCity.class;
    }

}
