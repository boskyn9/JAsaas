package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Account;
import br.com.jasaas.entity.filter.AccountFiltrer;
import br.com.jasaas.entity.meta.MetaAccount;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;

/**
 *
 * @author rafael
 */
public class AccountConnection extends AsaasConnection<Account, AccountFiltrer> {
    public AccountConnection(Ambiente ambiente, AdapterConnection httpClient) {
        super(ambiente, httpClient, EndpointEnum.ACCOUNT);
        this.metaGenericClass = MetaAccount.class;
    }
}
