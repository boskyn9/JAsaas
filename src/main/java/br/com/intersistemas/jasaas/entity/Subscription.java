package br.com.intersistemas.jasaas.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bosco
 */
public final class Subscription {
     /**
     * @var int
     */
    private Integer id;
    /**
     * @var string
     */
    private String customer;
    /**
     * @var BigDecimal
     */
    private BigDecimal value;
    /**
     * @var BigDecimal
     */
    private BigDecimal grossValue;
    /**
     * @var Date
     */
    private Date nextDueDate;
    /**
     * @var string
     */
    private String cycle;
    /**
     * @var string
     */
    private String billingType;
    /**
     * @var string
     */
    private String description;
    /**
     * @var bool
     */
    private Boolean updatePendingPayments;
    /**
     * @var array
     */
    private List<Payment> payments = new ArrayList<>();
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
    /**
     * @var int
     */
    private Integer maxPayments;
    /**
     * @var Date
     */
    private Date endDate;

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

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public Date getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(Date nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getUpdatePendingPayments() {
        return updatePendingPayments;
    }

    public void setUpdatePendingPayments(Boolean updatePendingPayments) {
        this.updatePendingPayments = updatePendingPayments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
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

    public Integer getMaxPayments() {
        return maxPayments;
    }

    public void setMaxPayments(Integer maxPayments) {
        this.maxPayments = maxPayments;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public void addPayment(Payment payment){
        this.payments.add(payment);
    }

}
