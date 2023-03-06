package br.com.jasaas;

import br.com.jasaas.entity.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CustomerTest extends br.com.jasaas.teste.JAsaasTest {


    @Test
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

    @Test
    public void cutomerList() {
        init();
        List<Customer> list = asaas.customer().getByCpfCnpj("24971563792");
        Assert.assertNotNull(list);
    }

    @Test
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

    @Test
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

    @Test
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

}
