package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Invoice;
import br.com.jasaas.entity.filter.InvoiceFilter;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;

public class InvoiceConnection extends AsaasConnection<Invoice, InvoiceFilter> {
    public InvoiceConnection(Ambiente ambiente, AdapterConnection httpClient) {
        super(ambiente, httpClient, EndpointEnum.INVOICE);
        this.metaGenericClass = Invoice.class;
    }
}
