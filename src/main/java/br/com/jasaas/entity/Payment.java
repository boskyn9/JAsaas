package br.com.jasaas.entity;

import br.com.jasaas.enumeration.BillingType;
import br.com.jasaas.enumeration.PaymentStatus;
import br.com.jasaas.exception.PaymentException;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bosco
 */
public final class Payment extends AsaasEntity<String> {

    @Expose(serialize = false)
    private String id;

    @Expose
    private String customer;
    @Expose
    private BillingType billingType;
    @Expose
    private BigDecimal value;
    @Expose
    private Date dueDate;
    @Expose
    private String description;
    @Expose
    private String externalReference;
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
    private Date dateCreated;
    @Expose(serialize = false)
    private Date creditDate;
    @Expose(serialize = false)
    private Date estimatedCreditDate;
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
    private Boolean canBePaidAfterDueDate;
    @Expose(serialize = false)
    private String pixTransaction;
    @Expose(serialize = false)
    private String pixQrCodeId;
    @Expose(serialize = false)
    private Date originalDueDate;
    @Expose(serialize = false)
    private BigDecimal originalValue;
    @Expose(serialize = false)
    private BigDecimal interestValue;
    @Expose(serialize = false)
    private Date confirmedDate;
    @Expose(serialize = false)
    private Date paymentDate;
    @Expose(serialize = false)
    private Date clientPaymentDate;
    @Expose(serialize = false)
    private String installmentNumber;
    @Expose(serialize = false)
    private Boolean antecipated;
    @Expose(serialize = false)
    private Date lastInvoiceViewedDate;
    @Expose(serialize = false)
    private Date lastBankSlipViewedDate;
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
    private List<Refund> refunds;

    @Expose
    private List<Split> split;// = new ArrayList<>();

    /**
     *
     * @return Identificador único da cobrança (Gerado pelo Asaas)
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

    public void setId(String id) {
        this.id = id;
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
     * @return Identificador único da assinatura, quando houver.
     */
    public String getSubscription() {
        return subscription;
    }

    /**
     *
     * @param subscription Identificador único da assinatura, quando houver.
     */
    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    /**
     *
     * @return Identificador único do parcelamento (quando cobrança parcelada)
     */
    public String getInstallment() {
        return installment;
    }

    /**
     *
     * @param installment Identificador único do parcelamento (quando cobrança
     * parcelada)
     */
    public void setInstallment(String installment) {
        this.installment = installment;
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
     * @return Valor da cobrança
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @param value Valor da cobrança
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     *
     * @return Valor líquido (calculado pelo Asaas)
     */
    public BigDecimal getNetValue() {
        return netValue;
    }

    /**
     *
     * @return Valor original (preenchido somente quando a cobrança é recebida
     * com valor diferente do cadastrado) (somente leitura)
     */
    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    /**
     *
     * @return Valor de multa e juros, quando houver. (somente leitura
     */
    public BigDecimal getInterestValue() {
        return interestValue;
    }

    /**
     *
     * @return Data de vencimento.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     *
     * @param dueDate Data de vencimento.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @return Data de vencimento original, definida na criação da cobrança.
     */
    public Date getOriginalDueDate() {
        return originalDueDate;
    }

    /**
     *
     * @param originalDueDate Data de vencimento original, definida na criação
     * da cobrança.
     */
    public void setOriginalDueDate(Date originalDueDate) {
        this.originalDueDate = originalDueDate;
    }

    /**
     *
     * @return Status da cobrança (Verificar tabela de status) (somente leitura)
     */
    public PaymentStatus getStatus() {
        return status;
    }

    /**
     *
     * @return Descrição da cobrança
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description Descrição da cobrança
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Link público para a fatura (somente leitura)
     */
    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    /**
     *
     * @return Número da fatura (único) (somente leitura)
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     *
     * @return Número de parcelas (somente no caso de cobrança parcelada)
     */
    public Integer getInstallmentCount() {
        return installmentCount;
    }

    /**
     *
     * @param installmentCount Número de parcelas (somente no caso de cobrança
     * parcelada)
     */
    public void setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
    }

    /**
     *
     * @return Valor da parcela (obrigatório quando informado installmentCount >
     * 1)
     */
    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    /**
     *
     * @param installmentValue Valor da parcela (obrigatório quando informado
     * installmentCount > 1)
     */
    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    /**
     *
     * @return Campo livre, pode ser usado para pesquisa
     */
    public String getExternalReference() {
        return externalReference;
    }

    public Boolean getPostalService() {
        return postalService;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public Date getEstimatedCreditDate() {
        return estimatedCreditDate;
    }

    public String getPaymentLink() {
        return paymentLink;
    }

    public Date getLastInvoiceViewedDate() {
        return lastInvoiceViewedDate;
    }

    public Date getLastBankSlipViewedDate() {
        return lastBankSlipViewedDate;
    }

    public String getTransactionReceiptUrl() {
        return transactionReceiptUrl;
    }

    public ChargeBack getChargeback() {
        return chargeback;
    }

    public List<Refund> getRefunds() {
        return refunds;
    }

    /**
     *
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getClientPaymentDate() {
        return clientPaymentDate;
    }

    public void setClientPaymentDate(Date clientPaymentDate) {
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

    public Boolean getCanBePaidAfterDueDate() {
        return canBePaidAfterDueDate;
    }

    public String getPixTransaction() {
        return pixTransaction;
    }

    public String getPixQrCodeId() {
        return pixQrCodeId;
    }

    public String getInstallmentNumber() {
        return installmentNumber;
    }

    public Boolean getAntecipated() {
        return antecipated;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", customer=" + customer + ", billingType=" + billingType + ", value=" + value + ", dueDate=" + dueDate + ", description=" + description + ", externalReference=" + externalReference + ", installmentCount=" + installmentCount + ", installmentValue=" + installmentValue + ", discount=" + discount + ", interest=" + interest + ", fine=" + fine + ", dateCreated=" + dateCreated + ", subscription=" + subscription + ", installment=" + installment + ", netValue=" + netValue + ", status=" + status + ", originalDueDate=" + originalDueDate + ", originalValue=" + originalValue + ", interestValue=" + interestValue + ", confirmedDate=" + confirmedDate + ", paymentDate=" + paymentDate + ", clientPaymentDate=" + clientPaymentDate + ", invoiceUrl=" + invoiceUrl + ", bankSlipUrl=" + bankSlipUrl + ", invoiceNumber=" + invoiceNumber + ", deleted=" + deleted + ", creditCard=" + creditCard + ", creditCardHolderInfo=" + creditCardHolderInfo + ", remoteIp=" + remoteIp + ", split=" + split + '}';
    }

    public void validate() {
        //System.out.println("VALIDACAO DO PAYMENT ANTES DO ENVIO");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
//        System.out.println("dueDate: " + dueDate);
//        System.out.println("dueDate: " + dueDate.getTime());
//        System.out.println("calendar.getTime(): " + calendar.getTime());
//        System.out.println("calendar.getTime(): " + calendar.getTime().getTime());
        if (dueDate.before(calendar.getTime())) {
            throw new PaymentException(500, "Data de vencimento inválida. A data de vencimento deve ser maior ou igual a hoje. Data informada: " + dueDate);
        }

        if (description.length() > 255) {
            //System.out.println("description: " + description);
            throw new PaymentException(500, "O campo descrição possui limite de 255 caracteres. Tamanho informado: " + description.length());
        }

        if (customer == null || "".equals(customer)) {
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
