package br.com.jasaas.api;

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
import br.com.jasaas.entity.Subscription;
import br.com.jasaas.entity.filter.SubscriptionFilter;
import br.com.jasaas.entity.meta.DeletedEntityReturn;
import br.com.jasaas.entity.meta.MetaSubscription;

/**
 *
 * @author bosco
 */
public class SubscriptionConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(SubscriptionConnection.class.getName());

    public SubscriptionConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }

    public List<Subscription> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Subscription> getAll(SubscriptionFilter subscriptionFilter) throws ConnectionException {
        return getAll(subscriptionFilter, null, null);
    }

    public List<Subscription> getAll(SubscriptionFilter subscriptionFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }
            String params = HttpParamsUtil.parse(subscriptionFilter);
            String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION.getEndpoint(), params, limit, offset);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaSubscription meta = (MetaSubscription) JsonUtil.parse(lastResponseJson, MetaSubscription.class);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            Subscription[] contentList = meta.getData();
            List<Subscription> subscriptions = new ArrayList<>();
            for (Subscription content : contentList) {
                subscriptions.add(content);
            }
            return subscriptions;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            this.logger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Subscription getById(String id) throws ConnectionException {
        String url = String.format(super.templateGetById, this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION.getEndpoint(), id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (Subscription) JsonUtil.parse(lastResponseJson, Subscription.class);
    }

    public List<Subscription> getByCustomer(String customer_id) throws ConnectionException {
        String url = String.format("%s/%s", this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER_SUBSCRIPTION.getEndpoint());
        this.logger.log(Level.INFO, "GET URL: {0}", customer_id);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        MetaSubscription meta = (MetaSubscription) JsonUtil.parse(lastResponseJson, MetaSubscription.class);
        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());
        Subscription[] contentList = meta.getData();
        List<Subscription> subscriptions = new ArrayList<>();
        for (Subscription content : contentList) {
            subscriptions.add(content);
        }
        return subscriptions;
    }

    public Subscription createSubscription(Subscription subscription) throws ConnectionException {
        if (subscription.getId() == null) {
            try {
                String subscriptionJSON = JsonUtil.toJSON(subscription);
                String url = String.format(super.templateCreate, this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION.getEndpoint());
                this.logger.log(Level.INFO, "POST URL: {0}", url);
                this.logger.log(Level.INFO, "POST JSON: {0}", subscriptionJSON);
                lastResponseJson = httpClient.post(url, subscriptionJSON);
                this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
                Subscription subscriptionsCreated = (Subscription) JsonUtil.parse(lastResponseJson, Subscription.class);
                return subscriptionsCreated;
            } catch (Exception ex) {
                this.logger.log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Subscription updateSubscription(Subscription subscription) throws ConnectionException {
        try {
            String subscriptionJSON = JsonUtil.toJSON(subscription);
            String url = String.format(super.templateUpdate, this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION.getEndpoint(), subscription.getId());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST JSON: {0}", subscriptionJSON);
            lastResponseJson = httpClient.post(url, subscriptionJSON);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            Subscription subscriptionUpdated = (Subscription) JsonUtil.parse(lastResponseJson, Subscription.class);
            return subscriptionUpdated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deleteSubscription(String id) throws ConnectionException {
        try {
            String url = String.format(super.templateDelete, this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION.getEndpoint(), id);
            this.logger.log(Level.INFO, "DELETE URL: {0}", url);
            String data = httpClient.delete(url);
            this.logger.log(Level.INFO, "DELETE RESPONSE: {0}", data);
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
