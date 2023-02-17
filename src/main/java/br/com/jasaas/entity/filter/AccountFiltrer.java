package br.com.jasaas.entity.filter;

/**
 *
 * @author rafael
 */
public class AccountFiltrer {
    private String cpfCnpj;
    private String email;
    private String name;
    private String walletId;

    public AccountFiltrer() {
    }

    public AccountFiltrer(String cpfCnpj, String email, String name, String walletId) {
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.name = name;
        this.walletId = walletId;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }
}
