package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public final class Notification {


	public static final String PAYMENT_CREATED = "PAYMENT_CREATED";
	public static final String PAYMENT_UPDATED = "PAYMENT_UPDATED";
	public static final String PAYMENT_RECEIVED = "PAYMENT_RECEIVED";
	public static final String PAYMENT_OVERDUE = "PAYMENT_OVERDUE";
	public static final String PAYMENT_DUEDATE_WARNING = "PAYMENT_DUEDATE_WARNING";


	 @Expose private String id;
	 @Expose private String customer;
	 @Expose private Boolean enabled;    
	 @Expose private Boolean emailEnabledForProvider;
	 @Expose private Boolean smsEnabledForProvider;
	 @Expose private Boolean emailEnabledForCustomer;
	 @Expose private Boolean smsEnabledForCustomer;
	 @Expose private String event;
	 @Expose private String scheduleOffset;
         @Expose private Boolean deleted;

	/**
	 *
	 * @return id Identificador único da notificação
	 */
	public String getId() {
		return id;
	}

	/**
	 *
	 * @param id Identificador único da notificação
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *
	 * @return customer Identificador único do cliente
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 *
	 * @param customer Identificador único do cliente
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 *
	 * @return event Tipo de evento (Verificar tabela de eventos)
	 */
	public String getEvent() {
		return event;
	}

	/**
	 *
	 * @param event Tipo de evento (Verificar tabela de eventos)
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 *
	 * @return scheduleOffset Somente para o evento PAYMENT_DUEDATE_WARNING.
	 */
	public String getScheduleOffset() {
		return scheduleOffset;
	}

	/**
	 *
	 * @param scheduleOffset Somente para o evento PAYMENT_DUEDATE_WARNING.
	 */
	public void setScheduleOffset(String scheduleOffset) {
		this.scheduleOffset = scheduleOffset;
	}

	/**
	 *
	 * @return emailEnabledForProvider Especifica quantos dias antes do vencimento a notificação deve ser enviada. Valores válidos: 0, 5, 10 ou 15
	 */
	public Boolean getEmailEnabledForProvider() {
		return emailEnabledForProvider;
	}

	/**
	 *
	 * @param emailEnabledForProvider Especifica quantos dias antes do vencimento a notificação deve ser enviada. Valores válidos: 0, 5, 10 ou 15
	 */
	public void setEmailEnabledForProvider(Boolean emailEnabledForProvider) {
		this.emailEnabledForProvider = emailEnabledForProvider;
	}

	/**
	 *
	 * @return smsEnabledForProvider Desabilita/habilita envio de email para o fornecedor
	 */
	public Boolean getSmsEnabledForProvider() {
		return smsEnabledForProvider;
	}

	/**
	 *
	 * @param smsEnabledForProvider Desabilita/habilita envio de email para o fornecedor
	 */
	public void setSmsEnabledForProvider(Boolean smsEnabledForProvider) {
		this.smsEnabledForProvider = smsEnabledForProvider;
	}

	/**
	 *
	 * @return emailEnabledForCustomer Desabilita/habilita envio de sms para o fornecedor
	 */
	public Boolean getEmailEnabledForCustomer() {
		return emailEnabledForCustomer;
	}

	/**
	 *
	 * @param emailEnabledForCustomer Desabilita/habilita envio de sms para o fornecedor
	 */
	public void setEmailEnabledForCustomer(Boolean emailEnabledForCustomer) {
		this.emailEnabledForCustomer = emailEnabledForCustomer;
	}

	/**
	 *
	 * @return smsEnabledForCustomer Desabilita/habilita envio de email para o cliente
	 */
	public Boolean getSmsEnabledForCustomer() {
		return smsEnabledForCustomer;
	}

	/**
	 *
	 * @param smsEnabledForCustomer Desabilita/habilita envio de email para o cliente
	 */
	public void setSmsEnabledForCustomer(Boolean smsEnabledForCustomer) {
		this.smsEnabledForCustomer = smsEnabledForCustomer;
	}

	/**
	 *
	 * @return enabled Desabilita/habilita envio de sms para o cliente
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 *
	 * @param enabled Desabilita/habilita envio de sms para o cliente
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

        

}
