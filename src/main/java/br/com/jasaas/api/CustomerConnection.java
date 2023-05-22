package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Customer;
import br.com.jasaas.entity.filter.CustomerFilter;
import br.com.jasaas.entity.meta.MetaCustomer;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import br.com.jasaas.exception.ConnectionException;

import java.util.List;

public class CustomerConnection extends AsaasConnection<Customer, CustomerFilter> {
    public CustomerConnection(EnvironmentAsaas environmentAsaas, AdapterConnection httpClient) {
        super(environmentAsaas, httpClient, EndpointEnum.CUSTOMER);
        this.metaGenericClass = MetaCustomer.class;
    }

    public List<Customer> getByCpfCnpj(String cpfCnpj) throws ConnectionException {
        CustomerFilter filter = new CustomerFilter();
        filter.setCpfCnpj(cpfCnpj);
        return getAll(filter);
    }

    public Customer getByEmail(String email) throws ConnectionException {
        CustomerFilter filter = new CustomerFilter();
        filter.setEmail(email);
        List<Customer> customers = getAll(filter);
        if (customers.isEmpty()) {
            return null;
        }
        return customers.get(0);
    }

    public Customer createCustomer(Customer customer) throws ConnectionException {
        return create(customer);
    }

    public Customer updateCustomer(Customer customer) throws ConnectionException {
        return update(customer);
    }

    public boolean deleteCustomer(String id) throws ConnectionException {
        return delete(id);
    }
}
