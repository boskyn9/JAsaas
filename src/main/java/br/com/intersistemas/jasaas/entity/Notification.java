package br.com.intersistemas.jasaas.entity;

/**
 *
 * @author bosco
 */
public final class Notification {

    /**
     * @var int
     */
    private Integer id;
    /**
     * @var string
     */
    private String customer;
    /**
     * @var string
     */
    private String event;
    /**
     * @var int
     */
    private String scheduleOffset;
    /**
     * @var bool
     */
    private Boolean emailEnabledForProvider;
    /**
     * @var bool
     */
    private Boolean smsEnabledForProvider;
    /**
     * @var bool
     */
    private Boolean emailEnabledForCustomer;
    /**
     * @var bool
     */
    private Boolean smsEnabledForCustomer;
    /**
     * @var bool
     */
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getScheduleOffset() {
        return scheduleOffset;
    }

    public void setScheduleOffset(String scheduleOffset) {
        this.scheduleOffset = scheduleOffset;
    }

    public Boolean getEmailEnabledForProvider() {
        return emailEnabledForProvider;
    }

    public void setEmailEnabledForProvider(Boolean emailEnabledForProvider) {
        this.emailEnabledForProvider = emailEnabledForProvider;
    }

    public Boolean getSmsEnabledForProvider() {
        return smsEnabledForProvider;
    }

    public void setSmsEnabledForProvider(Boolean smsEnabledForProvider) {
        this.smsEnabledForProvider = smsEnabledForProvider;
    }

    public Boolean getEmailEnabledForCustomer() {
        return emailEnabledForCustomer;
    }

    public void setEmailEnabledForCustomer(Boolean emailEnabledForCustomer) {
        this.emailEnabledForCustomer = emailEnabledForCustomer;
    }

    public Boolean getSmsEnabledForCustomer() {
        return smsEnabledForCustomer;
    }

    public void setSmsEnabledForCustomer(Boolean smsEnabledForCustomer) {
        this.smsEnabledForCustomer = smsEnabledForCustomer;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    
}
