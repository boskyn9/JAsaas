package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author rafael
 */
public final class PaymentReceiveInCash extends AsaasEntity<String> {

    @Expose(serialize = false)
    private String id;
    @Expose
    private Date paymentDate;
    @Expose
    private BigDecimal value;

    @Expose
    private Boolean notifyCustomer = false;


    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getNotifyCustomer() {
        return notifyCustomer;
    }

    public void setNotifyCustomer(Boolean notifyCustomer) {
        this.notifyCustomer = notifyCustomer;
    }
}
