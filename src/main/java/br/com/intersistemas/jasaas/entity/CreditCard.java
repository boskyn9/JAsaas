package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Informações do cartão de crédito
 *
 * @author willian
 */
public class CreditCard {

    @Expose
    private String holderName;
    @Expose
    private String number;
    @Expose
    private String expiryMonth;
    @Expose
    private String expiryYear;
    @Expose
    private String ccv;

    @Expose(serialize = false)
    private String creditCardNumber; //Últimos 4 dígitos do cartão utilizado
    @Expose(serialize = false)
    private String creditCardBrand; //Bandeira do cartão utilizado

    public CreditCard(String holderName, String number, String expiryMonth, String expiryYear, String ccv) {
        this.holderName = holderName;
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.ccv = ccv;
    }

    /**
     * @return Nome impresso no cartão
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * @param holderName Nome impresso no cartão
     */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /**
     * @return Número do cartão
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number Número do cartão
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return Mês de expiração (ex: 06)
     */
    public String getExpiryMonth() {
        return expiryMonth;
    }

    /**
     * @param expiryMonth Mês de expiração (ex: 06)
     */
    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    /**
     * @return Ano de expiração (ex: 2019)
     */
    public String getExpiryYear() {
        return expiryYear;
    }

    /**
     * @param expiryYear Ano de expiração (ex: 2019)
     */
    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
     * @return Código de segurança
     */
    public String getCcv() {
        return ccv;
    }

    /**
     * @param ccv Código de segurança
     */
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    /**
     * @return Últimos 4 dígitos do cartão utilizado
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * @param creditCardNumber Últimos 4 dígitos do cartão utilizado
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * @return Bandeira do cartão utilizado
     */
    public String getCreditCardBrand() {
        return creditCardBrand;
    }

    /**
     * @param creditCardBrand Bandeira do cartão utilizado
     */
    public void setCreditCardBrand(String creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "holderName=" + holderName + ", number=" + number + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", ccv=" + ccv + ", creditCardNumber=" + creditCardNumber + ", creditCardBrand=" + creditCardBrand + '}';
    }

}
