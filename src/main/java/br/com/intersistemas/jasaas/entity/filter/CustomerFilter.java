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
    private Boolean hasOverduePayments;
    private Boolean deletePendingPayments;

    public CustomerFilter() {
    }

    public CustomerFilter(String name, Boolean hasOverduePayments, Boolean deletePendingPayments) {
        this.name = name;
        this.hasOverduePayments = hasOverduePayments;
        this.deletePendingPayments = deletePendingPayments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
