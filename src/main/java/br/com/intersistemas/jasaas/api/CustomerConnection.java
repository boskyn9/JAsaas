package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterInterface;
import br.com.intersistemas.jasaas.entity.Customer;
import br.com.intersistemas.jasaas.entity.Content;
import br.com.intersistemas.jasaas.entity.Meta;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bosco
 */
public class CustomerConnection extends AbstractConnection{

    private final AdapterInterface adapter;
    
    public CustomerConnection(AdapterInterface adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Customer> getAll() {
        return getAll(null, null, null);
    }
    
    
    public List<Customer> getAll(Customer customerFilter) {
        return getAll(customerFilter, null, null);
    }
    
    public List<Customer> getAll(Customer customerFilter,Integer limit, Integer offset) {        
        try {
            String url;
            
            if(limit == null) limit = 10;
            if(offset == null) offset = 0;
            
            String params = HttpParamsUtil.parse(customerFilter);            
            if(params != null){
                url = StringFormatter.concat(endpoint,"/customers",params,"&limit=",limit,"&offset=",offset).getValue();
            }else{
                url = StringFormatter.concat(endpoint,"/customers","?limit=",limit,"&offset=",offset).getValue();
            }
            
            String retorno = adapter.get(url);
            
            System.out.println("[RETURN] " + retorno);
            
            Meta meta = (Meta) JsonUtil.parse(retorno, Meta.class);
            
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            
            Content[] contentList = meta.getData();
            List<Customer> customers = new ArrayList<>();
            for (Content content : contentList) {
                customers.add(content.getCustomer());
            }           
            return customers;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(CustomerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public Customer getById(Integer id){
        String retorno = adapter.get(StringFormatter.concat(endpoint,"/customers/",id).getValue());
        return (Customer) JsonUtil.parse(retorno, Customer.class);
    }
    
}
