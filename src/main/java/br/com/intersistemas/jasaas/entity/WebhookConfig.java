/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.entity;

import br.com.intersistemas.jasaas.util.PaymentEvent;
import br.com.intersistemas.jasaas.util.SendType;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 *
 * @author atendimento
 */
public class WebhookConfig {

    @Expose
    String id; // O Asaas agora retorna um ID para o webhook criado
    @Expose
    String name; // Nome para identificar o webhook (ex: "Webhook Controle Mais")
    @Expose
    String url;
    @Expose
    String email;
    @Expose
    Boolean interrupted;
    @Expose
    Boolean enabled;
    @Expose
    Integer apiVersion;
    @Expose
    String authToken;
    @Expose
    SendType sendType;
    @Expose
    List<PaymentEvent> events;

    /**
     *
     * @return Identificador único da configuração do webhook
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id Identificador único da configuração do webhook
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return Nome de identificação do webhook (ex: "Controle Mais")
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Nome de identificação do webhook (ex: "Controle Mais")
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return URL que receberá as informações de sincronização
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url URL que receberá as informações de sincronização
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return Email para receber as notificações em caso de erros na fila
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email Email para receber as notificações em caso de erros na fila
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return Situação da fila de sincronização
     */
    public Boolean getInterrupted() {
        return interrupted;
    }

    /**
     *
     * @param interrupted Situação da fila de sincronização
     */
    public void setInterrupted(Boolean interrupted) {
        this.interrupted = interrupted;
    }

    /**
     *
     * @return Habilitar ou não o webhook
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled Habilitar ou não o webhook
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     *
     * @return Versão utilizada da API.
     */
    public Integer getApiVersion() {
        return apiVersion;
    }

    /**
     *
     * @param apiVersion Versão utilizada da API.
     */
    public void setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     *
     * @return Token de autenticação arbitrário enviado no cabeçalho das requisições
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     *
     * @param authToken Token de autenticação arbitrário enviado no cabeçalho das requisições
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     *
     * @return Tipo de envio da fila (Sequencial ou Não-Sequencial)
     */
    public SendType getSendType() {
        return sendType;
    }

    /**
     *
     * @param sendType Tipo de envio da fila (Sequencial ou Não-Sequencial)
     */
    public void setSendType(SendType sendType) {
        this.sendType = sendType;
    }

    /**
     *
     * @return Lista de eventos assinados que dispararão este webhook
     */
    public List<PaymentEvent> getEvents() {
        return events;
    }

    /**
     *
     * @param events Lista de eventos assinados que dispararão este webhook
     */
    public void setEvents(List<PaymentEvent> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "WebhookConfig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", email='" + email + '\'' +
                ", interrupted=" + interrupted +
                ", enabled=" + enabled +
                ", apiVersion=" + apiVersion +
                ", authToken='" + authToken + '\'' +
                ", sendType=" + sendType +
                ", events=" + events +
                '}';
    }
}
