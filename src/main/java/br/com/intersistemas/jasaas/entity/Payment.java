package br.com.intersistemas.jasaas.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author bosco
 */
public final class Payment {

    /**
     * @var int
     */
    private Integer id;
    /**
     * @var string
     */
    private String customer;
    /**
     * @var string
     */
    private String subscription;
    /**
     * @var string
     */
    private String billingType;
    /**
     * @var BigDecimal
     */
    private BigDecimal value;
    /**
     * @var BigDecimal
     */
    private BigDecimal netValue;
    /**
     * @var BigDecimal
     */
    private BigDecimal originalValue;
    /**
     * @var BigDecimal
     */
    private BigDecimal interestValue;
    /**
     * @var BigDecimal
     */
    private BigDecimal grossValue;
    /**
     * @var Date
     */
    private Date dueDate;
    /**
     * @var string
     */
    private String status;
    /**
     * @var string
     */
    private String nossoNumero;
    /**
     * @var string
     */
    private String description;
    /**
     * @var string
     */
    private String invoiceNumber;
    /**
     * @var string
     */
    private String invoiceUrl;
    /**
     * @var string
     */
    private String boletoUrl;
    /**
     * @var int
     */
    private Integer installment;
    /**
     * @var int
     */
    private Integer installmentCount;
    /**
     * @var BigDecimal
     */
    private BigDecimal installmentValue;
    /**
     * @var string
     */
    private String creditCardHolderName;
    /**
     * @var string
     */
    private String creditCardNumber;
    /**
     * @var string
     */
    private String creditCardExpiryMonth;
    /**
     * @var string
     */
    private String creditCardExpiryYear;
    /**
     * @var string
     */
    private String creditCardCcv;
    /**
     * @var string
     */
    private String creditCardHolderFullName;
    /**
     * @var string
     */
    private String creditCardHolderEmail;
    /**
     * @var string
     */
    private String creditCardHolderCpfCnpj;
    /**
     * @var string
     */
    private String creditCardHolderAddress;
    /**
     * @var string
     */
    private String creditCardHolderAddressNumber;
    /**
     * @var string
     */
    private String creditCardHolderAddressComplement;
    /**
     * @var string
     */
    private String creditCardHolderProvince;
    /**
     * @var string
     */
    private String creditCardHolderCity;
    /**
     * @var string
     */
    private String creditCardHolderUf;
    /**
     * @var string
     */
    private String creditCardHolderPostalCode;
    /**
     * @var string
     */
    private String creditCardHolderPhone;
    /**
     * @var string
     */
    private String creditCardHolderPhoneDDD;
    /**
     * @var string
     */
    private String creditCardHolderMobilePhone;
    /**
     * @var string
     */
    private String creditCardHolderMobilePhoneDDD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public BigDecimal getInterestValue() {
        return interestValue;
    }

    public void setInterestValue(BigDecimal interestValue) {
        this.interestValue = interestValue;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public void setInvoiceUrl(String invoiceUrl) {
        this.invoiceUrl = invoiceUrl;
    }

    public String getBoletoUrl() {
        return boletoUrl;
    }

    public void setBoletoUrl(String boletoUrl) {
        this.boletoUrl = boletoUrl;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Integer getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(Integer installmentCount) {
        this.installmentCount = installmentCount;
    }

    public BigDecimal getInstallmentValue() {
        return installmentValue;
    }

    public void setInstallmentValue(BigDecimal installmentValue) {
        this.installmentValue = installmentValue;
    }

    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpiryMonth() {
        return creditCardExpiryMonth;
    }

    public void setCreditCardExpiryMonth(String creditCardExpiryMonth) {
        this.creditCardExpiryMonth = creditCardExpiryMonth;
    }

    public String getCreditCardExpiryYear() {
        return creditCardExpiryYear;
    }

    public void setCreditCardExpiryYear(String creditCardExpiryYear) {
        this.creditCardExpiryYear = creditCardExpiryYear;
    }

    public String getCreditCardCcv() {
        return creditCardCcv;
    }

    public void setCreditCardCcv(String creditCardCcv) {
        this.creditCardCcv = creditCardCcv;
    }

    public String getCreditCardHolderFullName() {
        return creditCardHolderFullName;
    }

    public void setCreditCardHolderFullName(String creditCardHolderFullName) {
        this.creditCardHolderFullName = creditCardHolderFullName;
    }

    public String getCreditCardHolderEmail() {
        return creditCardHolderEmail;
    }

    public void setCreditCardHolderEmail(String creditCardHolderEmail) {
        this.creditCardHolderEmail = creditCardHolderEmail;
    }

    public String getCreditCardHolderCpfCnpj() {
        return creditCardHolderCpfCnpj;
    }

    public void setCreditCardHolderCpfCnpj(String creditCardHolderCpfCnpj) {
        this.creditCardHolderCpfCnpj = creditCardHolderCpfCnpj;
    }

    public String getCreditCardHolderAddress() {
        return creditCardHolderAddress;
    }

    public void setCreditCardHolderAddress(String creditCardHolderAddress) {
        this.creditCardHolderAddress = creditCardHolderAddress;
    }

    public String getCreditCardHolderAddressNumber() {
        return creditCardHolderAddressNumber;
    }

    public void setCreditCardHolderAddressNumber(String creditCardHolderAddressNumber) {
        this.creditCardHolderAddressNumber = creditCardHolderAddressNumber;
    }

    public String getCreditCardHolderAddressComplement() {
        return creditCardHolderAddressComplement;
    }

    public void setCreditCardHolderAddressComplement(String creditCardHolderAddressComplement) {
        this.creditCardHolderAddressComplement = creditCardHolderAddressComplement;
    }

    public String getCreditCardHolderProvince() {
        return creditCardHolderProvince;
    }

    public void setCreditCardHolderProvince(String creditCardHolderProvince) {
        this.creditCardHolderProvince = creditCardHolderProvince;
    }

    public String getCreditCardHolderCity() {
        return creditCardHolderCity;
    }

    public void setCreditCardHolderCity(String creditCardHolderCity) {
        this.creditCardHolderCity = creditCardHolderCity;
    }

    public String getCreditCardHolderUf() {
        return creditCardHolderUf;
    }

    public void setCreditCardHolderUf(String creditCardHolderUf) {
        this.creditCardHolderUf = creditCardHolderUf;
    }

    public String getCreditCardHolderPostalCode() {
        return creditCardHolderPostalCode;
    }

    public void setCreditCardHolderPostalCode(String creditCardHolderPostalCode) {
        this.creditCardHolderPostalCode = creditCardHolderPostalCode;
    }

    public String getCreditCardHolderPhone() {
        return creditCardHolderPhone;
    }

    public void setCreditCardHolderPhone(String creditCardHolderPhone) {
        this.creditCardHolderPhone = creditCardHolderPhone;
    }

    public String getCreditCardHolderPhoneDDD() {
        return creditCardHolderPhoneDDD;
    }

    public void setCreditCardHolderPhoneDDD(String creditCardHolderPhoneDDD) {
        this.creditCardHolderPhoneDDD = creditCardHolderPhoneDDD;
    }

    public String getCreditCardHolderMobilePhone() {
        return creditCardHolderMobilePhone;
    }

    public void setCreditCardHolderMobilePhone(String creditCardHolderMobilePhone) {
        this.creditCardHolderMobilePhone = creditCardHolderMobilePhone;
    }

    public String getCreditCardHolderMobilePhoneDDD() {
        return creditCardHolderMobilePhoneDDD;
    }

    public void setCreditCardHolderMobilePhoneDDD(String creditCardHolderMobilePhoneDDD) {
        this.creditCardHolderMobilePhoneDDD = creditCardHolderMobilePhoneDDD;
    }
    
    
    
}
