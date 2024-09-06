package br.com.intersistemas.jasaas.entity.filter;

/**
 * Classe de filtro utilizada para buscar e filtrar clientes com base em diferentes critérios.
 *
 * Os campos disponíveis permitem filtrar clientes por nome, email, CPF/CNPJ, nome de grupo, 
 * e também permitem verificar se o cliente possui cobranças vencidas ou pendentes.
 * <p>
 * - name: Filtra os clientes pelo nome.
 * - email: Filtra os clientes pelo email.
 * - cpfCnpj: Filtra os clientes pelo CPF ou CNPJ.
 * - groupName: Filtra os clientes pelo nome do grupo ao qual pertencem.
 * - hasOverduePayments: Filtra os clientes com cobranças vencidas. Valores possíveis:
 *   true para clientes com cobranças vencidas; false para clientes sem cobranças vencidas.
 * - deletePendingPayments: Indica se cobranças e assinaturas pendentes ou atrasadas devem ser deletadas.
 * - externalReference: Filtra os clientes pela referência externa.
 * </p>
 *
 * @author bosco
 */
public class CustomerFilter {

    private String name;
    private String email;
    private String cpfCnpj;
    private String groupName;
    private Boolean hasOverduePayments;
    private Boolean deletePendingPayments;
    private String externalReference;

    /**
     * Construtor vazio padrão.
     */
    public CustomerFilter() {}

    /**
     * Construtor com parâmetros para inicializar o filtro.
     *
     * @param name Nome do cliente para filtrar.
     * @param email Email do cliente para filtrar.
     * @param cpfCnpj CPF ou CNPJ do cliente para filtrar.
     * @param groupName Nome do grupo do cliente para filtrar.
     * @param hasOverduePayments Define se o filtro deve buscar clientes com cobranças vencidas.
     * @param deletePendingPayments Define se o filtro deve deletar cobranças pendentes ou atrasadas.
     * @param externalReference Referência externa do cliente para filtrar.
     */
    public CustomerFilter(String name, String email, String cpfCnpj, String groupName, Boolean hasOverduePayments, Boolean deletePendingPayments, String externalReference) {
        this.name = name;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.groupName = groupName;
        this.hasOverduePayments = hasOverduePayments;
        this.deletePendingPayments = deletePendingPayments;
        this.externalReference = externalReference;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return name Nome do cliente
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do cliente.
     *
     * @param name Nome do cliente
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o email do cliente.
     *
     * @return email Email do cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do cliente.
     *
     * @param email Email do cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o CPF ou CNPJ do cliente.
     *
     * @return cpfCnpj CPF ou CNPJ do cliente
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o CPF ou CNPJ do cliente.
     *
     * @param cpfCnpj CPF ou CNPJ do cliente
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * Obtém o nome do grupo do cliente.
     *
     * @return groupName Nome do grupo do cliente
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Define o nome do grupo do cliente.
     *
     * @param groupName Nome do grupo do cliente
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Verifica se o cliente possui cobranças vencidas.
     *
     * @return hasOverduePayments true se o cliente possui cobranças vencidas, false caso contrário
     */
    public Boolean getHasOverduePayments() {
        return hasOverduePayments;
    }

    /**
     * Define se o cliente possui cobranças vencidas.
     *
     * @param hasOverduePayments true se o cliente possui cobranças vencidas, false caso contrário
     */
    public void setHasOverduePayments(Boolean hasOverduePayments) {
        this.hasOverduePayments = hasOverduePayments;
    }

    /**
     * Verifica se devem ser deletadas cobranças ou assinaturas pendentes.
     *
     * @return deletePendingPayments true se as cobranças pendentes devem ser deletadas, false caso contrário
     */
    public Boolean getDeletePendingPayments() {
        return deletePendingPayments;
    }

    /**
     * Define se devem ser deletadas cobranças ou assinaturas pendentes.
     *
     * @param deletePendingPayments true se as cobranças pendentes devem ser deletadas, false caso contrário
     */
    public void setDeletePendingPayments(Boolean deletePendingPayments) {
        this.deletePendingPayments = deletePendingPayments;
    }

    /**
     * Obtém a referência externa do cliente.
     *
     * @return externalReference Referência externa do cliente
     */
    public String getExternalReference() {
        return externalReference;
    }

    /**
     * Define a referência externa do cliente.
     *
     * @param externalReference Referência externa do cliente
     */
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}