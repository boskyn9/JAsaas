package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 * Informações do titular do cartão de crédito
 *
 * @author willian
 */
public class CreditCardHolderInfo {

    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String cpfCnpj;
    @Expose
    private String postalCode;
    @Expose
    private String addressNumber;
    @Expose
    private String addressComplement;
    @Expose
    private String phone;
    @Expose
    private String mobilePhone;

    public CreditCardHolderInfo(String name, String email, String cpfCnpj, String postalCode, String addressNumber, String phone) {
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.postalCode = postalCode;
        this.addressNumber = addressNumber;
        this.phone = phone;
    }

    /**
     *
     * @return Nome do titular do cartão
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Nome do titular do cartão
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Email do titular do cartão
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email Email do titular do cartão
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return CPF ou CNPJ do titular do cartão
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     *
     * @param cpfCnpj CPF ou CNPJ do titular do cartão
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     *
     * @return CEP do titular do cartão
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode CEP do titular do cartão
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return Número do endereço do titular do cartão
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     *
     * @param addressNumber Número do endereço do titular do cartão
     */
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     *
     * @return Complemento do endereço do titular do cartão
     */
    public String getAddressComplement() {
        return addressComplement;
    }

    /**
     *
     * @param addressComplement Complemento do endereço do titular do cartão
     */
    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    /**
     *
     * @return Fone com DDD do titular do cartão
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone Fone com DDD do titular do cartão
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return Fone celular do titular do cartão
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     *
     * @param mobilePhone Fone celular do titular do cartão
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "CreditCardHolderInfo{" + "name=" + name + ", email=" + email + ", cpfCnpj=" + cpfCnpj + ", postalCode=" + postalCode + ", addressNumber=" + addressNumber + ", addressComplement=" + addressComplement + ", phone=" + phone + ", mobilePhone=" + mobilePhone + '}';
    }

}
