package br.com.intersistemas.jasaas.api;



import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Subscription;
import br.com.intersistemas.jasaas.entity.filter.SubscriptionFilter;
import br.com.intersistemas.jasaas.entity.meta.ContentSubscription;
import br.com.intersistemas.jasaas.entity.meta.MetaSubscription;

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
                url = (endpoint + "/subscriptions" + params + "&limit=" + limit + "&offset="+ offset);
            } else {
                url = (endpoint + "/subscriptions" + "?limit=" + limit + "&offset=" + offset);
            }

            lastResponseJson = adapter.get(url);

            MetaSubscription meta = (MetaSubscription) JsonUtil.parse(lastResponseJson, MetaSubscription.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            ContentSubscription[] contentList = meta.getData();
            List<Subscription> subscriptions = new ArrayList<>();
            for (ContentSubscription content : contentList) {
                subscriptions.add(content.getSubscription());
            }
            return subscriptions;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(SubscriptionConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Subscription getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/subscriptions/" + id));
        return (Subscription) JsonUtil.parse(lastResponseJson, Subscription.class);
    }

    public List<Subscription> getByCustomer(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/customers/" + customer_id +"/subscriptions"));
        MetaSubscription meta = (MetaSubscription) JsonUtil.parse(lastResponseJson, MetaSubscription.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            ContentSubscription[] contentList = meta.getData();
            List<Subscription> subscriptions = new ArrayList<>();
            for (ContentSubscription content : contentList) {
                subscriptions.add(content.getSubscription());
            }
            return subscriptions;
    }

    public void createSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        if (subscription.getId() == null) {
            adapter.post((endpoint + "/subscriptions/"), subscriptionJSON);
        } else {
            updateSubscription(subscription);
        }
    }

    public void saveOrUpdateSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        if (subscription.getId() == null) {
            adapter.post((endpoint + "/subscriptions/"), subscriptionJSON);
        } else {
            adapter.post((endpoint + "/subscriptions/" + subscription.getId()), subscriptionJSON);
        }

    }

    public void updateSubscription(Subscription subscription) throws ConnectionException {
        String subscriptionJSON = JsonUtil.toJSON(subscription);
        adapter.post((endpoint + "/subscriptions/" + subscription.getId()), subscriptionJSON);
    }

    public void deleteSubscription(String id) throws ConnectionException {
        adapter.delete((endpoint + "/subscriptions/" + id));
    }

}
