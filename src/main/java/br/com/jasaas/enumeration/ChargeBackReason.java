package br.com.jasaas.enumeration;

/**
 * Motivo do chargeback
 *
 * @author willian
 */
public enum ChargeBackReason {
	ABSENCE_OF_PRINT, // Ausência de impressão
	ABSENT_CARD_FRAUD, // Fraude em ambiente de cartão não presente
	CARD_ACTIVATED_PHONE_TRANSACTION, // Transação telefônica ativada por cartão
	CARD_FRAUD, // Fraude em ambiente de cartão presente
	CARD_RECOVERY_BULLETIN, //Boletim de negativação de cartões
	COMMERCIAL_DISAGREEMENT, // Desacordo comercial
	COPY_NOT_RECEIVED, //Cópia não atendida
	CREDIT_OR_DEBIT_PRESENTATION_ERROR, // Erro de apresentação de crédito / débito
	DIFFERENT_PAY_METHOD, // Pagamento por outros meios
	FRAUD, //Sem autorização do portador do cartão
	INCORRECT_TRANSACTION_VALUE, // Valor da transação é diferente
	INVALID_CURRENCY, // Moeda inválida
	INVALID_DATA, //Dados inválidos
	LATE_PRESENTATION, //Apresentação tardia
	LOCAL_REGULATORY_OR_LEGAL_DISPUTE, //Contestação regulatória / legal local
	MULTIPLE_ROCS, //ROCs múltiplos
	ORIGINAL_CREDIT_TRANSACTION_NOT_ACCEPTED, //Transação de crédito original não aceita
	OTHER_ABSENT_CARD_FRAUD, //Outras fraudes - Cartão ausente
	PROCESS_ERROR, //Erro de processamento
	RECEIVED_COPY_ILLEGIBLE_OR_INCOMPLETE, // Cópia atendida ilegível / incompleta
	RECURRENCE_CANCELED, // Recorrência cancelada
	REQUIRED_AUTHORIZATION_NOT_GRANTED, //Autorização requerida não obtida
	RIGHT_OF_FULL_RECOURSE_FOR_FRAUD, //Direito de regresso integral por fraude
	SALE_CANCELED, //Mercadoria / serviços cancelado
	SERVICE_DISAGREEMENT_OR_DEFECTIVE_PRODUCT, //Mercadoria / serviço com defeito ou em desacordo
	SERVICE_NOT_RECEIVED, //Mercadoria / serviços não recebidos
	SPLIT_SALE, // Desmembramento de venda
	TRANSFERS_OF_DIVERSE_RESPONSIBILITIES, // Transf. de responsabilidades diversas
	UNQUALIFIED_CAR_RENTAL_DEBIT, // Débito de aluguel de carro não qualificado
	USA_CARDHOLDER_DISPUTE, // Contestação do portador de cartão (EUA)
	VISA_FRAUD_MONITORING_PROGRAM, //Programa Visa de monitoramento de fraude
	WARNING_BULLETIN_FILE //Arquivo boletim de advertência
}
