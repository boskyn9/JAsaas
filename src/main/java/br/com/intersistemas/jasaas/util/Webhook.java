package br.com.intersistemas.jasaas.util;

import br.com.intersistemas.jasaas.entity.meta.WebhookPayment;

/**
 *
 * @author willian
 */
public class Webhook {

    public static WebhookPayment parseToPayment(String dataJson) {
        return parseToPayment(dataJson, false);
    }
    
    public static WebhookPayment parseToPayment(String dataJson, Boolean showLog) {
        WebhookPayment whPayment = (WebhookPayment) JsonUtil.parse(dataJson, WebhookPayment.class, showLog);
        return whPayment;
    }
}
