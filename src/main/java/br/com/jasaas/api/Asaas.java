package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.jasaas.enumeration.EnvironmentAsaas;

/**
 * @author bosco
 */
public class Asaas {

    private final EnvironmentAsaas environmentAsaas;
    private final AdapterConnection httpClient;

    /**
     * @param httpClient Poderá utilizar o Adapeter padrão da clase ApacheHttpClientAdapter, ou criar seu próprio que implmente a interface AdapertConnection
     * @param environmentAsaas Enum do ambiente utilizado no Asaas
     */
    public Asaas(AdapterConnection httpClient, EnvironmentAsaas environmentAsaas) {
        this.httpClient = httpClient;
        this.environmentAsaas = environmentAsaas;
    }

    public Asaas(EnvironmentAsaas environmentAsaas, String apiKey) {
        this.httpClient = new ApacheHttpClientAdapter(apiKey);
        this.environmentAsaas = environmentAsaas;
    }

    public AccountConnection account() {
        return new AccountConnection(environmentAsaas, httpClient);
    }

    /**
     * @return CityConnection Classe responsável pela conexão com os serviços de "city".
     */
    public CityConnection city(){
        return new CityConnection(httpClient, environmentAsaas);
    }

    /**
     * @return CustomerConnection Classe responsável pela conexão com os serviços de "customer". Clientes registrados no asaas.
     */
    public CustomerConnection customer(){
        return new CustomerConnection(environmentAsaas, httpClient);
    }

    public InvoiceConnection invoice() {
        return new InvoiceConnection(environmentAsaas, httpClient);
    }

    public FiscalInfoConnection fiscalInfo() {
        return new FiscalInfoConnection(environmentAsaas, httpClient);
    }

    public PaymentConnection payment(){
        return new PaymentConnection(httpClient, environmentAsaas);
    }

    public PixConnection pix() {
        return new PixConnection(httpClient, environmentAsaas);
    }

    public NotificationConnection notification(){
        return new NotificationConnection(httpClient, environmentAsaas);
    }

    public SubscriptionConnection subscription(){
        return new SubscriptionConnection(httpClient, environmentAsaas);
    }
    
    public WebhookConfigConnection webhookConfig() {
        return new WebhookConfigConnection(httpClient, environmentAsaas);
    }
}
