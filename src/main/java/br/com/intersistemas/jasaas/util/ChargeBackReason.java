package br.com.intersistemas.jasaas.util;

/**
 * Motivo do chargeback
 *
 * @author willian
 */
public enum ChargeBackReason {
	/**
	 * Ausência de impressão
	 */
	ABSENCE_OF_PRINT,
	/**
	 *  Fraude em ambiente de cartão não presente
	 */
	ABSENT_CARD_FRAUD,
	/**
	 *  Transação telefônica ativada por cartão
	 */
	CARD_ACTIVATED_PHONE_TRANSACTION,
	/**
	 *  Fraude em ambiente de cartão presente
	 */
	CARD_FRAUD,
	/**
	 * Boletim de negativação de cartões
	 */
	CARD_RECOVERY_BULLETIN,
	/**
	 *  Desacordo comercial
	 */
	COMMERCIAL_DISAGREEMENT,
	/**
	 * Cópia não atendida
	 */
	COPY_NOT_RECEIVED,
	/**
	 *  Erro de apresentação de crédito / débito
	 */
	CREDIT_OR_DEBIT_PRESENTATION_ERROR,
	/**
	 *  Pagamento por outros meios
	 */
	DIFFERENT_PAY_METHOD,
	/**
	 * Sem autorização do portador do cartão
	 */
	FRAUD,
	/**
	 *  Valor da transação é diferente
	 */
	INCORRECT_TRANSACTION_VALUE,
	/**
	 *  Moeda inválida
	 */
	INVALID_CURRENCY,
	/**
	 * Dados inválidos
	 */
	INVALID_DATA,
	/**
	 * Apresentação tardia
	 */
	LATE_PRESENTATION,
	/**
	 * Contestação regulatória / legal local
	 */
	LOCAL_REGULATORY_OR_LEGAL_DISPUTE,
	/**
	 * ROCs múltiplos
	 */
	MULTIPLE_ROCS,
	/**
	 * Transação de crédito original não aceita
	 */
	ORIGINAL_CREDIT_TRANSACTION_NOT_ACCEPTED,
	/**
	 * Outras fraudes - Cartão ausente
	 */
	OTHER_ABSENT_CARD_FRAUD,
	/**
	 * Erro de processamento
	 */
	PROCESS_ERROR,
	/**
	 *  Cópia atendida ilegível / incompleta
	 */
	RECEIVED_COPY_ILLEGIBLE_OR_INCOMPLETE,
	/**
	 *  Recorrência cancelada
	 */
	RECURRENCE_CANCELED,
	/**
	 * Autorização requerida não obtida
	 */
	REQUIRED_AUTHORIZATION_NOT_GRANTED,
	/**
	 * Direito de regresso integral por fraude
	 */
	RIGHT_OF_FULL_RECOURSE_FOR_FRAUD,
	/**
	 * Mercadoria / serviços cancelado
	 */
	SALE_CANCELED,
	/**
	 * Mercadoria / serviço com defeito ou em desacordo
	 */
	SERVICE_DISAGREEMENT_OR_DEFECTIVE_PRODUCT,
	/**
	 * Mercadoria / serviços não recebidos
	 */
	SERVICE_NOT_RECEIVED,
	/**
	 *  Desmembramento de venda
	 */
	SPLIT_SALE,
	/**
	 *  Transf. de responsabilidades diversas
	 */
	TRANSFERS_OF_DIVERSE_RESPONSIBILITIES,
	/**
	 *  Débito de aluguel de carro não qualificado
	 */
	UNQUALIFIED_CAR_RENTAL_DEBIT,
	/**
	 *  Contestação do portador de cartão (EUA)
	 */
	USA_CARDHOLDER_DISPUTE,
	/**
	 * Programa Visa de monitoramento de fraude
	 */
	VISA_FRAUD_MONITORING_PROGRAM,
	/**
	 * Arquivo boletim de advertência
	 */
	WARNING_BULLETIN_FILE
}
