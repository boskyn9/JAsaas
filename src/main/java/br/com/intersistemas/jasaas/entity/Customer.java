package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bosco
 */
public final class Customer {
    @Expose(serialize = false)
    private String id;
    
     @Expose private String name;
     @Expose private String email;
     @Expose private String company;
     @Expose private String phone;
     @Expose private String mobilePhone;
     @Expose private String address;
     @Expose private String addressNumber;
     @Expose private String complement;
     @Expose private String province;
     @Expose private Boolean foreignCustomer;
     @Expose private Boolean notificationDisabled;
     @Expose private String city;
     @Expose private String state;
     @Expose private String country;
     @Expose private String postalCode;
     @Expose private String cpfCnpj;
     @Expose private String personType;
    
    private List<Subscription> subscriptions ;
    private List<Payment> payments ;
    private List<Notification> notifications ;

    @Expose(serialize = false)
    private Date dateCreated;

    public Customer() {
    }

    public Customer(String name, String email, String company, String phone, String mobilePhone, String address, String addressNumber, String complement, String province, String city, String state, String country, String postalCode, String cpfCnpj) {
        this.name = name;
        this.email = email;
        this.company = company;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.province = province;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return id Identificador único do cliente (gerado pelo Asaas, somente
     * leitura))
     */
    public String getId() {
        return id;
    }

    /**
     * @return name Nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Nome do cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return email Email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Email do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return company Nome da compania
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company Nome da compania
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return phone Telefone do cliente. Formato: (00) 00000000
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone Telefone do cliente. Formato: (00) 00000000
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return mobilePhone Telefone celular do cliente. Formato: (00) 00000000
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone Telefone celular do cliente. Formato: (00) 00000000
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return address Endereço do cliente (Rua, Av, etc)
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address Endereço do cliente (Rua, Av, etc)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return addressNumber Número do endereço
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * @param addressNumber Número do endereço
     */
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     * @return complement Complemento do endereço
     */
    public String getComplement() {
        return complement;
    }

    /**
     * @param complement Complemento do endereço
     */
    public void setComplement(String complement) {
        this.complement = complement;
    }

    /**
     * @return province Bairro do endereço
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province Bairro do endereço
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return foreignCustomer Desabilita/habilita cliente estrangeiro
     */
    public Boolean getForeignCustomer() {
        return foreignCustomer;
    }

    /**
     * @param foreignCustomer Desabilita/habilita cliente estrangeiro
     */
    public void setForeignCustomer(Boolean foreignCustomer) {
        this.foreignCustomer = foreignCustomer;
    }

    /**
     * @return notificationDisabled Caso true, desabilita o envio de
     * notificações para o cliente
     */
    public Boolean getNotificationDisabled() {
        return notificationDisabled;
    }

    /**
     * @param notificationDisabled Caso true, desabilita o envio de notificações
     * para o cliente
     */
    public void setNotificationDisabled(Boolean notificationDisabled) {
        this.notificationDisabled = notificationDisabled;
    }

    /**
     * @return city Para cliente brasileiro: Identificador único da cidade ou
     * código do IBGE. Para cliente estrangeiro: nome da cidade
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city Para cliente brasileiro: Identificador único da cidade ou
     * código do IBGE. Para cliente estrangeiro: nome da cidade
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return state Estado do cliente. Para cliente brasiliero: é somente
     * leitura. São valores padrões como SP, RJ, SC, MG, BA, etc. Para cliente
     * estrangeiro: nome do estado
     */
    public String getState() {
        return state;
    }

    /**
     * @param state Estado do cliente. Para cliente brasiliero: é somente
     * leitura. São valores padrões como SP, RJ, SC, MG, BA, etc. Para cliente
     * estrangeiro: nome do estado
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return country País do cliente. Para cliente brasileiro: é somente
     * leitura. O valor padrão é Brasil. Para cliente estrangeiro: nome do país
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country País do cliente. Para cliente brasileiro: é somente
     * leitura. O valor padrão é Brasil. Para cliente estrangeiro: nome do país
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return postalCode Código postal (CEP)
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode Código postal (CEP)
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return cpfCnpj CPF ou CNPJ do cliente (somente números)
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj CPF ou CNPJ do cliente (somente números)
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return personType Define se cliente pessoa física ou juridica. Valores
     * válidos: FISICA ou JURIDICA
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * @param personType Define se cliente pessoa física ou juridica. Valores
     * válidos: FISICA ou JURIDICA
     */
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    /**
     * @return subscriptions Lista de assinaturas do cliente, caso exista.
     * Verificar objeto “subscription”.
     */
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * @param subscriptions Lista de assinaturas do cliente, caso exista.
     * Verificar objeto “subscription”.
     */
    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * @return payments Lista de cobranças do cliente, caso exista. Verificar
     * objeto “payment”
     */
    public List<Payment> getPayments() {
        return payments;
    }

    /**
     * @param payments Lista de cobranças do cliente, caso exista. Verificar
     * objeto “payment”
     */
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     * @return notifications Lista de notificações do cliente, caso exista.
     * Verificar objeto “notification”
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * @param notifications Lista de notificações do cliente, caso exista.
     * Verificar objeto “notification”
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", email=" + email + ", company=" + company + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", address=" + address + ", addressNumber=" + addressNumber + ", complement=" + complement + ", province=" + province + ", foreignCustomer=" + foreignCustomer + ", notificationDisabled=" + notificationDisabled + ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode + ", cpfCnpj=" + cpfCnpj + ", personType=" + personType + ", subscriptions=" + subscriptions + ", payments=" + payments + ", notifications=" + notifications + '}';
    }

}
