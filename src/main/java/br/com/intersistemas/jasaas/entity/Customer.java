package br.com.intersistemas.jasaas.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bosco
 */
public final class Customer {
    /**
     * @var String
     */
    private String id;
    /**
     * @var string
     */
    private String name;
    /**
     * @var string
     */
    private String email;
    /**
     * @var string
     */
    private String company;
    /**
     * @var string
     */
    private String phone;
    /**
     * @var string
     */
    private String mobilePhone;
    /**
     * @var string
     */
    private String address;
    /**
     * @var string
     */
    private String addressNumber;
    /**
     * @var string
     */
    private String complement;
    /**
     * @var string
     */
    private String province;
    /**
     * @var bool
     */
    private Boolean foreignCustomer;
    /**
     * @var bool
     */
    private Boolean notificationDisabled;
    /**
     * @var string
     */
    private String city;
    /**
     * @var string
     */
    private String state;
    /**
     * @var string
     */
    private String country;
    /**
     * @var string
     */
    private String postalCode;
    /**
     * @var string
     */
    private String cpfCnpj;
    /**
     * @var string
     */
    private String personType;
    /**
     * @var array
     */
    private List<Subscription> subscriptions = new ArrayList<>();
    /**
     * @var array
     */
    private List<Payment> payments = new ArrayList<>();
    /**
     * @var array
     */
    private List<Notification> notifications = new ArrayList<>();

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Boolean getForeignCustomer() {
        return foreignCustomer;
    }

    public void setForeignCustomer(Boolean foreignCustomer) {
        this.foreignCustomer = foreignCustomer;
    }

    public Boolean getNotificationDisabled() {
        return notificationDisabled;
    }

    public void setNotificationDisabled(Boolean notificationDisabled) {
        this.notificationDisabled = notificationDisabled;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
    
    public void addNotification(Notification notification){
        this.notifications.add(notification);
    }
    
    public void addPayments(Payment payment){
        this.payments.add(payment);
    }
    
    public void addSubscriptions(Subscription subscription){
        this.subscriptions.add(subscription);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", company=" + company + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", address=" + address + ", addressNumber=" + addressNumber + ", complement=" + complement + ", province=" + province + ", foreignCustomer=" + foreignCustomer + ", notificationDisabled=" + notificationDisabled + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", cpfCnpj=" + cpfCnpj + ", personType=" + personType + ", subscriptions=" + subscriptions + ", payments=" + payments + ", notifications=" + notifications + '}';
    }
    
    
}
