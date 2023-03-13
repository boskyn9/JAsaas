package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 *
 * @author rafael
 */
public final class PaymentIdentificationField {

    @Expose
    private Boolean success;
    @Expose(serialize = false)
    private String identificationField;
    @Expose(serialize = false)
    private String nossoNumero;
    @Expose(serialize = false)
    private String barCode;

    public PaymentIdentificationField() {
    }

    public PaymentIdentificationField(String identificationField, String nossoNumero, String barCode) {
        this.identificationField = identificationField;
        this.nossoNumero = nossoNumero;
        this.barCode = barCode;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getIdentificationField() {
        return identificationField;
    }

    public void setIdentificationField(String identificationField) {
        this.identificationField = identificationField;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "LinhaBoleto{" + "identificationField=" + identificationField + ", nossoNumero=" + nossoNumero + ", barCode=" + barCode + '}';
    }

}
