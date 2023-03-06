package br.com.intersistemas.jasaas.util;

/**
 *
 * Forma de pagamento
 *
 * @author willian
 */
public enum BillingType {
    BOLETO, //Boleto Bancário
    CREDIT_CARD, //Cartão de Crédito
    DEBIT_CARD,
    UNDEFINED, //Perguntar ao Cliente
    //Apenas como retorno:
    TRANSFER,
    DEPOSIT,
    PIX
}
