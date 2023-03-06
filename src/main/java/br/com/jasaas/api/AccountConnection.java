package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Account;
import br.com.jasaas.entity.filter.AccountFiltrer;
import br.com.jasaas.entity.meta.MetaAccount;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;

/**
 *
 * @author rafael
 */
public class AccountConnection extends AsaasConnection<Account, AccountFiltrer> {
    public AccountConnection(EnvironmentAsaas environmentAsaas, AdapterConnection httpClient) {
        super(environmentAsaas, httpClient, EndpointEnum.ACCOUNT);
        this.metaGenericClass = MetaAccount.class;
    }
}
