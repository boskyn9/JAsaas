package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 *
 * @author rafael
 */
public final class PaymentPixQrCode {

    @Expose(serialize = false)
    private String encodedImage;
    @Expose(serialize = false)
    private String payload;
    @Expose(serialize = false)
    private Date expirationDate;

    public PaymentPixQrCode() {
    }

    public PaymentPixQrCode(String encodedImage, String payload, Date expirationDate) {
        this.encodedImage = encodedImage;
        this.payload = payload;
        this.expirationDate = expirationDate;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
