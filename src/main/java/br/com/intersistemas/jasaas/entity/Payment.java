package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.exception.PaymentException;
import br.com.intersistemas.jasaas.util.BillingType;
import br.com.intersistemas.jasaas.util.PaymentStatus;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author bosco
 */
public final class Payment {

    @Expose(serialize = false)
    private String id;

    @Expose
    private String customer;
    @Expose
    private BillingType billingType;
    @Expose
    private BigDecimal value;
    @Expose
    private LocalDate dueDate;
    @Expose
    private String description;
    @Expose
    private String externalReference;
    @Expose
    private String pixTransaction;
    @Expose
    private String pixQrCodeId;
    @Expose
    private Integer installmentCount;
    @Expose
    private BigDecimal installmentValue;
    @Expose
    private Discount discount;
    @Expose
    private Interest interest;
    @Expose
    private Fine fine;
    @Expose
    private Boolean postalService = false;

    @Expose(serialize = false)
    private LocalDate dateCreated;
    @Expose(serialize = false)
    private LocalDate creditDate;
    @Expose(serialize = false)
    private LocalDate estimatedCreditDate;
    @Expose(serialize = false)
    private String subscription;
    @Expose(serialize = false)
    private String installment;
    @Expose(serialize = false)
    private String paymentLink;
    @Expose(serialize = false)
    private BigDecimal netValue;
    @Expose(serialize = false)
    private PaymentStatus status;

    @Expose(serialize = false)
    private LocalDate originalDueDate;
    @Expose(serialize = false)
    private BigDecimal originalValue;
    @Expose(serialize = false)
    private BigDecimal interestValue;
    @Expose(serialize = false)
    private LocalDate confirmedDate;
    @Expose(serialize = false)
    private LocalDate paymentDate;
    @Expose(serialize = false)
    private LocalDate clientPaymentDate;
    @Expose(serialize = false)
    private ZonedDateTime lastInvoiceViewedDate;
    @Expose(serialize = false)
    private ZonedDateTime lastBankSlipViewedDate;
    @Expose(serialize = false)
    private String invoiceUrl;
    @Expose(serialize = false)
    private String bankSlipUrl;
    @Expose(serialize = false)
    private String invoiceNumber;
    @Expose(serialize = false)
    private Boolean deleted;
    @Expose(serialize = false)
    private String transactionReceiptUrl;
    @Expose
    private CreditCard creditCard;
    @Expose
    private CreditCardHolderInfo creditCardHolderInfo;
    @Expose
    private String remoteIp;
    @Expose(serialize = false)
    private ChargeBack chargeback;
    @Expose(serialize = false)
    private Refund refunds;

    @Expose
    private List<Split> split;// = new ArrayList<>();

    /**
     * @return Identificador único da cobrança (Gerado pelo Asaas)
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
     * @return Identificador único da transação Pix à qual a cobrança pertence
     */

    public String getPixTransaction() {
        return pixTransaction;
    }

    /**
     * @param pixTransaction Identificador único da transação Pix à qual a cobrança pertence
     */

    public void setPixTransaction(String pixTransaction) {
        this.pixTransaction = pixTransaction;
    }

    /**
     * @return Identificador único do QrCode estático gerado para determinada chave Pix
     */

    public String getPixQrCodeId() {
        return pixQrCodeId;
    }

    /**
     * @param pixQrCodeId Identificador único do QrCode estático gerado para determinada chave Pix
     */
    public void setPixQrCodeId(String pixQrCodeId) {
        this.pixQrCodeId = pixQrCodeId;
    }

    /**
     * @return Identificador único da assinatura, quando houver.
     */
    public String getSubscription() {
        return subscription;
    }

    /**
     * @param subscription Identificador único da assinatura, quando houver.
     */
    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    /**
     * @return Identificador único do parcelamento (quando cobrança parcelada)
     */
    public String getInstallment() {
        return installment;
    }

    /**
     * @param installment Identificador único do parcelamento (quando cobrança
     *                    parcelada)
     */
    public void setInstallment(String installment) {
        this.installment = installment;
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
     * @return Valor da cobrança
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value Valor da cobrança
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return Valor líquido (calculado pelo Asaas)
     */
    public BigDecimal getNetValue() {
        return netValue;
    }

    /**
     * @return Valor original (preenchido somente quando a cobrança é recebida
     * com valor diferente do cadastrado) (somente leitura)
     */
    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    /**
     * @return Valor de multa e juros, quando houver. (somente leitura
     */
    public BigDecimal getInterestValue() {
        return interestValue;
    }

    /**
     * @return Data de vencimento.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate Data de vencimento.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return Data de vencimento original, definida na criação da cobrança.
     */
    public LocalDate getOriginalDueDate() {
        return originalDueDate;
    }

    /**
     * @param originalDueDate Data de vencimento original, definida na criação
     *                        da cobrança.
     */
    public void setOriginalDueDate(LocalDate originalDueDate) {
        this.originalDueDate = originalDueDate;
    }

    /**
     * @return Status da cobrança (Verificar tabela de status) (somente leitura)
     */
    public PaymentStatus getStatus() {
        return status;
    }

    /**
     * @return Descrição da cobrança
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Descrição da cobrança
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Link público para a fatura (somente leitura)
     */
    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    /**
     * @return Número da fatura (único) (somente leitura)
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @return Número de parcelas (somente no caso de cobrança parcelada)
     */
    public Integer getInstallmentCount() {
        return installmentCount;
    }

    /**
     * @param installmentCount Número de parcelas (somente no caso de cobrança
     *                         parcelada)
     */
    public void setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
    }

    /**
     * @return Valor da parcela (obrigatório quando informado installmentCount >
     * 1)
     */
    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    /**
     * @param installmentValue Valor da parcela (obrigatório quando informado
     *                         installmentCount > 1)
     */
    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    /**
     * @return Campo livre, pode ser usado para pesquisa
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * @param externalReference Campo livre, pode ser usado para pesquisa
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(LocalDate confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getClientPaymentDate() {
        return clientPaymentDate;
    }

    public void setClientPaymentDate(LocalDate clientPaymentDate) {
        this.clientPaymentDate = clientPaymentDate;
    }

    public String getBankSlipUrl() {
        return bankSlipUrl;
    }

    public void setBankSlipUrl(String bankSlipUrl) {
        this.bankSlipUrl = bankSlipUrl;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public List<Split> getSplit() {
        return split;
    }

    public void setSplit(List<Split> split) {
        this.split = split;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", customer=" + customer + ", billingType=" + billingType + ", value=" + value + ", dueDate=" + dueDate + ", description=" + description + ", externalReference=" + externalReference + ", installmentCount=" + installmentCount + ", installmentValue=" + installmentValue + ", discount=" + discount + ", interest=" + interest + ", fine=" + fine + ", dateCreated=" + dateCreated + ", subscription=" + subscription + ", installment=" + installment + ", netValue=" + netValue + ", status=" + status + ", originalDueDate=" + originalDueDate + ", originalValue=" + originalValue + ", interestValue=" + interestValue + ", confirmedDate=" + confirmedDate + ", paymentDate=" + paymentDate + ", clientPaymentDate=" + clientPaymentDate + ", invoiceUrl=" + invoiceUrl + ", bankSlipUrl=" + bankSlipUrl + ", invoiceNumber=" + invoiceNumber + ", deleted=" + deleted + ", creditCard=" + creditCard + ", creditCardHolderInfo=" + creditCardHolderInfo + ", remoteIp=" + remoteIp + ", split=" + split + '}';
    }

    public void validate() {
        if (dueDate.isBefore(LocalDate.now())) {
            throw new PaymentException(500, "Data de vencimento inválida. A data de vencimento deve ser maior ou igual a hoje. Data informada: " + dueDate);
        }

        if (description.length() > 255) {
            //System.out.println("description: " + description);
            throw new PaymentException(500, "O campo descrição possui limite de 255 caracteres. Tamanho informado: " + description.length());
        }

        if (customer == null || customer.isEmpty()) {
            throw new PaymentException(500, "Cliente inválido");
        }

        if (billingType == null) {
            throw new PaymentException(500, "Tipo de cobrança inválido. Valores possíveis no Enum BillingType");
        }

        if (value == null) {
            throw new PaymentException(500, "Valor para cobrança inválido");
        }
    }
}
