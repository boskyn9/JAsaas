/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.api;

import br.com.intersistemas.jasaas.adapter.AdapterConnection;
import br.com.intersistemas.jasaas.entity.WebhookConfig;
import br.com.intersistemas.jasaas.entity.meta.MetaWebhookConfig;
import br.com.intersistemas.jasaas.exception.ConnectionException;
import br.com.intersistemas.jasaas.util.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author atendimento
 */
public class WebhookConfigConnection extends AbstractConnection {

    private final AdapterConnection adapter;

    public WebhookConfigConnection(AdapterConnection adapter, int abstractConnectionEndpoint) {
        super(abstractConnectionEndpoint);
        this.adapter = adapter;
    }

    /**
     * Recupera o primeiro Webhook encontrado na conta.
     * <p>
     * <b>Adaptação V3:</b> Como a API V3 retorna uma lista (/webhooks), este método
     * reutiliza o {@link #getAll()} e retorna apenas o primeiro item para manter compatibilidade.
     *
     * @return O primeiro WebhookConfig ou <code>null</code> se a lista estiver vazia.
     * @throws ConnectionException Em caso de erro de conexão.
     */
    public WebhookConfig get() throws ConnectionException {
        List<WebhookConfig> lista = this.getAll();

        if (lista != null && !lista.isEmpty()) {
            return lista.get(0);
        }

        return null;
    }

    /**
     * Recupera um Webhook específico pelo ID.
     * Endpoint: GET /webhooks/{id}
     */
    public WebhookConfig getById(String id) throws ConnectionException {
        // Atenção ao endpoint no plural: /webhooks/
        lastResponseJson = adapter.get((endpoint + "/webhooks/" + id));
        return (WebhookConfig) JsonUtil.parse(lastResponseJson, WebhookConfig.class);
    }

    /**
     * Lista todos os webhooks configurados (GET /webhooks).
     * <p>
     * Este método processa a resposta da API, atualiza automaticamente os controles de
     * paginação na classe pai (hasMore, limit, offset) e retorna a lista de dados.
     *
     * @return Lista de {@link WebhookConfig}.
     * @throws ConnectionException Em caso de erro na comunicação.
     */
    public List<WebhookConfig> getAll() throws ConnectionException {
        // Faz a requisição GET
        lastResponseJson = adapter.get((endpoint + "/webhooks"));

        // 1. Usa a classe Meta específica que acabamos de criar
        MetaWebhookConfig meta = (MetaWebhookConfig) JsonUtil.parse(lastResponseJson, MetaWebhookConfig.class);

        // 2. Popula os campos da classe pai para controle de paginação
        this.setHasMore(meta.getHasMore());
        this.setLimit(meta.getLimit());
        this.setOffset(meta.getOffset());

        // 3. Retorna os dados.
        // Se o JSON vier sem dados (null), retornamos uma lista vazia para evitar erro no Controle Mais
        if (meta.getData() != null) {
            return Arrays.asList(meta.getData());
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Cria um NOVO webhook.
     * Endpoint: POST /webhooks
     */
    public WebhookConfig createWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        // Na criação, não passamos ID na URL
        String webhookConfigJSON = JsonUtil.toJSON(webhookConfig);

        // POST na raiz da coleção (/webhooks)
        String data = adapter.post((endpoint + "/webhooks"), webhookConfigJSON);

        return (WebhookConfig) JsonUtil.parse(data, WebhookConfig.class);
    }

    /**
     * Atualiza um webhook existente.
     * Endpoint: POST /webhooks/{id}
     */
    public WebhookConfig updateWebhookConfig(WebhookConfig webhookConfig) throws ConnectionException {
        System.out.println("updateWebhookConfig");
        if (webhookConfig.getId() == null) {
            throw new ConnectionException(500, "Para atualizar, o objeto WebhookConfig precisa ter um ID.");
        }

        String webhookConfigJSON = JsonUtil.toJSON(webhookConfig);

        // POST na URL específica do ID (/webhooks/id_do_webhook)
        String data = adapter.put((endpoint + "/webhooks/" + webhookConfig.getId()), webhookConfigJSON);

        return (WebhookConfig) JsonUtil.parse(data, WebhookConfig.class);
    }

    /**
     * Remove um webhook existente.
     * Endpoint: DELETE /webhooks/{id}
     */
    public boolean deleteWebhookConfig(String id) throws ConnectionException {
        try {
            // O adapter lança exceção se o status não for 200
            String response = adapter.delete(endpoint + "/webhooks/" + id);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
