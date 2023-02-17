package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 *
 * @author rafael
 */
public final class AccountNumber {
    @Expose
    private String agency;
    @Expose
    private String account;
    @Expose
    private String accountDigit;

    public AccountNumber() {
    }

    public AccountNumber(String agency, String account, String accountDigit) {
        this.agency = agency;
        this.account = account;
        this.accountDigit = accountDigit;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(String accountDigit) {
        this.accountDigit = accountDigit;
    }
}