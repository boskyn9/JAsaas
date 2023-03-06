/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.api;

import br.com.jasaas.adapter.AdapterConnection;
import br.com.jasaas.entity.WebhookConfig;
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
}
