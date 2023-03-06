package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Subscription;
import br.com.jasaas.entity.filter.SubscriptionFilter;
import br.com.jasaas.entity.meta.MetaSubscription;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author bosco
 */
public class SubscriptionConnection extends AsaasConnection<Subscription, SubscriptionFilter> {

    public SubscriptionConnection(AdapterConnection httpClient, EnvironmentAsaas environmentAsaas) {
        super(environmentAsaas, httpClient, EndpointEnum.SUBSCRIPTION);
        this.metaGenericClass = MetaSubscription.class;
    }

    public List<Subscription> getByCustomer(String customer_id) throws ConnectionException {
        String url = String.format("%s/%s", this.environmentAsaas.getEndpoint(), EndpointEnum.CUSTOMER_SUBSCRIPTION.getEndpoint());
        this.logger.log(Level.INFO, "GET URL: {0}", customer_id);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        MetaSubscription meta = (MetaSubscription) JsonUtil.parse(lastResponseJson, MetaSubscription.class);
        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());
        if (meta.getData().isEmpty()) {
            return null;
        }
        return meta.getData();
    }

    public Subscription createSubscription(Subscription subscription) throws ConnectionException {
        return create(subscription);
    }

    public Subscription updateSubscription(Subscription subscription) throws ConnectionException {
        return update(subscription);
    }

    public boolean deleteSubscription(String id) throws ConnectionException {
        return delete(id);
    }

}
