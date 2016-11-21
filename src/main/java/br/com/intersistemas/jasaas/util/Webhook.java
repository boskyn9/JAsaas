package br.com.intersistemas.jasaas.util;

import br.com.intersistemas.jasaas.entity.meta.WebhookPayment;

/**
 *
 * @author willian
 */
public class Webhook {

    public static WebhookPayment parseToPayment(String dataJson) {
        WebhookPayment whPayment = (WebhookPayment) JsonUtil.parse(dataJson, WebhookPayment.class);
        return whPayment;
    }
}
