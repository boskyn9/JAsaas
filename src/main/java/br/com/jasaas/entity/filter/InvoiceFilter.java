package br.com.jasaas.entity.filter;

import br.com.jasaas.entity.Invoice;
import br.com.jasaas.entity.meta.MetaGeneric;
import com.google.gson.annotations.Expose;

import java.util.Date;

public class InvoiceFilter extends MetaGeneric<Invoice>  {

    @Expose
    private Date effectiveDateGe;//[ge]
    @Expose
    private Date effectiveDateLe;//[le]
    @Expose
    private String payment;
    @Expose
    private String installment;
    @Expose
    private String externalReference;
    @Expose
    private String status;

    public InvoiceFilter() {
    }

    public InvoiceFilter(Date effectiveDateGe, Date effectiveDateLe, String payment, String installment, String externalReference, String status) {
        this.effectiveDateGe = effectiveDateGe;
        this.effectiveDateLe = effectiveDateLe;
        this.payment = payment;
        this.installment = installment;
        this.externalReference = externalReference;
        this.status = status;
    }

    public Date getEffectiveDateGe() {
        return effectiveDateGe;
    }

    public void setEffectiveDateGe(Date effectiveDateGe) {
        this.effectiveDateGe = effectiveDateGe;
    }

    public Date getEffectiveDateLe() {
        return effectiveDateLe;
    }

    public void setEffectiveDateLe(Date effectiveDateLe) {
        this.effectiveDateLe = effectiveDateLe;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
