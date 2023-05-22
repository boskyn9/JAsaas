package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Informações do cartão de crédito
 *
 * @author jpedro
 */
public class QRCodePix {

	@Expose
	private String encodedImage;
	@Expose
	private String payload;
	@Expose
	private String expirationDate;


	/**
	 * @return QR code em base 64
	 */
	public String getEncodedImage() {return encodedImage;}
	/**
	 * @param encodedImage  QR code em base 64
	 */
	public void setEncodedImage(String encodedImage) {this.encodedImage = encodedImage;}
	/**
	 * @return Pix copia e cola
	 */
	public String getPayload() {return payload;}
	/**
	 * @param payload Pix copia e cola
	 */
	public void setPayload(String payload) {this.payload = payload;}
	/**
	 * @return Data de validade
	 */
	public String getExpirationDate() {return expirationDate;}
	/**
	 * @param expirationDate Data de validade
	 */
	public void setExpirationDate(String expirationDate) {this.expirationDate = expirationDate;}

	@Override
	public String toString() {
		return "LinhaBoleto{" + "encodedImage=" + encodedImage + ", payload=" + payload + ", expirationDate=" + expirationDate + '}';
	}

}
