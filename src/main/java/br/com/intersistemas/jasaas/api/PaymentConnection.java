package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.entity.LinhaBoleto;
import br.com.intersistemas.jasaas.entity.QRCodePix;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.HttpParamsUtil;
import br.com.intersistemas.jasaas.util.JsonUtil;

import java.io.IOException;
import java.util.List;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.Payment;
import br.com.intersistemas.jasaas.entity.filter.PaymentFilter;
import br.com.intersistemas.jasaas.entity.meta.DeletedEntityReturn;
import br.com.intersistemas.jasaas.entity.meta.MetaError;
import br.com.intersistemas.jasaas.entity.meta.MetaPayment;

import java.util.Arrays;

/**
 * @author bosco
 */
public class PaymentConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public PaymentConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    public List<Payment> getAll() throws ConnectionException, IllegalAccessException {
        return getAll(null, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter) throws ConnectionException, IllegalAccessException {
        return getAll(paymentFilter, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter, Integer limit, Integer offset) throws ConnectionException, IllegalAccessException {
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

        lastResponseJson = adapter.get(url);
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);

        setHasMore(meta.getHasMore());
        setLimit(meta.getLimit());
        setOffset(meta.getOffset());

        return Arrays.asList(meta.getData());
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

	public List<Payment> getBySubscription(String subscription_id, String status) throws ConnectionException {
		String statusPayment = status != null ? ("?status=" + status) : "";
		lastResponseJson = adapter.get(endpoint + "/subscriptions/" + subscription_id + "/payments" + status);
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
            payment.validate();
            String data = adapter.post((endpoint + "/payments/"), paymentJSON);
            Payment paymentCreated = (Payment) JsonUtil.parse(data, Payment.class);
            if (paymentCreated.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(data, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return paymentCreated;
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Payment updatePayment(Payment payment) throws ConnectionException {
        String paymentJSON = JsonUtil.toJSON(payment);
        payment.validate();
        String data = adapter.post((endpoint + "/payments/" + payment.getId()), paymentJSON);
        Payment paymentUpdated = (Payment) JsonUtil.parse(data, Payment.class);
        if (paymentUpdated.getId() == null) {
            MetaError error = (MetaError) JsonUtil.parse(data, MetaError.class);
            throw new ConnectionException(500, error.toString(), error);
        }
        return paymentUpdated;
    }

    public boolean deletePayment(String id) throws ConnectionException, IOException {
        String data = adapter.delete((endpoint + "/payments/" + id));
        DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(data, DeletedEntityReturn.class);
        return deleted.getDeleted();
    }

    public LinhaBoleto getLinhaBoletoByIdBoleto(String id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/payments/" + id + "/identificationField");
        return (LinhaBoleto) JsonUtil.parse(lastResponseJson, LinhaBoleto.class);
    }

    public QRCodePix getQRCodeByIdBoleto(String id) throws ConnectionException {
        lastResponseJson = adapter.get(endpoint + "/payments/" + id + "/pixQrCode");
        return (QRCodePix) JsonUtil.parse(lastResponseJson, QRCodePix.class);
    }
}
