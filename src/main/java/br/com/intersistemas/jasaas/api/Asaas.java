package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterInterface;

/**
 *
 * @author bosco
 */
public class Asaas {

    private AdapterInterface adapter;
    private int ambiente;

    public Asaas(AdapterInterface adapter, int abstractConnectionAmbiente) {
        this.adapter = adapter;
        this.ambiente = abstractConnectionAmbiente;
    }
    
    public CityConnection city(){
        return new CityConnection(adapter, ambiente);
    }
    
    public CustomerConnection customer(){
        return new CustomerConnection(adapter, ambiente);
    }
    
    
    // TODO replicar forma para outras conexões.
}
