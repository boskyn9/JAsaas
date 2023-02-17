package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.adapter.ApacheHttpClientAdapter;
import br.com.jasaas.enumeration.Ambiente;

/**
 * @author bosco
 */
public class Asaas {

    private final Ambiente ambiente;
    private final AdapterConnection httpClient;

    /**
     * @param httpClient Poderá utilizar o Adapeter padrão da clase ApacheHttpClientAdapter, ou criar seu próprio que implmente a interface AdapertConnection
     * @param ambiente Enum do ambiente utilizado no Asaas
     */
    public Asaas(AdapterConnection httpClient, Ambiente ambiente) {
        this.httpClient = httpClient;
        this.ambiente = ambiente;
    }

    public Asaas(Ambiente ambiente, String apiKey) {
        this.httpClient = new ApacheHttpClientAdapter(apiKey);
        this.ambiente = ambiente;
    }

    public AccountConnection account() {
        return new AccountConnection(ambiente, httpClient);
    }

    /**
     * @return CityConnection Classe responsável pela conexão com os serviços de "city".
     */
    public CityConnection city(){
        return new CityConnection(httpClient, ambiente);
    }

    /**
     * @return CustomerConnection Classe responsável pela conexão com os serviços de "customer". Clientes registrados no asaas.
     */
    public CustomerConnection customer(){
        return new CustomerConnection(ambiente, httpClient);
    }

    public InvoiceConnection invoce() {
        return new InvoiceConnection(ambiente, httpClient);
    }

    public PaymentConnection payment(){
        return new PaymentConnection(httpClient, ambiente);
    }

    public PixConnection pix() {
        return new PixConnection(httpClient, ambiente);
    }

    public NotificationConnection notification(){
        return new NotificationConnection(httpClient, ambiente);
    }

    public SubscriptionConnection subscription(){
        return new SubscriptionConnection(httpClient, ambiente);
    }
    
    public WebhookConfigConnection webhookConfig() {
        return new WebhookConfigConnection(httpClient, ambiente);
    }
}
