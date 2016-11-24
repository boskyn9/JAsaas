package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Subscription;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class ContentSubscription {

    @Expose private Subscription subscription;

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "ContentSubscription{" + "subscription=" + subscription + '}';
    }
}
