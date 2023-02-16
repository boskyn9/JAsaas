package br.com.jasaas.util;

/**
 * É possível utilizar webhook para que seu sistema seja notificado sobre
 * alterações que ocorram nas cobranças. Os eventos que o ASAAS notifica
 *
 * @author willian
 */
public enum PaymentEvent {
    PAYMENT_CREATED,// - Geração de nova cobrança.
    PAYMENT_UPDATED,// - Alteração no vencimento ou valor de cobrança existente.
    PAYMENT_CONFIRMED,// - Cobrança confirmada (pagamento efetuado, porém o saldo ainda não foi disponibilizado).
    PAYMENT_RECEIVED,// - Cobrança recebida.
    PAYMENT_OVERDUE,// - Cobrança vencida.
    PAYMENT_DELETED,// - Cobrança removida.
    PAYMENT_RESTORED,// - Cobrança restaurada.
    PAYMENT_REFUNDED,// - Cobrança estornada.
    PAYMENT_RECEIVED_IN_CASH_UNDONE,// - Recebimento em dinheiro desfeito.
    PAYMENT_CHARGEBACK_REQUESTED,// - Recebido chargeback.
    PAYMENT_CHARGEBACK_DISPUTE,// - Em disputa de chargeback (caso sejam apresentados documentos para contestação).
    PAYMENT_AWAITING_CHARGEBACK_REVERSAL,// - Disputa vencida, aguardando repasse da adquirente.
    PAYMENT_DUNNING_RECEIVED,// - Recebimento de negativação.
    PAYMENT_DUNNING_REQUESTED,// - Requisição de negativação.
    PAYMENT_BANK_SLIP_VIEWED,// - Boleto da cobrança visualizado pelo cliente.
    PAYMENT_CHECKOUT_VIEWED// - Fatura da cobrança visualizada pelo cliente.
}

