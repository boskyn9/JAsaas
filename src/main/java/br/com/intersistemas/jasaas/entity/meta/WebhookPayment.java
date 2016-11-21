/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Payment;
import com.google.gson.annotations.Expose;

/**
 *
 * @author willian
 */
public class WebhookPayment {

    public static final String PAYMENT_CREATED = "PAYMENT_CREATED"; //"Geração de nova cobrança"
    public static final String PAYMENT_UPDATED = "PAYMENT_UPDATED"; //"Alteração no vencimento ou valor de cobrança existente."
    public static final String PAYMENT_CONFIRMED = "PAYMENT_CONFIRMED"; //"Cobrança autorizada pela adquirente (somente cartão de crédito)"
    public static final String PAYMENT_RECEIVED = "PAYMENT_RECEIVED "; //"Cobrança recebida."
    public static final String PAYMENT_OVERDUE = "PAYMENT_OVERDUE "; //"Cobrança vencida"
    public static final String PAYMENT_DELETED = "PAYMENT_DELETED"; //"Cobrança removida"
    public static final String PAYMENT_REFUNDED = "PAYMENT_REFUNDED"; //"Cobrança estornada (somente cartão de crédito)"

    @Expose
    private String event;
    @Expose
    private Payment payment;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
