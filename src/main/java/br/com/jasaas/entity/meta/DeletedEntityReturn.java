/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jasaas.entity.meta;

import com.google.gson.annotations.Expose;

/**
 *
 * @author willian
 */
public class DeletedEntityReturn {

    @Expose private Boolean deleted;
    @Expose private String id;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
