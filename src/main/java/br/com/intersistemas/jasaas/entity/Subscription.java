package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.BillingType;
import br.com.intersistemas.jasaas.util.Cycle;
import br.com.intersistemas.jasaas.util.SubscriptionStatus;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
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
    private LocalDate nextDueDate;
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
    private LocalDate endDate;
    @Expose
    private Integer maxPayments;
    @Expose
    private String externalReference;
    @Expose
    private List<Split> split;
    @Expose
    private CreditCard creditCard;
    @Expose
    private CreditCardHolderInfo creditCardHolderInfo;
    @Expose
    private String creditCardToken;
    @Expose
    private String remoteIp;
    @Expose
    private Boolean updatePendingPayments;
    @Expose(serialize = false)
    private LocalDate dateCreated;
    @Expose(serialize = false)
    private SubscriptionStatus status;

    /**
     * @return Identificar único da assinatura (Gerado pelo Asaas)
     */
    public String getId() {
        return id;
    }

    /**
     * @return Identificador único do cliente
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer Identificador único do cliente
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * @return Valor da assinatura
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value Valor da assinatura
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return Data de vencimento da próxima cobrança
     */
    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    /**
     * @param nextDueDate Data de vencimento da próxima cobrança
     */
    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    /**
     * @return Intervalo de cobrança. Verificar tabela de intervalos.
     */
    public Cycle getCycle() {
        return cycle;
    }

    /**
     * @param cycle Intervalo de cobrança. Verificar tabela de intervalos.
     */
    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    /**
     * @return Forma de pagamento.
     */
    public BillingType getBillingType() {
        return billingType;
    }

    /**
     * @param billingType Forma de pagamento.
     */
    public void setBillingType(BillingType billingType) {
        this.billingType = billingType;
    }

    /**
     * @return Descrição da assinatura
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Descrição da assinatura
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Somente para atualização. Caso true, atualiza as cobranças
     * pendentes da assinatura como o novo valor e/ou forma de pagamento
     */
    public Boolean getUpdatePendingPayments() {
        return updatePendingPayments;
    }

    /**
     * @param updatePendingPayments Somente para atualização. Caso true,
     *                              atualiza as cobranças pendentes da assinatura como o novo valor e/ou
     *                              forma de pagamento
     */
    public void setUpdatePendingPayments(Boolean updatePendingPayments) {
        this.updatePendingPayments = updatePendingPayments;
    }

    /**
     * @return Lista de cobranças da assinatura
     */
    public Integer getMaxPayments() {
        return maxPayments;
    }

    /**
     * @param maxPayments Lista de cobranças da assinatura
     */
    public void setMaxPayments(Integer maxPayments) {
        this.maxPayments = maxPayments;
    }

    /**
     * @return Número máximo de cobranças
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * @param endDate Número máximo de cobranças
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @return Status da assinatura. Valores válidos: ACTIVE, INACTIVE
     */
    public SubscriptionStatus getStatus() {
        return status;
    }

    /**
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
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

    public void setId(String id) {
        this.id = id;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public List<Split> getSplit() {
        return split;
    }

    public void setSplit(List<Split> split) {
        this.split = split;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id='" + id + '\'' +
                ", customer='" + customer + '\'' +
                ", billingType=" + billingType +
                ", value=" + value +
                ", nextDueDate=" + nextDueDate +
                ", discount=" + discount +
                ", interest=" + interest +
                ", fine=" + fine +
                ", cycle=" + cycle +
                ", description='" + description + '\'' +
                ", endDate=" + endDate +
                ", maxPayments=" + maxPayments +
                ", externalReference='" + externalReference + '\'' +
                ", split=" + split +
                ", creditCard=" + creditCard +
                ", creditCardHolderInfo=" + creditCardHolderInfo +
                ", creditCardToken='" + creditCardToken + '\'' +
                ", remoteIp='" + remoteIp + '\'' +
                ", updatePendingPayments=" + updatePendingPayments +
                ", dateCreated=" + dateCreated +
                ", status=" + status +
                '}';
    }
}
