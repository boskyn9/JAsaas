package br.com.intersistemas.jasaas.entity.filter;

/**
 *
 * @author bosco name - Filtra os clientes por nome ou email hasOverduePayments
 * - Filtra os clientes com cobranças vencidas. Valores: true para clientes com
 * cobranças vencidas; false para clientes sem cobranças vencidas
 * deletePendingPayments - Deleta cobranças e assinaturas pendentes ou atrasadas
 */
public class CustomerFilter {

    private String name;
    private String email;
    private String cpfCnpj;
    private String groupName;
    private Boolean hasOverduePayments;
    private Boolean deletePendingPayments;
    private String externalReference;

    public CustomerFilter() {}

    public CustomerFilter(String name, String email, String cpfCnpj, String groupName, Boolean hasOverduePayments, Boolean deletePendingPayments, String externalReference) {
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.groupName = groupName;
        this.hasOverduePayments = hasOverduePayments;
        this.deletePendingPayments = deletePendingPayments;
        this.externalReference = externalReference;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Boolean getHasOverduePayments() {
        return hasOverduePayments;
    }

    public void setHasOverduePayments(Boolean hasOverduePayments) {
        this.hasOverduePayments = hasOverduePayments;
    }

    public Boolean getDeletePendingPayments() {
        return deletePendingPayments;
    }

    public void setDeletePendingPayments(Boolean deletePendingPayments) {
        this.deletePendingPayments = deletePendingPayments;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}
