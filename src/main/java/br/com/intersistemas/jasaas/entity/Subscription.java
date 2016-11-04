package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bosco
 */
public final class Subscription {
    
    public static String BILLINGTYPE_BOLETO = "BOLETO";
    public static String BILLINGTYPE_CREDIT_CARD = "CREDIT_CARD";
    public static String BILLINGTYPE_UNDEFINED  = "UNDEFINED ";
    
    public static String STATUS_ACTIVE  = "ACTIVE";
    public static String STATUS_INACTIVE  = "INACTIVE";

    public static String MONTHLY = "MONTHLY";
    public static String QUARTERLY = "QUARTERLY";
    public static String SEMIANNUALLY = "SEMIANNUALLY";
    public static String YEARLY = "YEARLY";
    public static String WEEKLY = "WEEKLY";
    public static String BIWEEKLY = "BIWEEKLY";
    
    @Expose  private String id;
    @Expose  private String customer;
    @Expose  private BigDecimal value;
    @Expose  private BigDecimal grossValue;
    @Expose  private Date nextDueDate;
    @Expose  private String cycle;
    @Expose  private String billingType;
    @Expose  private String description;
    @Expose  private Boolean updatePendingPayments;
    @Expose  private List<Payment> payments = new ArrayList<>();
    @Expose  private Integer maxPayments;
    @Expose  private Date endDate;

    // É necessário informar os atributos abaixo somente caso você queira que o processamento via cartão de crédito ocorra no momento da criação da assinatura
    @Expose  private String creditCardHolderName;
    @Expose  private String creditCardNumber;
    @Expose  private String creditCardExpiryMonth;
    @Expose  private String creditCardExpiryYear;
    @Expose  private String creditCardCcv;
    @Expose  private String creditCardHolderFullName;
    @Expose  private String creditCardHolderEmail;
    @Expose  private String creditCardHolderCpfCnpj;
    @Expose  private String creditCardHolderAddress;
    @Expose  private String creditCardHolderAddressNumber;
    @Expose  private String creditCardHolderAddressComplement;
    @Expose  private String creditCardHolderProvince;
    @Expose  private String creditCardHolderCity;
    @Expose  private String creditCardHolderUf;
    @Expose  private String creditCardHolderPostalCode;
    @Expose  private String creditCardHolderPhone;
    @Expose  private String creditCardHolderPhoneDDD;
    @Expose  private String creditCardHolderMobilePhone;
    @Expose  private String creditCardHolderMobilePhoneDDD;

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
     * @return Valor bruto da assinatura. É válido somente se a opção de utilização do valor bruto esteja habilitada.
     */
    public BigDecimal getGrossValue() {
        return grossValue;
    }

    /**
     *
     * @param grossValue Valor bruto da assinatura. É válido somente se a opção de utilização do valor bruto esteja habilitada.
     */
    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
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
    public String getCycle() {
        return cycle;
    }

    /**
     *
     * @param cycle Intervalo de cobrança. Verificar tabela de intervalos.
     */
    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     *
     * @return Forma de pagamento.. Valores válidos: BOLETO, CREDIT_CARD, UNDEFINED (Pergunte ao cliente)
     */
    public String getBillingType() {
        return billingType;
    }

    /**
     *
     * @param billingType Forma de pagamento.. Valores válidos: BOLETO, CREDIT_CARD, UNDEFINED (Pergunte ao cliente)
     */
    public void setBillingType(String billingType) {
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
     * @return Somente para atualização. Caso true, atualiza as cobranças pendentes da assinatura como o novo valor e/ou forma de pagamento
     */
    public Boolean getUpdatePendingPayments() {
        return updatePendingPayments;
    }

    /**
     *
     * @param updatePendingPayments Somente para atualização. Caso true, atualiza as cobranças pendentes da assinatura como o novo valor e/ou forma de pagamento
     */
    public void setUpdatePendingPayments(Boolean updatePendingPayments) {
        this.updatePendingPayments = updatePendingPayments;
    }

    /**
     *
     * @return Status da assinatura. Valores válidos: ACTIVE, INACTIVE
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     *
     * @param payments Status da assinatura. Valores válidos: ACTIVE, INACTIVE
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
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
     * @return Data limite da assinatura
     */
    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    /**
     *
     * @param creditCardHolderName Data limite da assinatura
     */
    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    /**
     *
     * @return Nome impresso no cartão de crédito
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     *
     * @param creditCardNumber Nome impresso no cartão de crédito
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     *
     * @return Número do cartão de crédito
     */
    public String getCreditCardExpiryMonth() {
        return creditCardExpiryMonth;
    }

    /**
     *
     * @param creditCardExpiryMonth Número do cartão de crédito
     */
    public void setCreditCardExpiryMonth(String creditCardExpiryMonth) {
        this.creditCardExpiryMonth = creditCardExpiryMonth;
    }

    /**
     *
     * @return Mês de vencimento do cartão (01, 02, 03,..., 12)
     */
    public String getCreditCardExpiryYear() {
        return creditCardExpiryYear;
    }

    /**
     *
     * @param creditCardExpiryYear Mês de vencimento do cartão (01, 02, 03,..., 12)
     */
    public void setCreditCardExpiryYear(String creditCardExpiryYear) {
        this.creditCardExpiryYear = creditCardExpiryYear;
    }

    /**
     *
     * @return Ano de vencimento do cartão, com 2 dígitos (14, 15, 16, ...)
     */
    public String getCreditCardCcv() {
        return creditCardCcv;
    }

    /**
     *
     * @param creditCardCcv Ano de vencimento do cartão, com 2 dígitos (14, 15, 16, ...)
     */
    public void setCreditCardCcv(String creditCardCcv) {
        this.creditCardCcv = creditCardCcv;
    }

    /**
     *
     * @return Código de segurança do cartão de crédito
     */
    public String getCreditCardHolderFullName() {
        return creditCardHolderFullName;
    }

    /**
     *
     * @param creditCardHolderFullName Código de segurança do cartão de crédito
     */
    public void setCreditCardHolderFullName(String creditCardHolderFullName) {
        this.creditCardHolderFullName = creditCardHolderFullName;
    }

    /**
     *
     * @return Nome completo do dono do cartão de crédito
     */
    public String getCreditCardHolderEmail() {
        return creditCardHolderEmail;
    }

    /**
     *
     * @param creditCardHolderEmail Nome completo do dono do cartão de crédito
     */
    public void setCreditCardHolderEmail(String creditCardHolderEmail) {
        this.creditCardHolderEmail = creditCardHolderEmail;
    }

    /**
     *
     * @return E-mail do dono do cartão de crédito
     */
    public String getCreditCardHolderCpfCnpj() {
        return creditCardHolderCpfCnpj;
    }

    /**
     *
     * @param creditCardHolderCpfCnpj E-mail do dono do cartão de crédito
     */
    public void setCreditCardHolderCpfCnpj(String creditCardHolderCpfCnpj) {
        this.creditCardHolderCpfCnpj = creditCardHolderCpfCnpj;
    }

    /**
     *
     * @return CPF ou CNPJ do dono do cartão de crédito
     */
    public String getCreditCardHolderAddress() {
        return creditCardHolderAddress;
    }

    /**
     *
     * @param creditCardHolderAddress CPF ou CNPJ do dono do cartão de crédito
     */
    public void setCreditCardHolderAddress(String creditCardHolderAddress) {
        this.creditCardHolderAddress = creditCardHolderAddress;
    }

    /**
     *
     * @return Endereço do dono do cartão de crédito (Ex.: Rua, Av.)
     */
    public String getCreditCardHolderAddressNumber() {
        return creditCardHolderAddressNumber;
    }

    /**
     *
     * @param creditCardHolderAddressNumber Endereço do dono do cartão de crédito (Ex.: Rua, Av.)
     */
    public void setCreditCardHolderAddressNumber(String creditCardHolderAddressNumber) {
        this.creditCardHolderAddressNumber = creditCardHolderAddressNumber;
    }

    /**
     *
     * @return Número do endereço do dono do cartão de crédito
     */
    public String getCreditCardHolderAddressComplement() {
        return creditCardHolderAddressComplement;
    }

    /**
     *
     * @param creditCardHolderAddressComplement Número do endereço do dono do cartão de crédito
     */
    public void setCreditCardHolderAddressComplement(String creditCardHolderAddressComplement) {
        this.creditCardHolderAddressComplement = creditCardHolderAddressComplement;
    }

    /**
     *
     * @return Complemento do endereço do dono do cartão de crédito
     */
    public String getCreditCardHolderProvince() {
        return creditCardHolderProvince;
    }

    /**
     *
     * @param creditCardHolderProvince Complemento do endereço do dono do cartão de crédito
     */
    public void setCreditCardHolderProvince(String creditCardHolderProvince) {
        this.creditCardHolderProvince = creditCardHolderProvince;
    }

    /**
     *
     * @return Bairro do dono do cartão de crédito
     */
    public String getCreditCardHolderCity() {
        return creditCardHolderCity;
    }

    /**
     *
     * @param creditCardHolderCity Bairro do dono do cartão de crédito
     */
    public void setCreditCardHolderCity(String creditCardHolderCity) {
        this.creditCardHolderCity = creditCardHolderCity;
    }

    /**
     *
     * @return Cidade do dono do cartão de crédito
     */
    public String getCreditCardHolderUf() {
        return creditCardHolderUf;
    }

    /**
     *
     * @param creditCardHolderUf Cidade do dono do cartão de crédito
     */
    public void setCreditCardHolderUf(String creditCardHolderUf) {
        this.creditCardHolderUf = creditCardHolderUf;
    }

    /**
     *
     * @return UF do dono do cartão de crédito. (Ex: SC, SP, RJ)
     */
    public String getCreditCardHolderPostalCode() {
        return creditCardHolderPostalCode;
    }

    /**
     *
     * @param creditCardHolderPostalCode UF do dono do cartão de crédito. (Ex: SC, SP, RJ)
     */
    public void setCreditCardHolderPostalCode(String creditCardHolderPostalCode) {
        this.creditCardHolderPostalCode = creditCardHolderPostalCode;
    }

    /**
     *
     * @return CEP do dono do cartão de crédito
     */
    public String getCreditCardHolderPhone() {
        return creditCardHolderPhone;
    }

    /**
     *
     * @param creditCardHolderPhone CEP do dono do cartão de crédito
     */
    public void setCreditCardHolderPhone(String creditCardHolderPhone) {
        this.creditCardHolderPhone = creditCardHolderPhone;
    }

    /**
     *
     * @return Telefone do dono do cartão de crédito
     */
    public String getCreditCardHolderPhoneDDD() {
        return creditCardHolderPhoneDDD;
    }

    /**
     *
     * @param creditCardHolderPhoneDDD Telefone do dono do cartão de crédito
     */
    public void setCreditCardHolderPhoneDDD(String creditCardHolderPhoneDDD) {
        this.creditCardHolderPhoneDDD = creditCardHolderPhoneDDD;
    }

    /**
     *
     * @return DDD do telefone do dono do cartão de crédito
     */
    public String getCreditCardHolderMobilePhone() {
        return creditCardHolderMobilePhone;
    }

    /**
     *
     * @param creditCardHolderMobilePhone DDD do telefone do dono do cartão de crédito
     */
    public void setCreditCardHolderMobilePhone(String creditCardHolderMobilePhone) {
        this.creditCardHolderMobilePhone = creditCardHolderMobilePhone;
    }

    /**
     *
     * @return Celular do dono do cartão de crédito
     */
    public String getCreditCardHolderMobilePhoneDDD() {
        return creditCardHolderMobilePhoneDDD;
    }

    /**
     *
     * @param creditCardHolderMobilePhoneDDD Celular do dono do cartão de crédito
     */
    public void setCreditCardHolderMobilePhoneDDD(String creditCardHolderMobilePhoneDDD) {
        this.creditCardHolderMobilePhoneDDD = creditCardHolderMobilePhoneDDD;
    }
}
