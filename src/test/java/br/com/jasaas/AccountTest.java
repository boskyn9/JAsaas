package br.com.jasaas;

import br.com.jasaas.entity.Account;
import br.com.jasaas.entity.filter.AccountFiltrer;
import br.com.jasaas.enumeration.CompanyType;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

public class AccountTest extends br.com.jasaas.teste.JAsaasTest {

    @Test
    public void accountCreate() {
        init();
        Account account = new Account();
        account.setName("Conta criada via API");
        account.setEmail("emaildaempresa@sandboxagende.com.br");
        account.setCpfCnpj("56231075000138");
        account.setBirthDate(Date.valueOf("1994-05-16"));
        account.setCompanyType(CompanyType.MEI);
        account.setPhone("11 32300606");
        account.setMobilePhone("11 912351155");
        account.setAddress("Av. Rolf Wiest");
        account.setAddressNumber("277");
        account.setComplement("Sala 502");
        account.setProvince("Bom Retiro");
        account.setPostalCode("89223005");
        account = asaas.account().create(account);
        Assert.assertNotNull(account);
    }

    @Test
    public void accountList() {
        init();
        List<Account> list = asaas.account().getAll(new AccountFiltrer("56231075000138", null, null, null));
        Assert.assertNotNull(list);
    }

    @Test
    public void accountFindById() {
        init();
        List<Account> list = asaas.account().getAll(new AccountFiltrer("56231075000138", null, null, null));
        if (list.isEmpty()) {
            accountCreate();
        }
        Account account = asaas.account().getById(list.get(0).getId());
        Assert.assertNotNull(account);
    }
}
