package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.Content;
import br.com.intersistemas.jasaas.entity.Meta;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Subscription;
import br.com.intersistemas.jasaas.entity.filter.SubscriptionFilter;

/**
 *
 * @author bosco
 */
public class SubscriptionConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public SubscriptionConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Subscription> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Subscription> getAll(SubscriptionFilter subscriptionFilter) throws ConnectionException {
        return getAll(subscriptionFilter, null, null);
    }

    public List<Subscription> getAll(SubscriptionFilter subscriptionFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            String url;

            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }

            String params = HttpParamsUtil.parse(subscriptionFilter);
            if (params != null) {
                url = StringFormatter.concat(endpoint, "/subscriptions", params, "&limit=", limit, "&offset=", offset).getValue();
            } else {
                url = StringFormatter.concat(endpoint, "/subscriptions", "?limit=", limit, "&offset=", offset).getValue();
            }

            lastResponseJson = adapter.get(url);

            Meta meta = (Meta) JsonUtil.parse(lastResponseJson, Meta.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            Content[] contentList = meta.getData();
            List<Subscription> subscriptions = new ArrayList<>();
            for (Content content : contentList) {
                subscriptions.add(content.getSubscription());
            }
            return subscriptions;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(SubscriptionConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Subscription getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/subscriptions/", id).getValue());
        return (Subscription) JsonUtil.parse(lastResponseJson, Subscription.class);
    }

    public List<Subscription> getByCustomer(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/customers/", customer_id,"/subscriptions").getValue());
        Meta meta = (Meta) JsonUtil.parse(lastResponseJson, Meta.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            Content[] contentList = meta.getData();
            List<Subscription> subscriptions = new ArrayList<>();
            for (Content content : contentList) {
                subscriptions.add(content.getSubscription());
            }
            return subscriptions;
    }

    public void createSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        if (subscription.getId() == null) {
            adapter.post(StringFormatter.concat(endpoint, "/subscriptions/").getValue(), subscriptionJSON);
        } else {
            updateSubscription(subscription);
        }
    }

    public void saveOrUpdateSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        if (subscription.getId() == null) {
            adapter.post(StringFormatter.concat(endpoint, "/subscriptions/").getValue(), subscriptionJSON);
        } else {
            adapter.post(StringFormatter.concat(endpoint, "/subscriptions/", subscription.getId()).getValue(), subscriptionJSON);
        }

    }

    public void updateSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        adapter.post(StringFormatter.concat(endpoint, "/subscriptions/", subscription.getId()).getValue(), subscriptionJSON);
    }

    public void deleteSubscription(String id) throws ConnectionException {
        adapter.delete(StringFormatter.concat(endpoint, "/subscriptions/", id).getValue());
    }

}
