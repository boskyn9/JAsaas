package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Notification;
import br.com.intersistemas.jasaas.entity.meta.MetaNotification;
import br.com.intersistemas.jasaas.entity.meta.DeletedEntityReturn;

import java.util.Arrays;

/**
 * @author bosco
 */
public class NotificationConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public NotificationConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Notification> getAll() throws ConnectionException {
        return getAll(null, null);
    }

    public List<Notification> getAll(Integer limit, Integer offset) throws ConnectionException {
        if (limit == null) {
            limit = 10;
        }
        if (offset == null) {
            offset = 0;
        }
        String url = (endpoint + "/notifications" + "?limit=" + limit + "&offset=" + offset);
        lastResponseJson = adapter.get(url);
        MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);
        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());
        return Arrays.asList(meta.getData());
    }

    public Notification getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/notifications/" + id));
        return (Notification) JsonUtil.parse(lastResponseJson, Notification.class);
    }

    public List<Notification> getByCustomer(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/customers/" + customer_id + "/notifications"));

        MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        return Arrays.asList(meta.getData());
    }

    public Notification createNotification(Notification notification) throws ConnectionException {
        String notificationJSON = JsonUtil.toJSON(notification);
        if (notification.getId() == null) {
            String data = adapter.post((endpoint + "/notifications/"), notificationJSON);
            return (Notification) JsonUtil.parse(data, Notification.class);
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Notification updateNotification(Notification notification) throws ConnectionException {
        String notificationJSON = JsonUtil.toJSON(notification);
        String data = adapter.post((endpoint + "/notifications/" + notification.getId()), notificationJSON);
        return (Notification) JsonUtil.parse(data, Notification.class);
    }

    public boolean deleteNotification(String id) throws ConnectionException, IOException {
        String data = adapter.delete((endpoint + "/notifications/" + id));
        DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
        return deleted.getDeleted();
    }

}
