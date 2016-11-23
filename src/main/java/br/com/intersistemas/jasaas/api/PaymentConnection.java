package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.entity.filter.PaymentFilter;
import br.com.intersistemas.jasaas.entity.meta.DeletedEntityReturn;
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
                url = (endpoint + "/payments" + params + "&limit=" + limit + "&offset=" + offset);
            } else {
                url = (endpoint + "/payments" + "?limit=" + limit + "&offset=" + offset);
            }

            System.out.println(url);
            lastResponseJson = adapter.get(url);
            System.out.println(lastResponseJson);

            MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());

            List<Payment> payments = Arrays.asList(meta.getData());

            return payments;

        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
        //return null;
    }

    public Payment getById(String id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/payments/" + id);
        return (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
    }

    public List<Payment> getByPayment(String customer_id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/customers/" + customer_id + "/payments");

        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Payment[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return Arrays.asList(contentList);
    }

    public List<Payment> getByExternalReference(String externalReference) throws ConnectionException {
        String url = (endpoint + "/payments?externalReference=" + externalReference);
        lastResponseJson = adapter.get(url);
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
        Payment[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }

        return Arrays.asList(contentList);
    }

    public List<Payment> getBySubscriptions(String subscription_id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/subscriptions/" + subscription_id + "/payments");
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Payment[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return Arrays.asList(contentList);
    }

    public List<Payment> getByInstallment(String installment) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/payments?installment=[" + installment + "]");
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        Payment[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return Arrays.asList(contentList);
    }

    public Payment createPayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        if (payment.getId() == null) {
            try {
                System.out.println("createPayment");
                payment.validate();
                String data = adapter.post((endpoint + "/payments/"), paymentJSON);
                Payment paymentCreated = (Payment) JsonUtil.parse(data, Payment.class);
                return paymentCreated;
            } catch (Exception ex) {
                Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        }else{
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }        
    }

    public Payment updatePayment(Payment payment) throws ConnectionException {
        try {
            System.out.println("updatePayment");
            String paymentJSON = JsonUtil.toJSON(payment);
            payment.validate();
            String data = adapter.post((endpoint + "/payments/" + payment.getId()), paymentJSON);
            Payment paymentUpdated = (Payment) JsonUtil.parse(data, Payment.class);
            return paymentUpdated;
        } catch (Exception ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deletePayment(String id) throws ConnectionException {
        try {
            System.out.println("deletePayment");
            String data = adapter.delete((endpoint + "/payments/" + id));
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
