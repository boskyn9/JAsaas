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
    UNDEFINED, //Perguntar ao Cliente
    //Apenas como retorno:
    TRANSFER,
    DEPOSIT,
    DEBIT_CARD,
    PIX
}
