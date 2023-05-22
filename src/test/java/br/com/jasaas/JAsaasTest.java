package br.com.jasaas.teste;

import br.com.jasaas.api.Asaas;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import org.junit.Assert;

/**
 * @author rafael
 */
public class JAsaasTest {

    protected Asaas asaas;

    public void init() {
        if (asaas != null) {
            return;
        }
        String apiKey = System.getenv("API_KEY_ASAAS");
        asaas = new Asaas(EnvironmentAsaas.SANDBOX, apiKey);
        Assert.assertNotNull(asaas);
    }

}
