/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 *
 * @author atendimento
 */
public class WebhookConfig {

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

    @Override
    public String toString() {
        return "WebhookConfig{" + "url=" + url + ", email=" + email + ", interrupted=" + interrupted + ", enabled=" + enabled + ", apiVersion=" + apiVersion + '}';
    }
}
