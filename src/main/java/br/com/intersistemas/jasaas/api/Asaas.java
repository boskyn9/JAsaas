package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;

/**
 * @author bosco
 */
public class Asaas {
    
    public static final int AMBIENTE_PRODUCAO = 1;
    public static final int AMBIENTE_HOMOLOGACAO = 2;

    private final AdapterConnection adapter;
    private final int ambiente;

    /**
     * @param adapter Poderá utilizar o Adapeter padrão da clase ApacheHttpClientAdapter, ou criar seu próprio que implmente a interface AdapertConnection
     * @param abstractConnectionAmbiente (1 - produção, 2 - homologação). Pode utilizar as variáveis finais e estáticas da classe Asaas
     */
    public Asaas(AdapterConnection adapter, int abstractConnectionAmbiente) {
        this.adapter = adapter;
        this.ambiente = abstractConnectionAmbiente;
    }
    
    /**
     * @return CityConnection Classe responsável pela conexão com os serviços de "city".
     */
    public CityConnection city(){
        return new CityConnection(adapter, ambiente);
    }
    
    /**
     * @return CustomerConnection Classe responsável pela conexão com os serviços de "customer". Clientes registrados no asaas.
     */
    public CustomerConnection customer(){
        return new CustomerConnection(adapter, ambiente);
    }
    
//    public PaymentConnection payment(){
//        return new PaymentConnection(adapter, ambiente);
//    }
    
//    public NotificationConnection notification(){
//        return new NotificationConnection(adapter, ambiente);
//    }
    
    
    // TODO replicar forma para outras conexões.
}
