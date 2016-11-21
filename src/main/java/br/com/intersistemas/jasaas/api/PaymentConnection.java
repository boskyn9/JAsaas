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

    public void createPayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        if (payment.getId() == null) {
            try {
                System.out.println("createPayment");
                payment.validate();
                adapter.post((endpoint + "/payments/"), paymentJSON);
            } catch (Exception ex) {
                Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            updatePayment(payment);
        }
    }

    public void saveOrUpdatePayment(Payment payment) throws ConnectionException {
        try {
            System.out.println("saveOrUpdatePayment");
            String paymentJSON = JsonUtil.toJSON(payment);
            payment.validate();
            if (payment.getId() == null) {
                adapter.post((endpoint + "/payments/"), paymentJSON);
            } else {
                adapter.post((endpoint + "/payments/" + payment.getId()), paymentJSON);
            }
        } catch (Exception ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public void updatePayment(Payment payment) throws ConnectionException {
        try {
            System.out.println("updatePayment");
            String paymentJSON = JsonUtil.toJSON(payment);
            payment.validate();
            adapter.post((endpoint + "/payments/" + payment.getId()), paymentJSON);
        } catch (Exception ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public void deletePayment(String id) throws ConnectionException {
        try {
            System.out.println("deletePayment");
            adapter.delete((endpoint + "/payments/" + id));
        } catch (Exception ex) {
            Logger.getLogger(PaymentConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
