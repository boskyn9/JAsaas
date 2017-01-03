/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.entity;

import com.google.gson.annotations.Expose;

/**
 *
 * @author willian
 */
public class Erro {

    @Expose
    private String code;
    @Expose
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Erro{" + "code=" + code + ", description=" + description + '}';
    }
}
