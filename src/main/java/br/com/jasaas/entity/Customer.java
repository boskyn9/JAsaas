package br.com.jasaas.entity;

import br.com.jasaas.exception.CustomerException;
import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 * @author bosco
 */
public final class Customer {

    @Expose(serialize = false)
    private String id;
    @Expose
    private String name;
    @Expose
    private String cpfCnpj;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String mobilePhone;
    @Expose
    private String address;
    @Expose
    private String addressNumber;
    @Expose
    private String complement;
    @Expose
    private String province;
    @Expose
    private String postalCode;
    @Expose
    private String externalReference;
    @Expose
    private Boolean notificationDisabled;
    @Expose
    private String additionalEmails;
    @Expose
    private String municipalInscription;
    @Expose
    private String stateInscription;
    @Expose
    private String observations;
    @Expose
    private String groupName;

    @Expose(serialize = false)
    private String city;
    @Expose(serialize = false)
    private String state;
    @Expose(serialize = false)
    private String country;
    @Expose(serialize = false)
    private Boolean deleted;
    @Expose(serialize = false)
    private Date dateCreated;

    public Customer() {
    }

    public Customer(String name, String cpfCnpj) {
        this.name = name;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @return externalReference Campo livre, pode ser usado para pesquisa
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * @param externalReference Campo livre, pode ser usado para pesquisa.
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    /**
     * 
     * @return additionalEmails Emails adicionais para envio de notificações de cobrança
     * separados por ","
     */
    public String getAdditionalEmails() {
        return additionalEmails;
    }

    /**
     * 
     * @param additionalEmails Emails adicionais para envio de notificações de
     * cobrança separados por ","
     */
    public void setAdditionalEmails(String additionalEmails) {
        this.additionalEmails = additionalEmails;
    }

    /**
     * 
     * @return municipalInscription Inscrição municipal do cliente
     */
    public String getMunicipalInscription() {
        return municipalInscription;
    }

    /**
     * 
     * @param municipalInscription Inscrição municipal do cliente
     */
    public void setMunicipalInscription(String municipalInscription) {
        this.municipalInscription = municipalInscription;
    }

    /**
     * 
     * @return stateInscription Inscrição estadual do cliente
     */
    public String getStateInscription() {
        return stateInscription;
    }

    /**
     * 
     * @param stateInscription Inscrição estadual do cliente
     */
    public void setStateInscription(String stateInscription) {
        this.stateInscription = stateInscription;
    }

    /**
     *
     * @return observations Observações adicionais
     */
    public String getObservations() {
        return observations;
    }

    /**
     * 
     * @param observations Observações adicionais
     */
    public void setObservations(String observations) {
        this.observations = observations;
    }

     /**
     *
     * @return groupName Nome do grupo ao qual o cliente pertence
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @param groupName Nome do grupo ao qual o cliente pertence
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", cpfCnpj=" + cpfCnpj + ", email=" + email + ", phone=" + phone + ", mobilePhone=" + mobilePhone + ", address=" + address + ", addressNumber=" + addressNumber + ", complement=" + complement + ", province=" + province + ", postalCode=" + postalCode + ", externalReference=" + externalReference + ", notificationDisabled=" + notificationDisabled + ", additionalEmails=" + additionalEmails + ", municipalInscription=" + municipalInscription + ", stateInscription=" + stateInscription + ", groupName=" + groupName + ", city=" + city + ", state=" + state + ", country=" + country + ", deleted=" + deleted + ", dateCreated=" + dateCreated + '}';
    }

    public void validate() {
        if (name == null || "".equals(name)) {
            throw new CustomerException(500, "Nome inválido");
        }
        if (cpfCnpj == null || "".equals(cpfCnpj)) {
            throw new CustomerException(500, "CPF/CNPJ inválido");
        }
    }
}
