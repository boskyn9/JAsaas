package br.com.intersistemas.jasaas.api;


import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Notification;
import br.com.intersistemas.jasaas.entity.meta.ContentNotification;
import br.com.intersistemas.jasaas.entity.meta.MetaNotification;
import javax.management.NotificationFilter;

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
        return getAll(null, null, null);
    }

    public List<Notification> getAll(NotificationFilter notificationFilter) throws ConnectionException {
        return getAll(notificationFilter, null, null);
    }

    public List<Notification> getAll(NotificationFilter notificationFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            String url;

            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }

            String params = HttpParamsUtil.parse(notificationFilter);
            if (params != null) {
                url = (endpoint + "/notifications" + params + "&limit=" + limit + "&offset="+ offset);
            } else {
                url = (endpoint + "/notifications" + "?limit=" + limit + "&offset=" + offset);
            }

            lastResponseJson = adapter.get(url);

            MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            ContentNotification[] contentList = meta.getData();
            List<Notification> notifications = new ArrayList<>();
            for (ContentNotification content : contentList) {
                notifications.add(content.getNotification());
            }
            return notifications;
        } catch (IllegalArgumentException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(NotificationConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Notification getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/notifications/" + id));
        return (Notification) JsonUtil.parse(lastResponseJson, Notification.class);
    }

    public List<Notification> getByCustomer(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get((endpoint + "/customers/"  +customer_id  + "/notifications"));
            
        MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        ContentNotification[] contentList = meta.getData();
        List<Notification> notifications = new ArrayList<>();
        for (ContentNotification content : contentList) {
            notifications.add(content.getNotification());
        }
        return notifications;
        
    }
    
    public void createNotification(Notification notification) throws ConnectionException {
        String notificationJSON = JsonUtil.toJSON(notification);
        if (notification.getId() == null) {
            adapter.post((endpoint + "/notifications/"), notificationJSON);
        } else {
            updateNotification(notification);
        }
    }

    public void saveOrUpdateNotification(Notification notification) throws ConnectionException {
        String notificationJSON = JsonUtil.toJSON(notification);
        if (notification.getId() == null) {
            adapter.post((endpoint + "/notifications/"), notificationJSON);
        } else {
            adapter.post((endpoint + "/notifications/" + notification.getId()), notificationJSON);
        }

    }

    public void updateNotification(Notification notification) throws ConnectionException {
        String notificationJSON = JsonUtil.toJSON(notification);
        adapter.post((endpoint + "/notifications/" + notification.getId()), notificationJSON);
    }

    public void deleteNotification(String id) throws ConnectionException {
        adapter.delete((endpoint + "/notifications/" +  id));
    }

}
