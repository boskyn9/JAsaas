/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intersistemas.jasaas.entity.meta;

import br.com.intersistemas.jasaas.entity.Erro;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import java.util.Arrays;

/**
 *
 * @author willian
 */
public class MetaError {

    @Expose
    private Erro[] errors;

    public Erro[] getErrors() {
        return errors;
    }

    public void setErrors(Erro[] errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
