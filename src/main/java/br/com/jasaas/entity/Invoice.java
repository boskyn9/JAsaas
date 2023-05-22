package br.com.jasaas.entity;

import br.com.jasaas.enumeration.InvoiceStatus;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Date;

public class Invoice extends AsaasEntity<String> {

    @Expose(serialize = false)
    private String id;
    @Expose(serialize = false)
    private InvoiceStatus status;
    @Expose
    private String customer;
    @Expose
    private String payment;
    @Expose
    private String installment;
    @Expose(serialize = false)
    private String type;
    @Expose(serialize = false)
    private String statusDescription;
    @Expose
    private String serviceDescription;
    @Expose(serialize = false)
    private String pdfUrl;
    @Expose(serialize = false)
    private String xmlUrl;
    @Expose(serialize = false)
    private String rpsSerie;
    @Expose(serialize = false)
    private String rpsNumber;
    @Expose(serialize = false)
    private String number;
    @Expose(serialize = false)
    private String validationCode;
    @Expose
    private BigDecimal value;
    @Expose
    private BigDecimal deductions;
    @Expose
    private Date effectiveDate;
    @Expose
    private String externalReference;
    @Expose
    private String observations;
    @Expose
    private String estimatedTaxesDescription;
    @Expose
    private String municipalServiceId;
    @Expose
    private String municipalServiceCode;
    @Expose
    private String municipalServiceName;
    @Expose
    private Taxes taxes;

    public Invoice() {
    }

    public Invoice(String id, InvoiceStatus status, String customer, String payment, String installment, String type,
                   String statusDescription, String serviceDescription, String pdfUrl, String xmlUrl, String rpsSerie,
                   String rpsNumber, String number, String validationCode, BigDecimal value, BigDecimal deductions,
                   Date effectiveDate, String externalReference, String observations, String estimatedTaxesDescription,
                   String municipalServiceId, String municipalServiceCode, String municipalServiceName, Taxes taxes) {
        this.id = id;
        this.status = status;
        this.customer = customer;
        this.payment = payment;
        this.installment = installment;
        this.type = type;
        this.statusDescription = statusDescription;
        this.serviceDescription = serviceDescription;
        this.pdfUrl = pdfUrl;
        this.xmlUrl = xmlUrl;
        this.rpsSerie = rpsSerie;
        this.rpsNumber = rpsNumber;
        this.number = number;
        this.validationCode = validationCode;
        this.value = value;
        this.deductions = deductions;
        this.effectiveDate = effectiveDate;
        this.externalReference = externalReference;
        this.observations = observations;
        this.estimatedTaxesDescription = estimatedTaxesDescription;
        this.municipalServiceId = municipalServiceId;
        this.municipalServiceCode = municipalServiceCode;
        this.municipalServiceName = municipalServiceName;
        this.taxes = taxes;
    }
    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getXmlUrl() {
        return xmlUrl;
    }

    public void setXmlUrl(String xmlUrl) {
        this.xmlUrl = xmlUrl;
    }

    public String getRpsSerie() {
        return rpsSerie;
    }

    public void setRpsSerie(String rpsSerie) {
        this.rpsSerie = rpsSerie;
    }

    public String getRpsNumber() {
        return rpsNumber;
    }

    public void setRpsNumber(String rpsNumber) {
        this.rpsNumber = rpsNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }

    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getEstimatedTaxesDescription() {
        return estimatedTaxesDescription;
    }

    public void setEstimatedTaxesDescription(String estimatedTaxesDescription) {
        this.estimatedTaxesDescription = estimatedTaxesDescription;
    }

    public String getMunicipalServiceId() {
        return municipalServiceId;
    }

    public void setMunicipalServiceId(String municipalServiceId) {
        this.municipalServiceId = municipalServiceId;
    }

    public String getMunicipalServiceCode() {
        return municipalServiceCode;
    }

    public void setMunicipalServiceCode(String municipalServiceCode) {
        this.municipalServiceCode = municipalServiceCode;
    }

    public String getMunicipalServiceName() {
        return municipalServiceName;
    }

    public void setMunicipalServiceName(String municipalServiceName) {
        this.municipalServiceName = municipalServiceName;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }
}
