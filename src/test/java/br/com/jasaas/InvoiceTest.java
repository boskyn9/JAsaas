package br.com.jasaas;

import br.com.jasaas.entity.Invoice;
import br.com.jasaas.entity.MunicipalService;
import br.com.jasaas.util.JsonUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InvoiceTest extends br.com.jasaas.teste.JAsaasTest {
    @Test
    public void scheduleInvoice() {
        init();
        String exampleJson = "{  \"payment\": \"pay_637959110194\",  \"installment\": null,  \"serviceDescription\": \"Nota fiscal da Fatura 101940. \nDescrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\",  \"observations\": \"Mensal referente aos trabalhos de Junho.\",  \"value\": 300,  \"deductions\": 0,  \"effectiveDate\": \"2018-07-03\",  \"externalReference\": null,  \"taxes\": {    \"retainIss\": false,    \"iss\": 3,    \"cofins\": 3,    \"csll\": 1,    \"inss\": 0,    \"ir\": 1.5,    \"pis\": 0.65  },  \"municipalServiceId\": null,  \"municipalServiceCode\": \"1.01\",  \"municipalServiceName\": \"Análise e desenvolvimento de sistemas\"}";
        Invoice invoice = (Invoice) JsonUtil.parse(exampleJson, Invoice.class);
        invoice = asaas.invoice().schedule(invoice);
        Assert.assertNotNull(invoice);
    }

    @Test
    public void updateInvoice() {
        String exampleJson = "{  \"serviceDescription\": \"Nota fiscal da Fatura 101940. \nDescrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\",  \"observations\": \"Mensal referente aos trabalhos de Junho.\",  \"value\": 300,  \"deductions\": 10,  \"effectiveDate\": \"2018-07-03\",  \"externalReference\": null,  \"taxes\": {    \"retainIss\": false,    \"iss\": 3,    \"cofins\": 3,    \"csll\": 1,    \"inss\": 0,    \"ir\": 1.5,    \"pis\": 0.65  }}";
        Invoice invoice = (Invoice) JsonUtil.parse(exampleJson, Invoice.class);
        invoice = asaas.invoice().update(invoice);
        Assert.assertNotNull(invoice);
    }

    @Test
    public void getInvoice() {
        init();
        String exampleJson = "{  \"payment\": \"pay_637959110194\",  \"installment\": null,  \"serviceDescription\": \"Nota fiscal da Fatura 101940. \nDescrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\",  \"observations\": \"Mensal referente aos trabalhos de Junho.\",  \"value\": 300,  \"deductions\": 0,  \"effectiveDate\": \"2018-07-03\",  \"externalReference\": null,  \"taxes\": {    \"retainIss\": false,    \"iss\": 3,    \"cofins\": 3,    \"csll\": 1,    \"inss\": 0,    \"ir\": 1.5,    \"pis\": 0.65  },  \"municipalServiceId\": null,  \"municipalServiceCode\": \"1.01\",  \"municipalServiceName\": \"Análise e desenvolvimento de sistemas\"}";
        Invoice invoice = (Invoice) JsonUtil.parse(exampleJson, Invoice.class);
        invoice = asaas.invoice().schedule(invoice);
        invoice = asaas.invoice().getById(invoice.getId());
        Assert.assertNotNull(invoice);
    }

    @Test
    public void authorizeInvoice() {
        init();
        String exampleJson = "{  \"payment\": \"pay_637959110194\",  \"installment\": null,  \"serviceDescription\": \"Nota fiscal da Fatura 101940. \nDescrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\",  \"observations\": \"Mensal referente aos trabalhos de Junho.\",  \"value\": 300,  \"deductions\": 0,  \"effectiveDate\": \"2018-07-03\",  \"externalReference\": null,  \"taxes\": {    \"retainIss\": false,    \"iss\": 3,    \"cofins\": 3,    \"csll\": 1,    \"inss\": 0,    \"ir\": 1.5,    \"pis\": 0.65  },  \"municipalServiceId\": null,  \"municipalServiceCode\": \"1.01\",  \"municipalServiceName\": \"Análise e desenvolvimento de sistemas\"}";
        Invoice invoice = (Invoice) JsonUtil.parse(exampleJson, Invoice.class);
        invoice = asaas.invoice().schedule(invoice);
        invoice = asaas.invoice().authorizeInvoice(invoice.getId());
        Assert.assertNotNull(invoice);
    }

    @Test
    public void cancelInvoice() {
        init();
        String exampleJson = "{  \"payment\": \"pay_637959110194\",  \"installment\": null,  \"serviceDescription\": \"Nota fiscal da Fatura 101940. \nDescrição dos Serviços: ANÁLISE E DESENVOLVIMENTO DE SISTEMAS\",  \"observations\": \"Mensal referente aos trabalhos de Junho.\",  \"value\": 300,  \"deductions\": 0,  \"effectiveDate\": \"2018-07-03\",  \"externalReference\": null,  \"taxes\": {    \"retainIss\": false,    \"iss\": 3,    \"cofins\": 3,    \"csll\": 1,    \"inss\": 0,    \"ir\": 1.5,    \"pis\": 0.65  },  \"municipalServiceId\": null,  \"municipalServiceCode\": \"1.01\",  \"municipalServiceName\": \"Análise e desenvolvimento de sistemas\"}";
        Invoice invoice = (Invoice) JsonUtil.parse(exampleJson, Invoice.class);
        invoice = asaas.invoice().schedule(invoice);
        invoice = asaas.invoice().authorizeInvoice(invoice.getId());
        invoice = asaas.invoice().cancelInvoice(invoice.getId());
        Assert.assertNotNull(invoice);
    }

    @Test
    public void getMunicipalServices() {
        init();
        List<MunicipalService> municipalServices = asaas.invoice().getMunicipalServices("Analise");
        Assert.assertNotNull(municipalServices);
    }
}
