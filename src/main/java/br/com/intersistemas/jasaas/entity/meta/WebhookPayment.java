/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.util.PaymentEvent;
import com.google.gson.annotations.Expose;

/**
 *
 * @author willian
 */
public class WebhookPayment {

    @Expose
    private PaymentEvent event;
    @Expose
    private Payment payment;

    public PaymentEvent getEvent() {
        return event;
    }

    public void setEvent(PaymentEvent event) {
        this.event = event;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
