package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.meta.MetaCustomer;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.filter.CustomerFilter;
import br.com.intersistemas.jasaas.entity.meta.DeletedEntityReturn;
import br.com.intersistemas.jasaas.entity.meta.MetaError;

/**
 * @author bosco
 */
public class CustomerConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public CustomerConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Customer> getAll() throws ConnectionException, IllegalAccessException {
        return getAll(null, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter) throws ConnectionException, IllegalAccessException {
        return getAll(customerFilter, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter, Integer limit, Integer offset) throws ConnectionException, IllegalAccessException {

        String url;

        if (limit == null) {
            limit = 10;
        }
        if (offset == null) {
            offset = 0;
        }

        String params = HttpParamsUtil.parse(customerFilter);
        if (params != null) {
            url = (endpoint + "/customers" + params + "&limit=" + limit + "&offset=" + offset);
        } else {
            url = (endpoint + "/customers" + "?limit=" + limit + "&offset=" + offset);
        }

        lastResponseJson = adapter.get(url);
        MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Customer[] contentList = meta.getData();
        List<Customer> customers = new ArrayList<>();

        Collections.addAll(customers, contentList);
        return customers;
    }

    public Customer getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/customers/" + id);
        return (Customer) JsonUtil.parse(lastResponseJson, Customer.class);
    }

    public Customer getByEmail(String email) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/customers?email=" + email);
        MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Customer[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return contentList[0];
    }

    public Customer getByExternalReference(String externalReference) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/customers?externalReference=" + externalReference);
        MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Customer[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return contentList[0];
    }

    public Customer createCustomer(Customer customer) throws ConnectionException {
        String customerJSON = JsonUtil.toJSON(customer);
        if (customer.getId() == null) {
            String data = adapter.post((endpoint + "/customers/"), customerJSON);
            Customer customerCreated = (Customer) JsonUtil.parse(data, Customer.class);
            if (customerCreated.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(data, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return customerCreated;
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Customer updateCustomer(Customer customer) throws ConnectionException {
        String customerJSON = JsonUtil.toJSON(customer);
        String data = adapter.post((endpoint + "/customers/" + customer.getId()), customerJSON);
        Customer customerUpdated = (Customer) JsonUtil.parse(data, Customer.class);
        if (customerUpdated.getId() == null) {
            MetaError error = (MetaError) JsonUtil.parse(data, MetaError.class);
            throw new ConnectionException(500, error.toString(), error);
        }
        return customerUpdated;
    }

    public boolean deleteCustomer(String id) throws ConnectionException, IOException {
        System.out.println("deleteCustomer");
        String data = adapter.delete((endpoint + "/customers/" + id));
        DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
        return deleted.getDeleted();
    }

}
