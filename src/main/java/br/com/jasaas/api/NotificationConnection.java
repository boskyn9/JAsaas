package br.com.jasaas.api;

import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Notification;
import br.com.jasaas.entity.meta.MetaNotification;
import br.com.jasaas.entity.meta.DeletedEntityReturn;

import java.util.Arrays;

/**
 *
 * @author bosco
 */
public class NotificationConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(NotificationConnection.class.getName());

    public NotificationConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }

    public List<Notification> getAll() throws ConnectionException {
        return getAll(null, null);
    }


    public List<Notification> getAll(Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }
            String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.NOTIFICATION.getEndpoint(), limit, offset);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            return Arrays.asList(meta.getData());
        } catch (IllegalArgumentException ex) {
            this.logger.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Notification getById(String id) throws ConnectionException {
        String url = String.format(super.templateGetById, this.ambiente.getEndpoint(), EndpointEnum.NOTIFICATION.getEndpoint(), id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (Notification) JsonUtil.parse(lastResponseJson, Notification.class);
    }

    public List<Notification> getByCustomer(String customer_id) throws ConnectionException {
        String url = String.format("%s/%s", this.ambiente.getEndpoint(), EndpointEnum.CUSTOMER_NOTIFICATION, customer_id);
        url = url.replace("{id}", customer_id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        MetaNotification meta = (MetaNotification) JsonUtil.parse(lastResponseJson, MetaNotification.class);
        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());
        return Arrays.asList(meta.getData());
    }

    public Notification createNotification(Notification notification) throws ConnectionException {
        if (notification.getId() == null) {
            try {
                String notificationJSON = JsonUtil.toJSON(notification);
                String url = String.format(super.templateCreate, this.ambiente.getEndpoint(), EndpointEnum.NOTIFICATION.getEndpoint());
                this.logger.log(Level.INFO, "POST URL: {0}", url);
                this.logger.log(Level.INFO, "POST JSON: {0}", notificationJSON);
                lastResponseJson = httpClient.post(url, notificationJSON);
                this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
                Notification notificationCreated = (Notification) JsonUtil.parse(lastResponseJson, Notification.class);
                return notificationCreated;
            } catch (Exception ex) {
                this.logger.log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Notification updateNotification(Notification notification) throws ConnectionException {
        try {
            String notificationJSON = JsonUtil.toJSON(notification);
            String url = String.format(super.templateUpdate, this.ambiente.getEndpoint(), EndpointEnum.NOTIFICATION.getEndpoint(), notification.getId());
            this.logger.log(Level.INFO, "PUT URL: {0}", url);
            this.logger.log(Level.INFO, "PUT JSON: {0}", notificationJSON);
            lastResponseJson = httpClient.post(url, notificationJSON);
            this.logger.log(Level.INFO, "PUT RESPONSE: {0}", lastResponseJson);
            Notification notificationUpdated = (Notification) JsonUtil.parse(lastResponseJson, Notification.class);
            return notificationUpdated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deleteNotification(String id) throws ConnectionException {
        try {
            String url = String.format(super.templateDelete, this.ambiente.getEndpoint(), EndpointEnum.NOTIFICATION.getEndpoint(), id);
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
