package br.com.jasaas.api;

import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.HttpParamsUtil;
import br.com.jasaas.util.JsonUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Payment;
import br.com.jasaas.entity.filter.PaymentFilter;
import br.com.jasaas.entity.meta.DeletedEntityReturn;
import br.com.jasaas.entity.meta.MetaError;
import br.com.jasaas.entity.meta.MetaPayment;

import java.util.Arrays;

/**
 *
 * @author bosco
 */
public class PaymentConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(PaymentConnection.class.getName());

    public PaymentConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }

    public List<Payment> getAll() throws ConnectionException {
        return getAll(null, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter) throws ConnectionException {
        return getAll(paymentFilter, null, null);
    }

    public List<Payment> getAll(PaymentFilter paymentFilter, Integer limit, Integer offset) throws ConnectionException {
        try {
            if (limit == null) {
                limit = 10;
            }
            if (offset == null) {
                offset = 0;
            }
            String params = HttpParamsUtil.parse(paymentFilter);
            String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), params, limit, offset);
            this.logger.log(Level.INFO, "GET URL: {0}", url);
            lastResponseJson = httpClient.get(url);
            this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
            MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
            setHasMore(meta.getHasMore());
            setLimit(meta.getLimit());
            setOffset(meta.getOffset());
            List<Payment> payments = Arrays.asList(meta.getData());
            return payments;
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public Payment getById(String id) throws ConnectionException {
        String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
    }

    public List<Payment> getByPayment(String customer_id) throws ConnectionException {
        String url = String.format("%s/%s", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint());
        url = url.replace("{id}", customer_id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
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
        String url = String.format("%s/%s?externalReference=%s", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), externalReference);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
        Payment[] contentList = meta.getData();
        if (contentList.length == 0) {
            return null;
        }
        return Arrays.asList(contentList);
    }

    public List<Payment> getBySubscriptions(String subscription_id) throws ConnectionException {
        String url = String.format("%s/%s", this.ambiente.getEndpoint(), EndpointEnum.SUBSCRIPTION_PAYMENT.getEndpoint());
        url = url.replace("{id}", subscription_id);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
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
        String url = String.format("%s/%s?installment=[%s]", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), installment);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
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
        if (payment.getId() == null) {
            try {
                payment.validate();
                String paymentJSON = JsonUtil.toJSON(payment);
                String url = String.format(this.templateCreate, this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint());
                this.logger.log(Level.INFO, "POST URL: {0}", url);
                this.logger.log(Level.INFO, "POST PAYLOAD: {0}", paymentJSON);
                lastResponseJson = httpClient.post(url, paymentJSON);
                this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
                Payment paymentCreated = (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
                if (paymentCreated.getId() == null) {
                    MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                    throw new ConnectionException(500, error.toString());
                }
                return paymentCreated;
            } catch (Exception ex) {
                this.logger.log(Level.SEVERE, null, ex);
                throw new ConnectionException(500, ex.getMessage());
            }
        } else {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.");
        }
    }

    public Payment updatePayment(Payment payment) throws ConnectionException {
        try {
            String paymentJSON = JsonUtil.toJSON(payment);
            payment.validate();
            String url = String.format(this.templateUpdate, this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), payment.getId());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", paymentJSON);
            lastResponseJson = httpClient.post(url, paymentJSON);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            Payment paymentUpdated = (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
            if (paymentUpdated.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString());
            }
            return paymentUpdated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public boolean deletePayment(String id) throws ConnectionException {
        try {
            String url = String.format(this.templateDelete, this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
            this.logger.log(Level.INFO, "DELETE URL: {0}", url);
            lastResponseJson = httpClient.delete(url);
            this.logger.log(Level.INFO, "DELETE RESPONSE: {0}", lastResponseJson);
            DeletedEntityReturn deleted = (DeletedEntityReturn) JsonUtil.parse(lastResponseJson, DeletedEntityReturn.class);
            return deleted.getDeleted();
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
