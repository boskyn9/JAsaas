/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.WebhookConfig;
import br.com.jasaas.entity.meta.MetaError;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.enumeration.EnvironmentAsaas;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.logging.Level;

/**
 *
 * @author atendimento
 */
public class WebhookConfigConnection extends AsaasConnection<WebhookConfig, Object> {

    public WebhookConfigConnection(AdapterConnection httpClient, EnvironmentAsaas environmentAsaas) {
        super(environmentAsaas, httpClient, EndpointEnum.WEBHOOK);
        this.metaGenericClass = WebhookConfig.class;
    }

    public WebhookConfig get() throws ConnectionException {
        String url = String.format(super.templateGet, this.environmentAsaas.getEndpoint(), EndpointEnum.WEBHOOK.getEndpoint());
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
    }

    public WebhookConfig createWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        return create(webhookConfig);
    }

    public WebhookConfig updateWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        return update(webhookConfig);
    }

    public WebhookConfig createWebhookPayment(WebhookConfig webhookConfig) throws ConnectionException {
        return create(webhookConfig);
    }

    public WebhookConfig createWebhoookInvoice(WebhookConfig entity) throws ConnectionException {
        if (entity.getId() != null) {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.", null);
        }
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format("%s/%s/invoice", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig created = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            if (created.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return created;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public WebhookConfig createWebhoookTransfer(WebhookConfig entity) throws ConnectionException {
        if (entity.getId() != null) {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.", null);
        }
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format("%s/%s/transfer", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig created = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            if (created.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return created;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public WebhookConfig createWebhoookBill(WebhookConfig entity) throws ConnectionException {
        if (entity.getId() != null) {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.", null);
        }
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format("%s/%s/bill", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig created = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            if (created.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return created;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public WebhookConfig createWebhoookAnticipation(WebhookConfig entity) throws ConnectionException {
        if (entity.getId() != null) {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.", null);
        }
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format("%s/%s/anticipation", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig created = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            if (created.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return created;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

    public WebhookConfig createWebhoookMobilePhoneRecharge(WebhookConfig entity) throws ConnectionException {
        if (entity.getId() != null) {
            throw new ConnectionException(500, "You should not enter the id in the entity to create it.", null);
        }
        try {
            String json = JsonUtil.toJSON(entity);
            String url = String.format("%s/%s/mobilePhoneRecharge", this.environmentAsaas.getEndpoint(), this.endpoint.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST PAYLOAD: {0}", json);
            lastResponseJson = httpClient.post(url, json);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig created = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            if (created.getId() == null) {
                MetaError error = (MetaError) JsonUtil.parse(lastResponseJson, MetaError.class);
                throw new ConnectionException(500, error.toString(), error);
            }
            return created;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            if (ex instanceof ConnectionException) {
                throw ex;
            }
            throw new ConnectionException(500, ex.getMessage());
        }
    }

}
