package br.com.jasaas.enumeration;

/**
 *
 * Os status possíveis de uma cobrança
 *
 * @author willian
 */
public enum PaymentStatus {
    PENDING,// - Aguardando pagamento
    CONFIRMED,// - Cobrança Confirmada (Somente para cartão de crédito)
    RECEIVED,// - Recebida (saldo já creditado na conta)
    OVERDUE,// - Vencida
    REFUNDED,// - Estornada
    RECEIVED_IN_CASH,// - Recebida em dinheiro (não gera saldo na conta)
    REFUND_REQUESTED,// - Estorno Solicitado
    CHARGEBACK_REQUESTED,// - Recebido chargeback
    CHARGEBACK_DISPUTE,// - Em disputa de chargeback (caso sejam apresentados documentos para contestação)
    AWAITING_CHARGEBACK_REVERSAL,// - Disputa vencida, aguardando repasse da adquirente 
}
