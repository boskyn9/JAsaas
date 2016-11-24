package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Payment;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public class ContentPayment {
 
    @Expose private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "ContentPayment{" + "payment=" + payment + '}';
    }
}
