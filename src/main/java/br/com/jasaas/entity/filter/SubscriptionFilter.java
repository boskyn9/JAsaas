package br.com.jasaas.entity.filter;

/**
 *
 * @author bosco description - Filtra as assinaturas por descrição, nome do
 * cliente ou email do cliente customer - Filtra as assinatura pelo identificar
 * único do cliente cycle - Filtra as assinaturas pelo tipo de intervalo
 */
public class SubscriptionFilter {

    private String description;
    private String customer;
    private String cycle;

    public SubscriptionFilter() {
    }

    public SubscriptionFilter(String description, String customer, String cycle) {
        this.description = description;
        this.customer = customer;
        this.cycle = cycle;
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

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

}
