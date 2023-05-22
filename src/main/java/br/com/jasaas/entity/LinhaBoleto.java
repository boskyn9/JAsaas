package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Informações do cartão de crédito
 *
 * @author jpedro
 */
public class LinhaBoleto {

	@Expose
	private Boolean success;
	@Expose
	private String identificationField;
	@Expose
	private String nossoNumero;
	@Expose
	private String barCode;

	/**
	 * @return Linha digitável do boleto
	 */
	public String getIdentificationField() {return identificationField;}

	/**
	 * @return Número de referência do boleto
	 */
	public String getNossoNumero() {return nossoNumero;}

	/**
	 * @return Número do código de barras
	 */
	public String getBarCode() {return barCode;}

	/**
	 * @param identificationField Linha digitável do boleto
	 */
	public void setIdentificationField(String identificationField) {this.identificationField = identificationField;}

	/**
	 * @param nossoNumero Número de referência do boleto
	 */
	public void setNossoNumero(String nossoNumero) {this.nossoNumero = nossoNumero;}

	/**
	 * @param barCode Número do código de barras
	 */
	public void setBarCode(String barCode) {this.barCode = barCode;}
	public Boolean getSuccess() {return success;}
	public void setSuccess(Boolean success) {this.success = success;}

	@Override
	public String toString() {
		return "LinhaBoleto{" + "identificationField=" + identificationField + ", nossoNumero=" + nossoNumero + ", barCode=" + barCode + '}';
	}

}
