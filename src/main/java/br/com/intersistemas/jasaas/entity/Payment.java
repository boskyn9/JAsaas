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
    public static String BILLINGTYPE_UNDEFINED  = "UNDEFINED";
    public static String BILLINGTYPE_TRANSFER  = "TRANSFER";
    public static String BILLINGTYPE_DEPOSIT  = "DEPOSIT";

    public static final String PENDING = "PENDING";
    public static final String CONFIRMED = "CONFIRMED";
    public static final String RECEIVED = "RECEIVED";
    public static final String OVERDUE = "OVERDUE";

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
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

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public BigDecimal getInterestValue() {
        return interestValue;
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

    public Date getOriginalDueDate() {
        return originalDueDate;
    }

    public void setOriginalDueDate(Date originalDueDate) {
        this.originalDueDate = originalDueDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInvoiceUrl() {
        return invoiceUrl;
    }

    public String getBoletoUrl() {
        return boletoUrl;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
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

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
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

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", customer=" + customer + ", subscription=" + subscription + ", installment=" + installment + ", billingType=" + billingType + ", value=" + value + ", netValue=" + netValue + ", originalValue=" + originalValue + ", interestValue=" + interestValue + ", grossValue=" + grossValue + ", dueDate=" + dueDate + ", originalDueDate=" + originalDueDate + ", status=" + status + ", nossoNumero=" + nossoNumero + ", description=" + description + ", invoiceUrl=" + invoiceUrl + ", boletoUrl=" + boletoUrl + ", invoiceNumber=" + invoiceNumber + ", installmentCount=" + installmentCount + ", installmentValue=" + installmentValue + ", externalReference=" + externalReference + ", creditCardHolderName=" + creditCardHolderName + ", creditCardNumber=" + creditCardNumber + ", creditCardExpiryMonth=" + creditCardExpiryMonth + ", creditCardExpiryYear=" + creditCardExpiryYear + ", creditCardCcv=" + creditCardCcv + ", creditCardHolderFullName=" + creditCardHolderFullName + ", creditCardHolderEmail=" + creditCardHolderEmail + ", creditCardHolderCpfCnpj=" + creditCardHolderCpfCnpj + ", creditCardHolderAddress=" + creditCardHolderAddress + ", creditCardHolderAddressNumber=" + creditCardHolderAddressNumber + ", creditCardHolderAddressComplement=" + creditCardHolderAddressComplement + ", creditCardHolderProvince=" + creditCardHolderProvince + ", creditCardHolderCity=" + creditCardHolderCity + ", creditCardHolderUf=" + creditCardHolderUf + ", creditCardHolderPostalCode=" + creditCardHolderPostalCode + ", creditCardHolderPhone=" + creditCardHolderPhone + ", creditCardHolderPhoneDDD=" + creditCardHolderPhoneDDD + ", creditCardHolderMobilePhone=" + creditCardHolderMobilePhone + ", creditCardHolderMobilePhoneDDD=" + creditCardHolderMobilePhoneDDD + '}';
    }

}
