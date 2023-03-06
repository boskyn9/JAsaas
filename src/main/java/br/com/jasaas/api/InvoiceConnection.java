package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Invoice;
import br.com.jasaas.entity.MunicipalService;
import br.com.jasaas.entity.filter.InvoiceFilter;
import br.com.jasaas.entity.meta.MetaError;
import br.com.jasaas.entity.meta.MetaGeneric;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.List;
import java.util.logging.Level;

public class InvoiceConnection extends AsaasConnection<Invoice, InvoiceFilter> {
    public InvoiceConnection(EnvironmentAsaas environmentAsaas, AdapterConnection httpClient) {
        super(environmentAsaas, httpClient, EndpointEnum.INVOICE);
        this.metaGenericClass = Invoice.class;
    }

    public Invoice schedule(Invoice invoice) {
        return create(invoice);
    }

    public Invoice updateInvoice(Invoice invoice) {
        return updatePut(invoice);
    }

    public Invoice authorizeInvoice(String invoiceId) {
        try {
            String url = String.format("%s/%s/%s/authorize", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint(), invoiceId);
            this.logger.log(Level.INFO, "AUTHORIZE URL: {0}", url);
            lastResponseJson = httpClient.put(url, "");
            this.logger.log(Level.INFO, "AUTHORIZE RESPONSE: {0}", lastResponseJson);
            Invoice invoice = (Invoice) JsonUtil.parse(lastResponseJson, Invoice.class);
            if (invoice.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return invoice;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }
    public Invoice cancelInvoice(String invoiceId) {
        try {
            String url = String.format("%s/%s/%s/cancel", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint(), invoiceId);
            this.logger.log(Level.INFO, "CANCEL URL: {0}", url);
            lastResponseJson = httpClient.post(url, "");
            this.logger.log(Level.INFO, "CANCEL RESPONSE: {0}", lastResponseJson);
            Invoice invoiceResponse = (Invoice) JsonUtil.parse(lastResponseJson, Invoice.class);
            if (invoiceResponse.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return invoiceResponse;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public List<MunicipalService> getMunicipalServices(String description) {
        try {
            String url = String.format("%s/%s/municipalServices?description=%s", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint(), description);
            this.logger.log(Level.INFO, "MUNICIPAL SERVICES URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "MUNICIPAL SERVICES RESPONSE: {0}", lastResponseJson);
            MetaGeneric<MunicipalService> metaResult = (MetaGeneric<MunicipalService>) JsonUtil.parse(lastResponseJson, MetaGeneric.class);
            if (metaResult == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return metaResult.getData();
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }
}
