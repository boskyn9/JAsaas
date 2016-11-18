package br.com.intersistemas.jasaas.entity.filter;

/**
 *
 * @author bosco
 *
 * description - Filtra as cobranças por descrição, nome do cliente ou email do
 * cliente customer - Filtra as cobranças pelo identificar único do cliente
 * subscription - Filtra as cobranças pelo identificar único da assinatura
 * installment - Filtra as cobranças pelo identificar único do parcelamento
 * status - Filtra as cobranças por status (Verificar tabela de status)
 *
 */
public class PaymentFilter {

    private String description;
    private String customer;
    private String subscription;
    private String installment;
    private String status;
    private String externalReference;

    public PaymentFilter() {
    }

    public PaymentFilter(String description, String customer, String subscription, String installment, String status) {
        this.description = description;
        this.customer = customer;
        this.subscription = subscription;
        this.installment = installment;
        this.status = status;
    }
         
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
    
}
