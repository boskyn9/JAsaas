package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.RefundStatus;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * Informações de extorno realizado
 *
 * @author gabriel caetano
 */
public class Refund {

    @Expose
    private Date dateCreated;
    @Expose
    private RefundStatus status;
    @Expose
    private String value;
    @Expose
    private String description;
    @Expose
    private String transactionReceiptUrl;

    public Refund() {
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public void setTransactionReceiptUrl(String transactionReceiptUrl) {
        this.transactionReceiptUrl = transactionReceiptUrl;
    }

    @Override
    public String toString() {
        return "Refund{" + "dateCreated=" + dateCreated + ", status=" + status + ", value=" + value + ", description=" + description + ", transactionReceiptUrl=" + transactionReceiptUrl + '}';
    }
}
