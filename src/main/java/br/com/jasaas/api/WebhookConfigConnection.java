/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.WebhookConfig;
import br.com.jasaas.enumeration.Ambiente;
import br.com.jasaas.enumeration.EndpointEnum;
import br.com.jasaas.exception.ConnectionException;
import br.com.jasaas.util.JsonUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atendimento
 */
public class WebhookConfigConnection extends AbstractConnection {

    private final AdapterConnection httpClient;
    private final Logger logger = Logger.getLogger(WebhookConfigConnection.class.getName());

    public WebhookConfigConnection(AdapterConnection httpClient, Ambiente ambiente) {
        super(ambiente);
        this.httpClient = httpClient;
    }

    public WebhookConfig get() throws ConnectionException {
        String url = String.format(super.templateGet, this.ambiente.getEndpoint(), EndpointEnum.WEBHOOK.getEndpoint());
        this.logger.log(Level.INFO, "GET URL: {0}", url);
        lastResponseJson = httpClient.get(url);
        this.logger.log(Level.INFO, "GET RESPONSE: {0}", lastResponseJson);
        return (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
    }

    public WebhookConfig createWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        return updateWebhookConfig(webhookConfig);
    }

    public WebhookConfig updateWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        try {
            String webhookConfigJSON = JsonUtil.toJSON(webhookConfig);
            String url = String.format(super.templateCreate, this.ambiente.getEndpoint(), EndpointEnum.WEBHOOK.getEndpoint());
            this.logger.log(Level.INFO, "POST URL: {0}", url);
            this.logger.log(Level.INFO, "POST DATA: {0}", webhookConfigJSON);
            lastResponseJson = httpClient.post(url, webhookConfigJSON);
            this.logger.log(Level.INFO, "POST RESPONSE: {0}", lastResponseJson);
            WebhookConfig subscriptionUpdated = (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
            return subscriptionUpdated;
        } catch (Exception ex) {
            this.logger.log(Level.SEVERE, null, ex);
            throw new ConnectionException(500, ex.getMessage());
        }
    }
}
