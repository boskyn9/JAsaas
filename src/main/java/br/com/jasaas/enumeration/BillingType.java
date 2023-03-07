package br.com.jasaas.enumeration;

/**
 *
 * Forma de pagamento
 *
 * @author willian
 */
public enum BillingType {
    BOLETO, //Boleto Bancário
    CREDIT_CARD, //Cartão de Crédito
    PIX, //PIX
    UNDEFINED, //Perguntar ao Cliente
    //Apenas como retorno:
    TRANSFER,
    DEPOSIT
}
