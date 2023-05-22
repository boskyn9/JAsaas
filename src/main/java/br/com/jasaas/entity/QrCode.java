package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

public class QrCode {
    @Expose(serialize = false)
    private String encodedImage;
    @Expose(serialize = false)
    private String payload;

    public QrCode() {
    }

    public QrCode(String encodedImage, String payload) {
        this.encodedImage = encodedImage;
        this.payload = payload;
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
}
