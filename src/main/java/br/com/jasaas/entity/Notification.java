package br.com.jasaas.entity;

import br.com.jasaas.enumeration.NotificationEvent;
import br.com.jasaas.enumeration.ScheduleOffset;
import com.google.gson.annotations.Expose;

/**
 *
 * @author bosco
 */
public final class Notification extends AsaasEntity<String> {

    @Expose private String id;
    @Expose private String customer;
    @Expose private Boolean enabled;
    @Expose private Boolean emailEnabledForProvider;
    @Expose private Boolean smsEnabledForProvider;
    @Expose private Boolean emailEnabledForCustomer;
    @Expose private Boolean smsEnabledForCustomer;
    @Expose private NotificationEvent event;
    @Expose private ScheduleOffset scheduleOffset;
    @Expose private Boolean deleted;

    @Override
    public boolean recordCreated() {
        return id != null;
    }

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
     * @return event Tipo de evento 
     */
    public NotificationEvent getEvent() {
        return event;
    }

    /**
     *
     * @param event Tipo de evento
     */
    public void setEvent(NotificationEvent event) {
        this.event = event;
    }

    /**
     *
     * @return scheduleOffset Somente para o evento PAYMENT_DUEDATE_WARNING.
     */
    public ScheduleOffset getScheduleOffset() {
        return scheduleOffset;
    }

    /**
     *
     * @param scheduleOffset Somente para o evento PAYMENT_DUEDATE_WARNING.
     */
    public void setScheduleOffset(ScheduleOffset scheduleOffset) {
        this.scheduleOffset = scheduleOffset;
    }

    /**
     *
     * @return emailEnabledForProvider Especifica quantos dias antes do
     * vencimento a notificação deve ser enviada. Valores válidos: 0, 5, 10 ou
     * 15
     */
    public Boolean getEmailEnabledForProvider() {
        return emailEnabledForProvider;
    }

    /**
     *
     * @param emailEnabledForProvider Especifica quantos dias antes do
     * vencimento a notificação deve ser enviada. Valores válidos: 0, 5, 10 ou
     * 15
     */
    public void setEmailEnabledForProvider(Boolean emailEnabledForProvider) {
        this.emailEnabledForProvider = emailEnabledForProvider;
    }

    /**
     *
     * @return smsEnabledForProvider Desabilita/habilita envio de email para o
     * fornecedor
     */
    public Boolean getSmsEnabledForProvider() {
        return smsEnabledForProvider;
    }

    /**
     *
     * @param smsEnabledForProvider Desabilita/habilita envio de email para o
     * fornecedor
     */
    public void setSmsEnabledForProvider(Boolean smsEnabledForProvider) {
        this.smsEnabledForProvider = smsEnabledForProvider;
    }

    /**
     *
     * @return emailEnabledForCustomer Desabilita/habilita envio de sms para o
     * fornecedor
     */
    public Boolean getEmailEnabledForCustomer() {
        return emailEnabledForCustomer;
    }

    /**
     *
     * @param emailEnabledForCustomer Desabilita/habilita envio de sms para o
     * fornecedor
     */
    public void setEmailEnabledForCustomer(Boolean emailEnabledForCustomer) {
        this.emailEnabledForCustomer = emailEnabledForCustomer;
    }

    /**
     *
     * @return smsEnabledForCustomer Desabilita/habilita envio de email para o
     * cliente
     */
    public Boolean getSmsEnabledForCustomer() {
        return smsEnabledForCustomer;
    }

    /**
     *
     * @param smsEnabledForCustomer Desabilita/habilita envio de email para o
     * cliente
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

    @Override
    public String toString() {
        return "Notification{" + "id=" + id + ", customer=" + customer + ", enabled=" + enabled + ", emailEnabledForProvider=" + emailEnabledForProvider + ", smsEnabledForProvider=" + smsEnabledForProvider + ", emailEnabledForCustomer=" + emailEnabledForCustomer + ", smsEnabledForCustomer=" + smsEnabledForCustomer + ", event=" + event + ", scheduleOffset=" + scheduleOffset + ", deleted=" + deleted + '}';
    }

}
