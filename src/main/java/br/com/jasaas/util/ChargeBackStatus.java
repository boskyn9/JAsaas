package br.com.jasaas.util;

/**
 * Status do chargeback
 *
 * @author willian
 */
public enum ChargeBackStatus {

	REQUESTED, //Solicitado
	IN_DISPUTE, //Em contestação
	DISPUTE_LOST, //Contestação perdida
	REVERSED, //Revertido
	DONE //Concluído

}
