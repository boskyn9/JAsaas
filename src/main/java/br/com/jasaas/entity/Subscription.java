package br.com.jasaas.entity;

import br.com.jasaas.util.BillingType;
import br.com.jasaas.util.Cycle;
import br.com.jasaas.util.SubscriptionStatus;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bosco
 */
public final class Subscription {

    @Expose
    private String id;
    @Expose
    private String customer;
    @Expose
    private BillingType billingType;
    @Expose
    private BigDecimal value;
    @Expose
    private Date nextDueDate;
    @Expose
    private Discount discount;
    @Expose
    private Interest interest;
    @Expose
    private Fine fine;
    @Expose
    private Cycle cycle;
    @Expose
    private String description;
    @Expose
    private Date endDate;
    @Expose
    private Integer maxPayments;

    @Expose(serialize = false)
    private Date dateCreated;
    @Expose(serialize = false)
    private SubscriptionStatus status;

    @Expose
    private Boolean updatePendingPayments;

//    @Expose
//    private List<MetaPayment> payments = new ArrayList<>();
    @Expose
    private CreditCard creditCard;
    @Expose
    private CreditCardHolderInfo creditCardHolderInfo;
    @Expose
    private String remoteIp;

    /**
     *
     * @return Identificar único da assinatura (Gerado pelo Asaas)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return Identificador único do cliente
     */
    public String getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer Identificador único do cliente
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     *
     * @return Valor da assinatura
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param value Valor da assinatura
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     *
     * @return Data de vencimento da próxima cobrança
     */
    public Date getNextDueDate() {
        return nextDueDate;
    }

    /**
     *
     * @param nextDueDate Data de vencimento da próxima cobrança
     */
    public void setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    /**
     *
     * @return Intervalo de cobrança. Verificar tabela de intervalos.
     */
    public Cycle getCycle() {
        return cycle;
    }

    /**
     *
     * @param cycle Intervalo de cobrança. Verificar tabela de intervalos.
     */
    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    /**
     *
     * @return Forma de pagamento.
     */
    public BillingType getBillingType() {
        return billingType;
    }

    /**
     *
     * @param billingType Forma de pagamento.
     */
    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    /**
     *
     * @return Descrição da assinatura
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description Descrição da assinatura
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Somente para atualização. Caso true, atualiza as cobranças
     * pendentes da assinatura como o novo valor e/ou forma de pagamento
     */
    public Boolean getUpdatePendingPayments() {
        return updatePendingPayments;
    }

    /**
     *
     * @param updatePendingPayments Somente para atualização. Caso true,
     * atualiza as cobranças pendentes da assinatura como o novo valor e/ou
     * forma de pagamento
     */
    public void setUpdatePendingPayments(Boolean updatePendingPayments) {
        this.updatePendingPayments = updatePendingPayments;
    }

    /**
     *
     * @return Lista de cobranças da assinatura
     */
    public Integer getMaxPayments() {
        return maxPayments;
    }

    /**
     *
     * @param maxPayments Lista de cobranças da assinatura
     */
    public void setMaxPayments(Integer maxPayments) {
        this.maxPayments = maxPayments;
    }

    /**
     *
     * @return Número máximo de cobranças
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate Número máximo de cobranças
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return Status da assinatura. Valores válidos: ACTIVE, INACTIVE
     */
    public SubscriptionStatus getStatus() {
        return status;
    }

    /**
     *
     * @param status Status da assinatura. Valores válidos: ACTIVE, INACTIVE
     */
    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public Fine getFine() {
        return fine;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + ", customer=" + customer + ", billingType=" + billingType + ", value=" + value + ", nextDueDate=" + nextDueDate + ", discount=" + discount + ", interest=" + interest + ", fine=" + fine + ", cycle=" + cycle + ", description=" + description + ", endDate=" + endDate + ", maxPayments=" + maxPayments + ", dateCreated=" + dateCreated + ", status=" + status + ", updatePendingPayments=" + updatePendingPayments + ", creditCard=" + creditCard + ", creditCardHolderInfo=" + creditCardHolderInfo + ", remoteIp=" + remoteIp + '}';
    }
}
