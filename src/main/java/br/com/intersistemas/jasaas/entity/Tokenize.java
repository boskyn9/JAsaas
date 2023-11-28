package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

/**
 * @author bosco
 */
public final class Tokenize {

    @Expose
    private String customer;
    @Expose
    private CreditCard creditCard;
    @Expose
    private CreditCardHolderInfo creditCardHolderInfo;
    @Expose
    private String remoteIp;
    @Expose(serialize = false)
    private LocalDateTime dateCreated;

    public Tokenize() {

    }

    public Tokenize(String customer, CreditCard creditCard, CreditCardHolderInfo creditCardHolderInfo, String remoteIp) {
        this.customer = customer;
        this.creditCard = creditCard;
        this.creditCardHolderInfo = creditCardHolderInfo;
        this.remoteIp = remoteIp;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public CreditCardHolderInfo getCreditCardHolderInfo() {
        return creditCardHolderInfo;
    }

    public void setCreditCardHolderInfo(CreditCardHolderInfo creditCardHolderInfo) {
        this.creditCardHolderInfo = creditCardHolderInfo;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
}
