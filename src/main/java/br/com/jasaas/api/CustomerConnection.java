package br.com.jasaas.api;

import br.com.jasaas.entity.Customer;
import br.com.jasaas.entity.meta.MetaCustomer;
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
import br.com.jasaas.entity.filter.CustomerFilter;
import br.com.jasaas.entity.meta.DeletedEntityReturn;
import br.com.jasaas.entity.meta.MetaError;

/**
 *
 * @author bosco
 */
public class CustomerConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(CustomerConnection.class.getName());

    public CustomerConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }

    public List<Customer> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter) throws ConnectionException {
        return getAll(customerFilter, null, null);
    }

    public List<Customer> getAll(CustomerFilter customerFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }
            String params = HttpParamsUtil.parse(customerFilter);
            String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint(), params, limit, offset);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            Customer[] contentList = meta.getData();
            List<Customer> customers = new ArrayList<>();
            for (Customer content : contentList) {
                customers.add(content);
            }
            return customers;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Customer getById(String id) throws ConnectionException {
        try {
            String url = String.format(super.templateGetById, this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint(), id);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            return (Customer) JsonUtil.parse(lastResponseJson, Customer.class);
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public List<Customer> getByCpfCnpj(String cpfCnpj) throws ConnectionException {
        CustomerFilter filter = new CustomerFilter();
        filter.setCpfCnpj(cpfCnpj);
        return getAll(filter);
    }

    public Customer getByEmail(String email) throws ConnectionException {
        try {
            final String url = String.format("%s/%s?email=%s", this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint(), email);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaCustomer meta = (MetaCustomer) JsonUtil.parse(lastResponseJson, MetaCustomer.class);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            Customer[] contentList = meta.getData();
            if (contentList.length == 0) {
                return null;
            }
            return contentList[0];
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Customer createCustomer(Customer customer) throws ConnectionException {
        if (customer.getId() == null) {
            try {
                String customerJSON = JsonUtil.toJSON(customer);
                String url = String.format(super.templateCreate, this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint());
                this.logger.log(Level.INFO, "POST URL: {0}", url);
                this.logger.log(Level.INFO, "POST PAYLOAD: {0}", customerJSON);
                lastResponseJson = httpClient.post(url, customerJSON);
                this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
                Customer customerCreated = (Customer) JsonUtil.parse(lastResponseJson, Customer.class);
                if (customerCreated.getId() == null) {
                    MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                    throw new ConnectionException(500, error.toString());
                }
                return customerCreated;
            } catch (Exception ex) {
                this.logger.log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Customer updateCustomer(Customer customer) throws ConnectionException {
        try {
            String customerJSON = JsonUtil.toJSON(customer);
            String url = String.format(super.templateUpdate, this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint(), customer.getId());
            this.logger.log(Level.INFO, "PUT URL: {0}", url);
            this.logger.log(Level.INFO, "PUT PAYLOAD: {0}", customerJSON);
            lastResponseJson = httpClient.post(url, customerJSON);
            this.logger.log(Level.INFO, "PUT RESPONSE: {0}", lastResponseJson);
            Customer customerUpdated = (Customer) JsonUtil.parse(lastResponseJson, Customer.class);
            if (customerUpdated.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString());
            }
            return customerUpdated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deleteCustomer(String id) throws ConnectionException {
        try {
            String url = String.format(super.templateDelete, this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER.getEndpoint(), id);
            this.logger.log(Level.INFO, "DELETE URL: {0}", url);
            lastResponseJson = httpClient.delete(url);
            this.logger.log(Level.INFO, "DELETE RESPONSE: {0}", lastResponseJson);
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(lastResponseJson, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
