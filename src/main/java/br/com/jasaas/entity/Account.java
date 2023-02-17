package br.com.jasaas.entity;

import br.com.jasaas.enumeration.CompanyType;
import br.com.jasaas.enumeration.PersonType;
import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 *
 * @author rafael
 */
public class Account extends AsaasEntity<String> {
    @Expose(serialize = false)
    private String id;
    @Expose
    private String name;
    @Expose
    private String email;
    @Expose
    private String loginEmail;
    @Expose
    private String cpfCnpj;
    @Expose
    private Date birthDate;
    @Expose
    private CompanyType companyType;
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
    @Expose(serialize = false)
    private PersonType personType;
    @Expose(serialize = false)
    private String city;
    @Expose(serialize = false)
    private String state;
    @Expose(serialize = false)
    private String country;
    @Expose(serialize = false)
    private AccountNumber accountNumber;
    @Expose(serialize = false)
    private String walletId;
    @Expose(serialize = false)
    private String apiKey;

    public Account() {
    }

    public Account(String id, String name, String email, String loginEmail, String cpfCnpj, Date birthDate,
                   CompanyType companyType, String phone, String mobilePhone, String address, String addressNumber,
                   String complement, String province, String postalCode, PersonType personType, String city,
                   String state, String country, AccountNumber accountNumber, String walletId, String apiKey) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loginEmail = loginEmail;
        this.cpfCnpj = cpfCnpj;
        this.birthDate = birthDate;
        this.companyType = companyType;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.address = address;
        this.addressNumber = addressNumber;
        this.complement = complement;
        this.province = province;
        this.postalCode = postalCode;
        this.personType = personType;
        this.city = city;
        this.state = state;
        this.country = country;
        this.accountNumber = accountNumber;
        this.walletId = walletId;
        this.apiKey = apiKey;
    }

    @Override
    public boolean recordCreated() {
        return this.apiKey != null && !this.apiKey.isEmpty();
    }

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

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
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

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}