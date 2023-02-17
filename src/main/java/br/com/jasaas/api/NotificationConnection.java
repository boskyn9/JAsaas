package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Notification;
import br.com.jasaas.entity.meta.MetaNotification;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author bosco
 */
public class NotificationConnection extends AsaasConnection<Notification, Object> {

    public NotificationConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente, httpClient, EndpointEnum.NOTIFICATION);
        this.metaGenericClass = MetaNotification.class;
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
        return meta.getData();
    }

    public Notification createNotification(Notification notification) throws ConnectionException {
        return create(notification);
    }

    public Notification updateNotification(Notification notification) throws ConnectionException {
        return update(notification);
    }

    public boolean deleteNotification(String id) throws ConnectionException {
        return delete(id);
    }

}
