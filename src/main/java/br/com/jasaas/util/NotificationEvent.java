package br.com.jasaas.util;

/**
 * Tipo de evento
 *
 * @author willian
 */
public enum NotificationEvent {
    PAYMENT_CREATED, //Geração de nova cobrança
    PAYMENT_UPDATED, //Atualização no valor ou vencimento da cobrança
    PAYMENT_RECEIVED, // Recebimento ou confirmação da cobrança
    PAYMENT_OVERDUE, //Atraso no pagamento da cobrança
    PAYMENT_DUEDATE_WARNING, //Aviso de vencimento
    SEND_LINHA_DIGITAVEL //Envio de linha digitável
}
