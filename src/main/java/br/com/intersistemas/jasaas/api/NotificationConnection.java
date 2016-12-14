package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Notification;
import br.com.intersistemas.jasaas.entity.meta.MetaNotification;
import br.com.intersistemas.jasaas.entity.meta.DeletedEntityReturn;
import java.util.Arrays;

/**
 *
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

//    public List<Notification> getAll(NotificationFilter notificationFilter) throws ConnectionException {
//        return getAll(notificationFilter, null, null);
//    }
    public List<Notification> getAll(Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }

            //String params = HttpParamsUtil.parse(notificationFilter);
//            if (params != null) {
//                url = (endpoint + "/notifications" + params + "&limit=" + limit + "&offset=" + offset);
//            } else {
//            }
            String url = (endpoint + "/notifications" + "?limit=" + limit + "&offset=" + offset);

            lastResponseJson = adapter.get(url);

            MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            return Arrays.asList(meta.getData());
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NotificationConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
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
            try {
                System.out.println("createNotification");
                String data = adapter.post((endpoint + "/notifications/"), notificationJSON);
                Notification notificationCreated = (Notification) JsonUtil.parse(data, Notification.class);
                return notificationCreated;
            } catch (Exception ex) {
                Logger.getLogger(NotificationConnection.class.getName()).log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Notification updateNotification(Notification notification) throws ConnectionException {
        try {
            System.out.println("updateNotification");
            String notificationJSON = JsonUtil.toJSON(notification);
            String data = adapter.post((endpoint + "/notifications/" + notification.getId()), notificationJSON);
            Notification notificationUpdated = (Notification) JsonUtil.parse(data, Notification.class);
            return notificationUpdated;
        } catch (Exception ex) {
            Logger.getLogger(NotificationConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deleteNotification(String id) throws ConnectionException {
        try {
            System.out.println("deleteNotification");
            String data = adapter.delete((endpoint + "/notifications/" + id));
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            Logger.getLogger(NotificationConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
