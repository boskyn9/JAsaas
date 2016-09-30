package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.Content;
import br.com.intersistemas.jasaas.entity.Meta;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.google.gson.Gson;
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
public class CustomerConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public CustomerConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Customer> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Customer> getAll(Customer customerFilter) throws ConnectionException {
        return getAll(customerFilter, null, null);
    }

    public List<Customer> getAll(Customer customerFilter, Integer limit, Integer offset) throws ConnectionException {
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
                url = StringFormatter.concat(endpoint, "/customers", params, "&limit=", limit, "&offset=", offset).getValue();
            } else {
                url = StringFormatter.concat(endpoint, "/customers", "?limit=", limit, "&offset=", offset).getValue();
            }

            String retorno = adapter.get(url);

            System.out.println("[RETURN] " + retorno);

            Meta meta = (Meta) JsonUtil.parse(retorno, Meta.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            Content[] contentList = meta.getData();
            List<Customer> customers = new ArrayList<>();
            for (Content content : contentList) {
                customers.add(content.getCustomer());
            }
            return customers;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Customer getById(Integer id) throws ConnectionException {
        String retorno = adapter.get(StringFormatter.concat(endpoint, "/customers/", id).getValue());
        return (Customer) JsonUtil.parse(retorno, Customer.class);
    }

    public void createCustomer(Customer customer) throws ConnectionException {
        String customerJSON = JsonUtil.toJSON(customer);
        adapter.post(StringFormatter.concat(endpoint, "/customers/").getValue(), customerJSON);
    }
}
