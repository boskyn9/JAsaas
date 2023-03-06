package br.com.jasaas;

import br.com.jasaas.entity.CustomerFiscalInfo;
import br.com.jasaas.entity.MunicipalOptions;
import br.com.jasaas.util.JsonUtil;
import org.junit.Assert;
import org.junit.Test;

public class FiscalTest extends br.com.jasaas.teste.JAsaasTest {

    @Test
    public void municipalOptions() {
        init();
        MunicipalOptions options = asaas.fiscalInfo().getMunicipalOptions();
        Assert.assertNotNull(options);
    }

    @Test
    public void createOrUpdateFiscalInfo() {
        init();
        String exampleAsaasJson = "{  \"object\": \"customerFiscalInfo\",  \"simplesNacional\": false,  \"rpsSerie\": \"1\",  \"rpsNumber\": 1,  \"loteNumber\": 1,  \"username\": \"usuario\",  \"specialTaxRegime\": \"1\",  \"email\": \"marcelo.almeida@gmail.com\",  \"serviceListItem\": null,  \"cnae\": \"6209100\",  \"culturalProjectsPromoter\": false,  \"municipalInscription\": \"21779501\",  \"stateInscription\": null,  \"password\": \"secret\",  \"accessToken\": null,  \"certificateFile\": null,  \"certificatePassword\": \"secret\"}";
        CustomerFiscalInfo fiscalInfo = (CustomerFiscalInfo) JsonUtil.parse(exampleAsaasJson, CustomerFiscalInfo.class);
        fiscalInfo = asaas.fiscalInfo().createOrUpdate(fiscalInfo);
        Assert.assertNotNull(fiscalInfo);
    }

    @Test
    public void getFiscalInfo() {
        init();
        CustomerFiscalInfo fiscalInfo = asaas.fiscalInfo().getFiscalInfo();
        Assert.assertNotNull(fiscalInfo);
    }
}
