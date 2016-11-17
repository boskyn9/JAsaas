package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bosco
 */
public final class Payment {

    public static String BILLINGTYPE_BOLETO = "BOLETO";
    public static String BILLINGTYPE_CREDIT_CARD = "CREDIT_CARD";
    public static String BILLINGTYPE_UNDEFINED = "UNDEFINED";
    public static String BILLINGTYPE_TRANSFER = "TRANSFER";
    public static String BILLINGTYPE_DEPOSIT = "DEPOSIT";

    public static final String PENDING = "PENDING"; //Aguardando pagamento
    public static final String CONFIRMED = "CONFIRMED"; //Cobrança confirmada, porém com o saldo ainda não disponível. Válido somente para cartão de crédito
    public static final String RECEIVED = "RECEIVED"; //Cobrança paga
    public static final String OVERDUE = "OVERDUE"; //Cobrança atrasada

    @Expose(serialize = false)
    private String id;

    @Expose private String customer;
    @Expose private String subscription;
    @Expose private Integer installment;
    @Expose private String billingType;
    @Expose private BigDecimal value;
    @Expose private BigDecimal netValue;
    @Expose private BigDecimal originalValue;
    @Expose private BigDecimal interestValue;
    @Expose private BigDecimal grossValue;
    @Expose private Date dueDate;
    @Expose private Date originalDueDate;
    @Expose private String status;
    @Expose private String nossoNumero;
    @Expose private String description;
    @Expose private String invoiceUrl;
    @Expose private String boletoUrl;
    @Expose private String invoiceNumber;
    @Expose private Integer installmentCount;
    @Expose private BigDecimal installmentValue;
    @Expose private String externalReference;

    @Expose private String creditCardHolderName;
    @Expose private String creditCardNumber;
    @Expose private String creditCardExpiryMonth;
    @Expose private String creditCardExpiryYear;
    @Expose private String creditCardCcv;
    @Expose private String creditCardHolderFullName;
    @Expose private String creditCardHolderEmail;
    @Expose private String creditCardHolderCpfCnpj;
    @Expose private String creditCardHolderAddress;
    @Expose private String creditCardHolderAddressNumber;
    @Expose private String creditCardHolderAddressComplement;
    @Expose private String creditCardHolderProvince;
    @Expose private String creditCardHolderCity;
    @Expose private String creditCardHolderUf;
    @Expose private String creditCardHolderPostalCode;
    @Expose private String creditCardHolderPhone;
    @Expose private String creditCardHolderPhoneDDD;
    @Expose private String creditCardHolderMobilePhone;
    @Expose private String creditCardHolderMobilePhoneDDD;

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
     * @return Identificador único do parcelamento, quando a cobrança fizer
     * parte de um.
     */
    public Integer getInstallment() {
        return installment;
    }

    /**
     *
     * @param installment Identificador único do parcelamento, quando a cobrança
     * fizer parte de um.
     */
    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    /**
     *
     * @return Forma de pagamento.. Valores válidos: BOLETO, CREDIT_CARD,
     * TRANSFER, DEPOSIT. Na criação, são aceitos somente BOLETO e CREDIT_CARD.
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     *
     * @param billingType Forma de pagamento.. Valores válidos: BOLETO,
     * CREDIT_CARD, TRANSFER, DEPOSIT. Na criação, são aceitos somente BOLETO e
     * CREDIT_CARD.
     */
    public void setBillingType(String billingType) {
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
     * @return Valor bruto da cobrança. É válido somente se a opção de
     * utilização do valor bruto estiver habilitada para a sua conta.
     */
    public BigDecimal getGrossValue() {
        return grossValue;
    }

    /**
     *
     * @param grossValue Valor bruto da cobrança. É válido somente se a opção de
     * utilização do valor bruto estiver habilitada para a sua conta.
     */
    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
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
    public String getStatus() {
        return status;
    }

    /**
     *
     * @return Identificador único do boleto bancário (somente leitura)
     */
    public String getNossoNumero() {
        return nossoNumero;
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
     * @return Link público para download do PDF do boleto (somente leitura)
     */
    public String getBoletoUrl() {
        return boletoUrl;
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
     * @return Quantia de parcelas (opcional)
     */
    public Integer getInstallmentCount() {
        return installmentCount;
    }

    /**
     *
     * @param installmentCount Quantia de parcelas (opcional)
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

    /**
     *
     * @param externalReference Campo livre, pode ser usado para pesquisa
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    /**
     *
     * @return Nome impresso no cartão de crédito
     */
    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    /**
     *
     * @param creditCardHolderName Nome impresso no cartão de crédito
     */
    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    /**
     *
     * @return Número do cartão de crédito
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     *
     * @param creditCardNumber Número do cartão de crédito
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     *
     * @return Mês de vencimento do cartão (01, 02, 03,..., 12
     */
    public String getCreditCardExpiryMonth() {
        return creditCardExpiryMonth;
    }

    /**
     *
     * @param creditCardExpiryMonth Mês de vencimento do cartão (01, 02, 03,...,
     * 12
     */
    public void setCreditCardExpiryMonth(String creditCardExpiryMonth) {
        this.creditCardExpiryMonth = creditCardExpiryMonth;
    }

    /**
     *
     * @return Ano de vencimento do cartão, com 2 dígitos (14, 15, 16, ...)
     */
    public String getCreditCardExpiryYear() {
        return creditCardExpiryYear;
    }

    /**
     *
     * @param creditCardExpiryYear Ano de vencimento do cartão, com 2 dígitos
     * (14, 15, 16, ...)
     */
    public void setCreditCardExpiryYear(String creditCardExpiryYear) {
        this.creditCardExpiryYear = creditCardExpiryYear;
    }

    /**
     *
     * @return Código de segurança do cartão de crédito
     */
    public String getCreditCardCcv() {
        return creditCardCcv;
    }

    /**
     *
     * @param creditCardCcv Código de segurança do cartão de crédito
     */
    public void setCreditCardCcv(String creditCardCcv) {
        this.creditCardCcv = creditCardCcv;
    }

    /**
     *
     * @return Nome completo do dono do cartão de crédito
     */
    public String getCreditCardHolderFullName() {
        return creditCardHolderFullName;
    }

    /**
     *
     * @param creditCardHolderFullName Nome completo do dono do cartão de
     * crédito
     */
    public void setCreditCardHolderFullName(String creditCardHolderFullName) {
        this.creditCardHolderFullName = creditCardHolderFullName;
    }

    /**
     *
     * @return E-mail do dono do cartão de crédito
     */
    public String getCreditCardHolderEmail() {
        return creditCardHolderEmail;
    }

    /**
     *
     * @param creditCardHolderEmail E-mail do dono do cartão de crédito
     */
    public void setCreditCardHolderEmail(String creditCardHolderEmail) {
        this.creditCardHolderEmail = creditCardHolderEmail;
    }

    /**
     *
     * @return CPF ou CNPJ do dono do cartão de crédito
     */
    public String getCreditCardHolderCpfCnpj() {
        return creditCardHolderCpfCnpj;
    }

    /**
     *
     * @param creditCardHolderCpfCnpj CPF ou CNPJ do dono do cartão de crédito
     */
    public void setCreditCardHolderCpfCnpj(String creditCardHolderCpfCnpj) {
        this.creditCardHolderCpfCnpj = creditCardHolderCpfCnpj;
    }

    /**
     *
     * @return Endereço do dono do cartão de crédito (Ex.: Rua, Av.)
     */
    public String getCreditCardHolderAddress() {
        return creditCardHolderAddress;
    }

    /**
     *
     * @param creditCardHolderAddress Endereço do dono do cartão de crédito
     * (Ex.: Rua, Av.)
     */
    public void setCreditCardHolderAddress(String creditCardHolderAddress) {
        this.creditCardHolderAddress = creditCardHolderAddress;
    }

    /**
     *
     * @return Número do endereço do dono do cartão de crédito
     */
    public String getCreditCardHolderAddressNumber() {
        return creditCardHolderAddressNumber;
    }

    /**
     *
     * @param creditCardHolderAddressNumber Número do endereço do dono do cartão
     * de crédito
     */
    public void setCreditCardHolderAddressNumber(String creditCardHolderAddressNumber) {
        this.creditCardHolderAddressNumber = creditCardHolderAddressNumber;
    }

    /**
     *
     * @return Complemento do endereço do dono do cartão de crédito
     */
    public String getCreditCardHolderAddressComplement() {
        return creditCardHolderAddressComplement;
    }

    /**
     *
     * @param creditCardHolderAddressComplement Complemento do endereço do dono
     * do cartão de crédito
     */
    public void setCreditCardHolderAddressComplement(String creditCardHolderAddressComplement) {
        this.creditCardHolderAddressComplement = creditCardHolderAddressComplement;
    }

    /**
     *
     * @return Bairro do dono do cartão de crédito
     */
    public String getCreditCardHolderProvince() {
        return creditCardHolderProvince;
    }

    /**
     *
     * @param creditCardHolderProvince Bairro do dono do cartão de crédito
     */
    public void setCreditCardHolderProvince(String creditCardHolderProvince) {
        this.creditCardHolderProvince = creditCardHolderProvince;
    }

    /**
     *
     * @return Cidade do dono do cartão de crédito
     */
    public String getCreditCardHolderCity() {
        return creditCardHolderCity;
    }

    /**
     *
     * @param creditCardHolderCity Cidade do dono do cartão de crédito
     */
    public void setCreditCardHolderCity(String creditCardHolderCity) {
        this.creditCardHolderCity = creditCardHolderCity;
    }

    /**
     *
     * @return UF do dono do cartão de crédito. (Ex: SC, SP, RJ)
     */
    public String getCreditCardHolderUf() {
        return creditCardHolderUf;
    }

    /**
     *
     * @param creditCardHolderUf UF do dono do cartão de crédito. (Ex: SC, SP,
     * RJ)
     */
    public void setCreditCardHolderUf(String creditCardHolderUf) {
        this.creditCardHolderUf = creditCardHolderUf;
    }

    /**
     *
     * @return CEP do dono do cartão de crédito
     */
    public String getCreditCardHolderPostalCode() {
        return creditCardHolderPostalCode;
    }

    /**
     *
     * @param creditCardHolderPostalCode CEP do dono do cartão de crédito
     */
    public void setCreditCardHolderPostalCode(String creditCardHolderPostalCode) {
        this.creditCardHolderPostalCode = creditCardHolderPostalCode;
    }

    /**
     *
     * @return Telefone do dono do cartão de crédito
     */
    public String getCreditCardHolderPhone() {
        return creditCardHolderPhone;
    }

    /**
     *
     * @param creditCardHolderPhone Telefone do dono do cartão de crédito
     */
    public void setCreditCardHolderPhone(String creditCardHolderPhone) {
        this.creditCardHolderPhone = creditCardHolderPhone;
    }

    /**
     *
     * @return DDD do telefone do dono do cartão de crédito
     */
    public String getCreditCardHolderPhoneDDD() {
        return creditCardHolderPhoneDDD;
    }

    /**
     *
     * @param creditCardHolderPhoneDDD DDD do telefone do dono do cartão de
     * crédito
     */
    public void setCreditCardHolderPhoneDDD(String creditCardHolderPhoneDDD) {
        this.creditCardHolderPhoneDDD = creditCardHolderPhoneDDD;
    }

    /**
     *
     * @return Celular do dono do cartão de crédito
     */
    public String getCreditCardHolderMobilePhone() {
        return creditCardHolderMobilePhone;
    }

    /**
     *
     * @param creditCardHolderMobilePhone Celular do dono do cartão de crédito
     */
    public void setCreditCardHolderMobilePhone(String creditCardHolderMobilePhone) {
        this.creditCardHolderMobilePhone = creditCardHolderMobilePhone;
    }

    /**
     *
     * @return DDD do celular do dono do cartão de crédito
     */
    public String getCreditCardHolderMobilePhoneDDD() {
        return creditCardHolderMobilePhoneDDD;
    }

    /**
     *
     * @param creditCardHolderMobilePhoneDDD DDD do celular do dono do cartão de
     * crédito
     */
    public void setCreditCardHolderMobilePhoneDDD(String creditCardHolderMobilePhoneDDD) {
        this.creditCardHolderMobilePhoneDDD = creditCardHolderMobilePhoneDDD;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", customer=" + customer + ", subscription=" + subscription + ", installment=" + installment + ", billingType=" + billingType + ", value=" + value + ", netValue=" + netValue + ", originalValue=" + originalValue + ", interestValue=" + interestValue + ", grossValue=" + grossValue + ", dueDate=" + dueDate + ", originalDueDate=" + originalDueDate + ", status=" + status + ", nossoNumero=" + nossoNumero + ", description=" + description + ", invoiceUrl=" + invoiceUrl + ", boletoUrl=" + boletoUrl + ", invoiceNumber=" + invoiceNumber + ", installmentCount=" + installmentCount + ", installmentValue=" + installmentValue + ", externalReference=" + externalReference + ", creditCardHolderName=" + creditCardHolderName + ", creditCardNumber=" + creditCardNumber + ", creditCardExpiryMonth=" + creditCardExpiryMonth + ", creditCardExpiryYear=" + creditCardExpiryYear + ", creditCardCcv=" + creditCardCcv + ", creditCardHolderFullName=" + creditCardHolderFullName + ", creditCardHolderEmail=" + creditCardHolderEmail + ", creditCardHolderCpfCnpj=" + creditCardHolderCpfCnpj + ", creditCardHolderAddress=" + creditCardHolderAddress + ", creditCardHolderAddressNumber=" + creditCardHolderAddressNumber + ", creditCardHolderAddressComplement=" + creditCardHolderAddressComplement + ", creditCardHolderProvince=" + creditCardHolderProvince + ", creditCardHolderCity=" + creditCardHolderCity + ", creditCardHolderUf=" + creditCardHolderUf + ", creditCardHolderPostalCode=" + creditCardHolderPostalCode + ", creditCardHolderPhone=" + creditCardHolderPhone + ", creditCardHolderPhoneDDD=" + creditCardHolderPhoneDDD + ", creditCardHolderMobilePhone=" + creditCardHolderMobilePhone + ", creditCardHolderMobilePhoneDDD=" + creditCardHolderMobilePhoneDDD + '}';
    }

}
