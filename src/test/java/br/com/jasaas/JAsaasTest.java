package br.com.jasaas.teste;

import br.com.jasaas.api.Asaas;
import br.com.jasaas.entity.Account;
import br.com.jasaas.entity.Customer;
import br.com.jasaas.entity.filter.AccountFiltrer;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.CompanyType;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * @author rafael
 */
public class JAsaasTest {

    private Asaas asaas;

    public void init() {
        if (asaas != null) {
            return;
        }
        String apiKey = System.getenv("API_KEY_ASAAS");
        asaas = new Asaas(Ambiente.SANDBOX, apiKey);
        Assert.assertNotNull(asaas);
    }

//    @Test
    public void customerCreate() {
        init();
        Customer customerRequest = new Customer();
        customerRequest.setName("Marcelo Almeida");
        customerRequest.setEmail("marcelo.almeida@gmail.com");
        customerRequest.setPhone("4738010919");
        customerRequest.setMobilePhone("4799376637");
        customerRequest.setCpfCnpj("24971563792");
        customerRequest.setPostalCode("01310-000");
        customerRequest.setAddress("Av. Paulista");
        customerRequest.setAddressNumber("150");
        customerRequest.setComplement("Sala 201");
        customerRequest.setProvince("Centro");
        customerRequest.setExternalReference("12987382");
        customerRequest.setNotificationDisabled(false);
        customerRequest.setAdditionalEmails("marcelo.almeida2@gmail.com,marcelo.almeida3@gmail.com");
        customerRequest.setMunicipalInscription("46683695908");
        customerRequest.setStateInscription("646681195275");
        customerRequest.setObservations("ótimo pagador, nenhum problema até o momento");
        Customer customer = asaas.customer().createCustomer(customerRequest);
        Assert.assertNotNull(customer);
        Assert.assertNotNull(customer.getId());
    }
//    @Test
    public void cutomerList() {
        init();
        List<Customer> list = asaas.customer().getByCpfCnpj("24971563792");
        Assert.assertNotNull(list);
    }

//    @Test
    public void customerUpdate() {
        init();
        List<Customer> list = asaas.customer().getByCpfCnpj("24971563792");
        Assert.assertNotNull(list);
        if (list.isEmpty()) {
            return;
        }
        Customer customer = list.get(0);
        customer.setName("Marcelo Almeida 2");
        customer = asaas.customer().updateCustomer(customer);
        Assert.assertNotNull(customer);
    }

//    @Test
    public void customerDelete() {
        init();
        List<Customer> list = asaas.customer().getByCpfCnpj("24971563792");
        Assert.assertNotNull(list);
        if (list.isEmpty()) {
            return;
        }
        Customer customer = list.get(0);
        boolean result = asaas.customer().deleteCustomer(customer.getId());
        Assert.assertTrue(result);
    }

//    @Test
    public void customerRestore() {
        customerCreate();
        List<Customer> list = asaas.customer().getByCpfCnpj("24971563792");
        Assert.assertNotNull(list);
        if (list.isEmpty()) {
            return;
        }
        Customer customer = list.get(0);
        customerUpdate();
        customer = asaas.customer().restore(customer.getId());
        Assert.assertNotNull(customer);
    }

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

    //@Test
    public void accountList() {
        init();
        List<Account> list = asaas.account().getAll(new AccountFiltrer("56231075000138", null, null, null));
        Assert.assertNotNull(list);
    }

    //@Test
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
