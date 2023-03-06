package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.CustomerFiscalInfo;
import br.com.jasaas.entity.MunicipalOptions;
import br.com.jasaas.entity.meta.MetaCustomer;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.logging.Level;

import static br.com.jasaas.enumeration.EndpointEnum.CUSTOMER_FISCAL_INFO;

public class FiscalInfoConnection extends AsaasConnection<CustomerFiscalInfo, Object> {
    public FiscalInfoConnection(EnvironmentAsaas environmentAsaas, AdapterConnection httpClient) {
        super(environmentAsaas, httpClient, CUSTOMER_FISCAL_INFO);
        this.metaGenericClass = MetaCustomer.class;
    }

    public MunicipalOptions getMunicipalOptions() throws ConnectionException {
        try {
            String url = String.format("%s/%s/municipalOptions", this.environmentAsaas.getEndpoint(), EndpointEnum.CUSTOMER_FISCAL_INFO.getEndpoint());
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            return (MunicipalOptions) JsonUtil.parse(lastResponseJson, MunicipalOptions.class);
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage(), null);
        }
    }

    public CustomerFiscalInfo getFiscalInfo() throws ConnectionException {
        try {
            String url = String.format("%s/%s", this.environmentAsaas.getEndpoint(), EndpointEnum.CUSTOMER_FISCAL_INFO.getEndpoint());
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            return (CustomerFiscalInfo) JsonUtil.parse(lastResponseJson, CustomerFiscalInfo.class);
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage(), null);
        }
    }

}
