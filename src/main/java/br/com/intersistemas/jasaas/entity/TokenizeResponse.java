package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

/**
 * @author bosco
 */
public final class TokenizeResponse {

    @Expose
    private String creditCardNumber;
    @Expose
    private String creditCardBrand;
    @Expose
    private String creditCardToken;
    @Expose(serialize = false)
    private LocalDateTime dateCreated;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardBrand() {
        return creditCardBrand;
    }

    public void setCreditCardBrand(String creditCardBrand) {
        this.creditCardBrand = creditCardBrand;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "TokenizeResponse{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardBrand='" + creditCardBrand + '\'' +
                ", creditCardToken='" + creditCardToken + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
