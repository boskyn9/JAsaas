package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 * QR Code para pagamento de cobranças com PIX
 *
 * @author gabriel caetano
 */
public class PixQrCode {

    @Expose
    private Boolean success;
    @Expose
    private String encodedImage;
    @Expose
    private String payload;
    @Expose
    private Date expirationDate;

    public PixQrCode() {}

    /**
     *
     * @return success Flag informando se foi a criação do QrCode
     * foi realizada com sucesso
     */
    public Boolean getSuccess() {
        return this.success;
    }

    /**
     *
     * @param success Flag informando se foi a criação do QrCode
     * foi realizada com sucesso
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     *
    * @return encodedImage Imagem do QrCode em base64
     */
    public String getEncodedImage() {
        return this.encodedImage;
    }

    /**
     *
     * @param encodedImage Imagem do QrCode em base64
     */
    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    /**
     *
    * @return payload Copia e cola do QrCode
     */
    public String getPayload() {
        return this.payload;
    }

    /**
     *
     * @param payload Copia e cola do QrCode
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     *
    * @return expirationDate data de validade do QrCode
     */
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    /**
     *
     * @param expirationDate data de validade do QrCode
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PixQrCode{" + "success=" + success + ", encodedImage=" + encodedImage + ", payload=" + payload + ", expirationDate=" + expirationDate + '}';
    }

}
