package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.meta.MetaCustomer;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.filter.CustomerFilter;
import br.com.intersistemas.jasaas.entity.meta.ContentCustomer;

/**
 *
 * @author bosco
 */
public class CustomerConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public CustomerConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Customer> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter) throws ConnectionException {
        return getAll(customerFilter, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
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

            System.out.println(url);
            lastResponseJson = adapter.get(url);
            System.out.println(lastResponseJson);

            MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            ContentCustomer[] contentList = meta.getData();
            List<Customer> customers = new ArrayList<>();

            for (ContentCustomer content : contentList) {
                customers.add(content.getCustomer());
            }
            return customers;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
        //return null;
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

        ContentCustomer[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return contentList[0].getCustomer();
    }

    public void createCustomer(Customer customer) throws ConnectionException {
        String customerJSON = JsonUtil.toJSON(customer);
        if (customer.getId() == null) {
            try {
                System.out.println("createCustomer");
                adapter.post((endpoint + "/customers/"), customerJSON);
            } catch (Exception ex) {
                Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            updateCustomer(customer);
        }
    }

    public void saveOrUpdateCustomer(Customer customer) throws ConnectionException {
        try {
            System.out.println("saveOrUpdateCustomer");
            String customerJSON = JsonUtil.toJSON(customer);
            if (customer.getId() == null) {
                adapter.post((endpoint + "/customers/"), customerJSON);
            } else {
                adapter.post((endpoint + "/customers/" + customer.getId()), customerJSON);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public void updateCustomer(Customer customer) throws ConnectionException {
        try {
            System.out.println("updateCustomer");
            String customerJSON = JsonUtil.toJSON(customer);
            adapter.post((endpoint + "/customers/" + customer.getId()), customerJSON);
        } catch (Exception ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public void deleteCustomer(String id) throws ConnectionException {
        try {
            adapter.delete((endpoint + "/customers/" + id));
        } catch (Exception ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
