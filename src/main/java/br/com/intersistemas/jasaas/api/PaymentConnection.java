package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.meta.ContentPayment;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import com.sun.javafx.binding.StringFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.entity.filter.PaymentFilter;
import br.com.intersistemas.jasaas.entity.meta.ContentCustomer;
import br.com.intersistemas.jasaas.entity.meta.MetaPayment;
import java.util.Arrays;

/**
 *
 * @author bosco
 */
public class PaymentConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public PaymentConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Payment> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter) throws ConnectionException {
        return getAll(paymentFilter, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            String url;

            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }

            String params = HttpParamsUtil.parse(paymentFilter);
            if (params != null) {
                url = StringFormatter.concat(endpoint, "/payments", params, "&limit=", limit, "&offset=", offset).getValue();
            } else {
                url = StringFormatter.concat(endpoint, "/payments", "?limit=", limit, "&offset=", offset).getValue();
            }

            System.out.println(url);
            
            lastResponseJson = adapter.get(url);                        
            
            MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
            
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            List<Payment> payments = Arrays.asList(meta.getData());
            
            return payments;
            
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Payment getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/payments/", id).getValue());
        return (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
    }

    public List<Payment> getByCustomer(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/customers/",customer_id,"/payments").getValue());
            
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());
        
        Payment[] contentList = meta.getData();
        if(contentList.length == 0){
            return null;
        }
        return Arrays.asList(contentList);
    }
    
    public List<Payment> getByExternalReference(String externalReference) throws ConnectionException {
        String url = StringFormatter.concat(endpoint, "/payments?externalReference=",externalReference).getValue();
        lastResponseJson = adapter.get(url);
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
        Payment[] contentList = meta.getData();
        if(contentList.length == 0){
            return null;
        }
        
        return Arrays.asList(contentList);
    }
    
    public List<Payment> getBySubscriptions(String subscription_id) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/subscriptions/",subscription_id,"/payments").getValue());
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Payment[] contentList = meta.getData();
        if(contentList.length == 0){
            return null;
        }
        return Arrays.asList(contentList);
    }
    
    public List<Payment> getByInstallment(String installment) throws ConnectionException {
        lastResponseJson = adapter.get(StringFormatter.concat(endpoint, "/payments?installment=[",installment,"]").getValue());
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Payment[] contentList = meta.getData();
        if(contentList.length == 0){
            return null;
        }
        return Arrays.asList(contentList); 
    }
    
    public void createPayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        if (payment.getId() == null) {
            adapter.post(StringFormatter.concat(endpoint, "/payments/").getValue(), paymentJSON);
        } else {
            updatePayment(payment);
        }
    }

    public void saveOrUpdatePayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        if (payment.getId() == null) {
            adapter.post(StringFormatter.concat(endpoint, "/payments/").getValue(), paymentJSON);
        } else {
            adapter.post(StringFormatter.concat(endpoint, "/payments/", payment.getId()).getValue(), paymentJSON);
        }

    }

    public void updatePayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        adapter.post(StringFormatter.concat(endpoint, "/payments/", payment.getId()).getValue(), paymentJSON);
    }

    public void deletePayment(String id) throws ConnectionException {
        adapter.delete(StringFormatter.concat(endpoint, "/payments/", id).getValue());
    }

}
