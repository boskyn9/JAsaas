package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Notification;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class ContentNotification {

    @Expose private Notification notification;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

}
