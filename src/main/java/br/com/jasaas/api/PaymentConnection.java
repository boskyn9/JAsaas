package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.Payment;
import br.com.jasaas.entity.PaymentIdentificationField;
import br.com.jasaas.entity.PaymentPixQrCode;
import br.com.jasaas.entity.filter.PaymentFilter;
import br.com.jasaas.entity.meta.MetaPayment;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author bosco
 */
public class PaymentConnection extends AsaasConnection<Payment, PaymentFilter> {

    public PaymentConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente, httpClient, EndpointEnum.PAYMENT);
        this.metaGenericClass = MetaPayment.class;
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
        if (meta.getData().isEmpty()) {
            return null;
        }
        return meta.getData();
    }

    public List<Payment> getByExternalReference(String externalReference) throws ConnectionException {
        String url = String.format("%s/%s?externalReference=%s", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), externalReference);
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        MetaPayment meta = (MetaPayment) JsonUtil.parse(lastResponseJson, MetaPayment.class);
        if (meta.getData().isEmpty()) {
            return null;
        }
        return meta.getData();
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
        if (meta.getData().isEmpty()) {
            return null;
        }
        return meta.getData();
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
        if (meta.getData().isEmpty()) {
            return null;
        }
        return meta.getData();
    }

    public Payment createPayment(Payment payment) throws ConnectionException {
        return create(payment);
    }

    public Payment updatePayment(Payment payment) throws ConnectionException {
        return update(payment);
    }

    public boolean deletePayment(String id) throws ConnectionException {
        return delete(id);
    }

    public Payment refundPayment(String id) throws ConnectionException {
        String url = String.format("%s/%s/%s/refund", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
        this.logger.log(Level.INFO, "POST URL: {0}", url);
        lastResponseJson = httpClient.post(url, null);
        this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
        return (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
    }

    public PaymentIdentificationField identificationField(String id) throws ConnectionException {
        //todo: testar
        String url = String.format("%s/%s/%s/identificationField", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
        this.logger.log(Level.INFO, "POST URL: {0}", url);
        lastResponseJson = httpClient.post(url, null);
        this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
        return (PaymentIdentificationField) JsonUtil.parse(lastResponseJson, PaymentIdentificationField.class);
    }

    public PaymentPixQrCode pixQrCode(String id) throws ConnectionException {
        //todo: testar
        String url = String.format("%s/%s/%s/pixQrCode", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
        this.logger.log(Level.INFO, "POST URL: {0}", url);
        lastResponseJson = httpClient.post(url, null);
        this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
        return (PaymentPixQrCode) JsonUtil.parse(lastResponseJson, PaymentPixQrCode.class);
    }

    public Object receiveInCash(Object entity) throws ConnectionException {
        //todo: testar + impl
        String url = String.format("%s/%s/%s/receiveInCash", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), entity);
        String json = JsonUtil.toJSON(entity);
        this.logger.log(Level.INFO, "POST URL: {0}", url);
        this.logger.log(Level.INFO, "POST JSON: {0}", json);
        lastResponseJson = httpClient.post(url, json);
        this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
        return JsonUtil.parse(lastResponseJson, Object.class);
    }

    public Payment undoReceivedInCash(String id) throws ConnectionException {
        //todo: testar
        String url = String.format("%s/%s/%s/undoReceivedInCash", this.ambiente.getEndpoint(), EndpointEnum.PAYMENT.getEndpoint(), id);
        this.logger.log(Level.INFO, "POST URL: {0}", url);
        lastResponseJson = httpClient.post(url, null);
        this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
        return (Payment) JsonUtil.parse(lastResponseJson, Payment.class);
    }

}
